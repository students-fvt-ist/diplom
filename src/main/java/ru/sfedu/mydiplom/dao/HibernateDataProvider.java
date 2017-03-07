package ru.sfedu.mydiplom.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.mydiplom.model.dto.TestEntity;
import static ru.sfedu.mydiplom.utils.IDGenerator.getIDGenerator;

public class HibernateDataProvider {
    
    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List getTablies(){
        return session.getNamedNativeQuery("GET_TABLIES_QUERY").getResultList();
    }
    
    public List<Object[]> getUsers(){
        return session.getNamedNativeQuery("GET_USERS_QUERY").getResultList();
    }
    
    public List getDataLength(){
       return session.getNamedNativeQuery("GET_DATA_LENGTH").getResultList();
    }
    
    public void setTest(){
        TestEntity entity = new TestEntity(getIDGenerator().getID(), "name", "description", new Date(System.currentTimeMillis()), Boolean.TRUE);
        Transaction tranc = session.beginTransaction();
        session.persist(entity);
        session.saveOrUpdate(entity);
        tranc.commit();
    }
}
