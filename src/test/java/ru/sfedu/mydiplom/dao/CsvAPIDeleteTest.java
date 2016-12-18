package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class CsvAPIDeleteTest {
    /**
     * Test of Delete method, of class CsvAPI.
     */
    @Test
    public void testDeleteApplication() throws Exception {
        System.out.println("Delete Application");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("sum", "0.0", ClassType.APP);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testDeleteClient() throws Exception {
        System.out.println("Delete Client");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("dateOfBirth", "0", ClassType.CLT);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testDeleteCredit() throws Exception {
        System.out.println("Delete Credit");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("status", "0", ClassType.CRD);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Delete Payment");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("credit", "0", ClassType.PMT);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testDeleteTypeCredits() throws Exception {
        System.out.println("Delete Type of Credits");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("sumOf", "0.0", ClassType.TCD);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
    
    @Test
    public void testDeleteDelay() throws Exception {
        System.out.println("Delete Delay");
        CsvAPI instance = new CsvAPI();
        Result expResult = new Result();
        Result result = null;
        expResult.setStatus(StatusType.OK.toString());
        result=instance.delete("sum", "0.0", ClassType.DLY);
        assertEquals(expResult.getStatus(), result.getStatus());
    }
}
