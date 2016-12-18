package ru.sfedu.mydiplom.dao;

import ru.sfedu.mydiplom.model.dto.*;
import ru.sfedu.mydiplom.model.dto.GenericDto;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.*;
import ru.sfedu.mydiplom.model.*;

public class CsvAPIInsertTest {
    private static final Logger log = Logger.getLogger(Main.class);

    /**
     * Test of Insert method, of class CsvAPI.
     * @throws java.lang.Exception
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
                obj = new Applications(i*35000, 0, 20, 10, System.currentTimeMillis(), 0, 0, 0, System.currentTimeMillis());
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
