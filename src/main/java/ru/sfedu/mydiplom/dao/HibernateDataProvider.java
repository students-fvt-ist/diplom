package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.mydiplom.model.dto.TestEntity;
import static java.util.Optional.ofNullable;

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
    
    public void saveTest(List<TestEntity> list){
        Transaction tranc = session.beginTransaction();
        list.stream().forEachOrdered((item) -> session.saveOrUpdate(item));
        tranc.commit();
    }   
    
    public void deleteTest(List<TestEntity> list){
        Transaction tranc = session.beginTransaction();
        list.stream().forEachOrdered((item) -> session.delete(item));
        tranc.commit();
    }
    
    public void deleteTest(TestEntity item){
        List<TestEntity> list = new ArrayList<>(1);
        list.add(item);
        deleteTest(list);
    }
    
    public void updateTest(List<TestEntity> list){
        Transaction tranc = session.beginTransaction();
        list.stream().forEachOrdered((item) -> session.update(item));
        tranc.commit();
    } 
    
    public Optional<TestEntity> getTest(long id){
        Optional<TestEntity> item;
        Transaction tranc = session.beginTransaction();
        item = ofNullable(session.get(TestEntity.class, id));
        tranc.commit();
        return item;
    }   
}
