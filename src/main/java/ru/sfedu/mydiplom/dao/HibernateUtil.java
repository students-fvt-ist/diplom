package ru.sfedu.mydiplom.dao;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import static ru.sfedu.mydiplom.Constants.HIBERNATE_CONF;

public class HibernateUtil {
    
private static final SessionFactory sessionFactory = configureSessionFactory();
private static ServiceRegistry serviceRegistry;

    /**
    * Создание фабрики
    * @throws HibernateException
    */
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration;
        String path = System.getProperty(HIBERNATE_CONF);
        if (path == null){
            configuration = new Configuration().configure();
        }else{
            File file = new File(path);
            configuration = new Configuration().configure(file);
        }
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    /**
    * Получить фабрику сессий
    * @return {@link SessionFactory}
    */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}