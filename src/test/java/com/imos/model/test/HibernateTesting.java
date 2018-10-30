package com.imos.model.test;

import com.imos.model.Person;
import com.imos.utils.HibernateService;
import com.imos.utils.RepositoryException;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author alok.meher
 */
public class HibernateTesting {

    private static final HibernateService SERVICE = HibernateService.INSTANCE;
    private Session session;

    @BeforeAll
    public static void setUp() throws RepositoryException {
        SERVICE.config();
    }

    @AfterAll
    public static void shutdown() throws RepositoryException {
        SERVICE.shutDown();
    }

    @BeforeEach
    public void setUpForTest() throws RepositoryException {
        session = SERVICE.openConnection();
    }

    @AfterEach
    public void shutdownForTest() throws RepositoryException {
        SERVICE.closeConnection(session);
    }

    @Test
    public void modelTesting() throws Exception {
        assertTrue(true);

        Person p = new Person();
        p.setName("Alok");
        p.setDateOfBirth(LocalDate.now());
        assertEquals("Alok", p.getName());

        Transaction tran = session.beginTransaction();
        try {
            session.save(p);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        }

        SERVICE.closeConnection(session);

        session = SERVICE.openConnection();

        List<Person> result = session.createQuery("from Person p", Person.class)
                .setHint("org.hibernate.cacheable", true)
                .getResultList();
        System.out.println("Called once");
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("Alok", result.get(0).getName());

        result = session.createQuery("from Person p", Person.class)
                .setHint("org.hibernate.cacheable", true)
                .getResultList();
        System.out.println("Called twice");
        p = result.get(0);

        SERVICE.closeConnection(session);

        session = SERVICE.openConnection();

        tran = session.beginTransaction();
        try {
            session.delete(p);
            tran.commit();
        } catch (Exception e) {
            tran.rollback();
        }

        SERVICE.closeConnection(session);

        session = SERVICE.openConnection();

        result = session.createQuery("from Person p", Person.class)
                .setHint("org.hibernate.cacheable", true)
                .getResultList();
        System.out.println("Called thrice");
        SERVICE.closeConnection(session);

        session = SERVICE.openConnection();

        result = session.createQuery("from Person p", Person.class)
                .setHint("org.hibernate.cacheable", true)
                .getResultList();
        System.out.println("Called 4 times");
        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }
}
