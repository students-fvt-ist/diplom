package ru.sfedu.mydiplom.dao;

import ru.sfedu.mydiplom.model.dto.Applications;
import ru.sfedu.mydiplom.model.dto.Delay;
import ru.sfedu.mydiplom.model.dto.Clients;
import ru.sfedu.mydiplom.model.dto.Payments;
import ru.sfedu.mydiplom.model.dto.TypeCredits;
import ru.sfedu.mydiplom.model.dto.Credits;
import ru.sfedu.mydiplom.model.dto.GenericDto;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.ClassType;

public class CsvAPIInsertTest {
    private static Logger log = Logger.getLogger(MyDiplomClient.class);

    //TODO Прикольный тест
//    public CsvAPIInsertTest() {
//    }
//    @Test
//    public void t()throws Exception{
//        for (long i = Long.MIN_VALUE; i < Long.MAX_VALUE; i++) {
//            
//        testInsertApplication();
//        }
//    }

    /**
     * Test of Insert method, of class CsvAPI.
     */
    @Test
    public void testInsertApplication() throws Exception {
        try {
            System.out.println("Insert Application");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result;
            Applications obj;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new Applications(System.currentTimeMillis(), i*35000, 0, 20, 10, System.currentTimeMillis(), 0, 0);
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }

    @Test
    public void testInsertClient() throws Exception {
        try {
            System.out.println("Insert Client");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result = null;
            Clients obj = null;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new Clients(System.currentTimeMillis(), i, 0, 0, 0, 0, 0, 0, true, true, true, "Name", "Work", "Street", "234567", "276543", "pd", "null");
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertCredit() throws Exception {
        try {
            System.out.println("Insert Credits");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result = null;
            Credits obj = null;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new Credits(System.currentTimeMillis(), i, 0, 0);
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertPayment() throws Exception {
        try {
            System.out.println("Insert Payment");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result = null;
            Payments obj = null;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new Payments(System.currentTimeMillis(), System.currentTimeMillis(), i);
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertTypeCredits() throws Exception {
        try {
            System.out.println("Insert Type of Credits");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result = null;
            TypeCredits obj = null;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new TypeCredits(System.currentTimeMillis(), "Name", i, i, i, i, i, i);
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
    @Test
    public void testInsertDelay() throws Exception {
        try {
            System.out.println("Insert Delay");
            CsvAPI instance = new CsvAPI();
            Result expResult = new Result();
            Result result = null;
            Delay obj = null;
            expResult.setStatus(StatusType.OK.toString());
            for (int i = 0; i < 10; i++) {
                obj = new Delay(System.currentTimeMillis(), i, i, i);
                result = instance.insert(obj);
                assertEquals(expResult.getStatus(), result.getStatus());
            }
        } catch (Exception e) {
            log.error("Error: "+e);
            throw e;
        }
    }
    
}
