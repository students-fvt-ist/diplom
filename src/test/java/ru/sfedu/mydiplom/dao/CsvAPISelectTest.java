package ru.sfedu.mydiplom.dao;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class CsvAPISelectTest {
    private static final Logger log = Logger.getLogger(MyDiplomClient.class);

    /**
     * Test of Selects method, of class CsvAPI.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectApplication() throws Exception {
        System.out.println("Select Application");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result;
        result = instance.select("sum", "35000.0", ClassType.APP);
        result.getValue().addAll(instance.select(ClassType.APP).getValue());
        for (GenericDto obj : result.getValue()) {
            log.trace(obj);
        }
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testSelectClient() throws Exception {
        System.out.println("Select Client");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result = instance.select("dateOfBirth", "2", ClassType.CLT);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testSelectCredit() throws Exception {
        System.out.println("Select Credit");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result = instance.select("status", "2", ClassType.CRD);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testSelectPayment() throws Exception {
        System.out.println("Select Payment");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result = instance.select("credit", "2", ClassType.PMT);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testSelectTypeCredits() throws Exception {
        System.out.println("Select Type of Credits");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result = instance.select("sumOf", "2.0", ClassType.TCD);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testSelectDelay() throws Exception {
        System.out.println("Select Credit");
        CsvAPI instance = new CsvAPI();
        ResultWithValue expResult = new ResultWithValue();
        expResult.setStatus(StatusType.OK.toString());
        ResultWithValue result = instance.select("sum", "2.0", ClassType.DLY);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
}
