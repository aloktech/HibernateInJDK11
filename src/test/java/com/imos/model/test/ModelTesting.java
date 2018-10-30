package com.imos.model.test;


import com.imos.model.Person;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
/**
 *
 * @author alok.meher
 */
public class ModelTesting {

    @Test
    public void modelTesting() {
        assertTrue(true);

        Person p = new Person();
        p.setName("Alok");
//        p.setDateOfBirth(LocalDate.now());

        Assertions.assertEquals("Alok", p.getName());
    }
}
