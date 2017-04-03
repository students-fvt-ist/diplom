package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.mydiplom.dao.HibernateUtil;

/**
 *
 * @author seyran
 */
public class AccountDataProvider{
    
    private static final Session session = HibernateUtil.getSessionFactory().openSession();
    
    public void saveOrUpdate(Optional<List> instance) {
        List list = instance.get();
        Transaction tranc = session.beginTransaction();
        list.forEach((item) -> {
            session.persist(item); 
            session.saveOrUpdate(item);
        });
        tranc.commit();
    }
    
    public Optional get(long id, Class clazz) {
        Optional item;
        Transaction tranc = session.beginTransaction();
        item = ofNullable(session.get(clazz, id));
        tranc.commit();
        return item;
    }
    
    public void delete(Optional instance) {
        Optional<List> vOptional;
        List list = new ArrayList<>(1);
        list.add(instance.get());
        vOptional = ofNullable(list);
        deleteMulti(vOptional);
    }
    
    public void deleteMulti(Optional<List> instance){
        Transaction tranc = session.beginTransaction();
        instance.get().forEach((item) -> session.delete(item));
        tranc.commit();
    }
}
