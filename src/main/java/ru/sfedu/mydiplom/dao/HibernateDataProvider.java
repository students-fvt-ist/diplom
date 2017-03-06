package ru.sfedu.mydiplom.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HibernateDataProvider {
    
    private static final String GET_TABLIES_QUERY = "show tables;"; 
    private static final String GET_USERS_QUERY = "select user, host from mysql.user;"; 
    private static final String GET_DATA_LENGTH = "select sum(data_length/1024/1024) from information_schema.tables;"; 
    
    
    public List getTablies(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createNativeQuery(GET_TABLIES_QUERY).getResultList();
    }
    
    public List<Object[]> getUsers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createNativeQuery(GET_USERS_QUERY).getResultList();
    }
    
    public List getDataLength(){
       Session session = HibernateUtil.getSessionFactory().openSession();
       return session.createNativeQuery(GET_DATA_LENGTH).getResultList();
    }
}
