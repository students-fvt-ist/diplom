package ru.sfedu.mydiplom.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import ru.sfedu.mydiplom.model.dto.Automobile;
import ru.sfedu.mydiplom.model.dto.TestEntity;
import ru.sfedu.mydiplom.model.dto.singletable.AccountSingleTable;
import static ru.sfedu.mydiplom.utils.IDGenerator.getIDGenerator;

public class HibernateDataProviderTest {
    
    @Test
    public void testGetTablies() {
        System.out.println("getTables");
        HibernateDataProvider hdp = new HibernateDataProvider();
        List results = hdp.getTablies();
        results .forEach(res ->{
            System.out.println(res);
        });
    }
    
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        HibernateDataProvider hdp = new HibernateDataProvider();
        List<Object[]> results = hdp.getUsers();
        results.forEach(res ->{
            System.out.println("user - "+res[0]+" ; host - "+res[1]);
        });
    }
    
    @Test
    public void testGetDataLength() {
        System.out.println("getDataLength");
        HibernateDataProvider hdp = new HibernateDataProvider();
        List results = hdp.getDataLength();
        results.forEach(res ->{
            System.out.println(res);
        });
    }
    
    @Test
    public void testSaveTest(){
        HibernateDataProvider hdp = new HibernateDataProvider();
        hdp.saveTest(generateTestEntity(10));
    }
    
    @Test
    public void testGetTest(){
        HibernateDataProvider hdp = new HibernateDataProvider();
        System.out.println(hdp.getTest(1490031270800l).get());
    }
    
    @Test
    public void testGetAllTest(){
        HibernateDataProvider hdp = new HibernateDataProvider();
        
        List l = hdp.getAllTest();
        for (Object object : l) {
            System.out.println(object);
        }
    }
    
    
    @Test
    public void testDeleteTest(){
        HibernateDataProvider hdp = new HibernateDataProvider();
        List<TestEntity> item = generateTestEntity(1);
        hdp.saveTest(item);
        hdp.deleteTest(item.get(0));
    }
    
    @Test
    public void testUpdateTest(){
        HibernateDataProvider hdp = new HibernateDataProvider();
        List<TestEntity> item = generateTestEntity(1);
        hdp.saveTest(item);
        item.get(0).setName("Changed");
        hdp.updateTest(item);
    }
    
    private List<TestEntity> generateTestEntity(int count){
        List<TestEntity> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new TestEntity(getIDGenerator().getID(), "name"+i, "description"+i, new Date(), true, new Automobile("Owen vender"+i, "Owen model"+i, "Owen number"+i), new Automobile("Work vender"+i, "Work model"+i, "Work number"+i)));
        }
        return list;
    }
    
    private Optional testt(Optional optional){
        return optional;
    }
    
    @Test
    public void testT(){
        Optional<AccountSingleTable> sOptional;
        sOptional = Optional.ofNullable(new AccountSingleTable(getIDGenerator().getID(), BigDecimal.ONE, "owner", BigDecimal.ZERO));
        Optional optional;
        optional = Optional.ofNullable(testt(sOptional));
        System.out.println(optional.get().toString());
    }
}
