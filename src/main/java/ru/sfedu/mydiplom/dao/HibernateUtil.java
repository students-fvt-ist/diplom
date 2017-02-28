package ru.sfedu.mydiplom.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
    
private static final SessionFactory sessionFactory = configureSessionFactory();
private static ServiceRegistry serviceRegistry;

    /**
    * Создание фабрики
    * @throws HibernateException
    */
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration().configure();
        //serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
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