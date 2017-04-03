package ru.sfedu.mydiplom.dao;

import java.io.File;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import static ru.sfedu.mydiplom.Constants.*;
import ru.sfedu.mydiplom.model.dto.*;
import ru.sfedu.mydiplom.model.dto.mappedsuperclass.*;
import ru.sfedu.mydiplom.model.dto.tableperclass.*;
import ru.sfedu.mydiplom.model.dto.joinedtable.*;
import ru.sfedu.mydiplom.model.dto.singletable.*;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.getConfigurationEntry;

public class HibernateUtil {
    
private static final SessionFactory sessionFactory = configureSessionFactory();
private static ServiceRegistry serviceRegistry;

    /**
    * Создание фабрики
    * @throws HibernateException
    */
    private static SessionFactory configureSessionFactory() throws HibernateException{
        Configuration configuration;
        String path;
        try {
            path = getConfigurationEntry(HIBERNATE_CONF);
        }catch(IOException e){
            path=null;
        }
        if (path == null){
            configuration = new Configuration().configure();
        }else{
            File file = new File(path);
            configuration = new Configuration().configure(file);
        }
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        MetadataSources source = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Applications.class)
                .addAnnotatedClass(Clients.class)
                .addAnnotatedClass(Delay.class)
                .addAnnotatedClass(Payments.class)
                .addAnnotatedClass(TypeCredits.class)
                .addAnnotatedClass(TestEntity.class)
                .addAnnotatedClass(AccountMappedSuperclass.class)
                .addAnnotatedClass(CreditAccountMappedSuperclass.class)
                .addAnnotatedClass(DebitAccountMappedSuperclass.class)
                .addAnnotatedClass(AccountTablePerClass.class)
                .addAnnotatedClass(CreditAccountTablePerClass.class)
                .addAnnotatedClass(DebitAccountTablePerClass.class)
                .addAnnotatedClass(AccountSingleTable.class)
                .addAnnotatedClass(CreditAccountSingleTable.class)
                .addAnnotatedClass(DebitAccountSingleTable.class)
                .addAnnotatedClass(AccountJoinedTable.class)
                .addAnnotatedClass(CreditAccountJoinedTable.class)
                .addAnnotatedClass(DebitAccountJoinedTable.class)
                .addResource("named-queries.hbm.xml");
        SessionFactory sessionFactory = source.buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    /**
    * Получить фабрику сессий
    * @return {@link SessionFactory}
    */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}