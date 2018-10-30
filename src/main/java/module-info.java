module hibernate.in.jdk.ten {

    requires java.persistence;
    requires java.xml;
    requires java.naming;

    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;

    requires org.junit.jupiter.api;
    requires org.apiguardian.api;
    requires org.opentest4j;

    opens com.imos.model;
    exports com.imos.utils;
}
