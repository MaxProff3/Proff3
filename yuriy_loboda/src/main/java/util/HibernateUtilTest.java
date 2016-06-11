package util;

import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtilTest {
private static final SessionFactory sessionFactorytest = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("homework/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
           
            return new Configuration().configure().
            		buildSessionFactory(standardServiceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactorytest;
    }

    public static Session getSession() {
        return sessionFactorytest.openSession();
    }

}
