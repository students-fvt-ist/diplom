package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.mydiplom.model.dto.TestEntity;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
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
        list.forEach((item) -> {
            session.persist(item); 
            session.saveOrUpdate(item);
        });
        tranc.commit();
    }   
    
    public void deleteTest(List<TestEntity> list){
        Transaction tranc = session.beginTransaction();
        list.forEach((item) -> session.delete(item));
        tranc.commit();
    }
    
    public void deleteTest(TestEntity item){
        List<TestEntity> list = new ArrayList<>(1);
        list.add(item);
        deleteTest(list);
    }
    
    public void updateTest(List<TestEntity> list){
        Transaction tranc = session.beginTransaction();
        list.forEach((item) -> session.update(item));
        tranc.commit();
    } 
    
    public Optional<TestEntity> getTest(long id){
        Optional<TestEntity> item;
        Transaction tranc = session.beginTransaction();
        item = ofNullable(session.get(TestEntity.class, id));
        tranc.commit();
        return item;
    }   
    
    public List<TestEntity> getAllTest(){
        List<TestEntity> list = new ArrayList<>();
        Transaction tranc = session.beginTransaction();
        list = session.byMultipleIds(TestEntity.class).multiLoad(1490031270800l, 1490031270799l, 1490031270798l);
        tranc.commit();
        C3P0ConnectionProvider as = new C3P0ConnectionProvider();
        return list;
    }  
}
