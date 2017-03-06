package ru.sfedu.mydiplom.dao;

import java.util.List;
import org.junit.Test;

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
    
}
