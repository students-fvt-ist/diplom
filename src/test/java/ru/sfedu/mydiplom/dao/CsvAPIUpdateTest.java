package ru.sfedu.mydiplom.dao;

import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ru.sfedu.mydiplom.exception.RecordNotFoundException;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.ResultWithValue;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.*;
import ru.sfedu.mydiplom.model.dto.ClassType;

public class CsvAPIUpdateTest {
    private static final Logger log = Logger.getLogger(CsvAPI.class);
    
    /**
     * Test of Update method, of class CsvAPI.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateApplication() throws Exception {
        System.out.println("Update Application");
        CsvAPI instance = new CsvAPI();
        Applications cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("sum", "70000.0", ClassType.APP);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (Applications) resultSelect.getValue().get(i);
                cur.setSum(cur.getSum()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
    
    @Test
    public void testUpdateClient() throws Exception {
        System.out.println("Update Client");
        CsvAPI instance = new CsvAPI();
        Clients cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("dateOfBirth", "2", ClassType.CLT);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (Clients) resultSelect.getValue().get(i);
                cur.setDateOfBirth(cur.getDateOfBirth()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
    
    @Test
    public void testUpdateCredit() throws Exception {
        System.out.println("Update Credit");
        CsvAPI instance = new CsvAPI();
        Credits cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("status", "2", ClassType.CRD);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (Credits) resultSelect.getValue().get(i);
                cur.setStatus(cur.getStatus()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
    
    @Test
    public void testUpdatePayment() throws Exception {
        System.out.println("Update Payment");
        CsvAPI instance = new CsvAPI();
        Payments cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("credit", "2", ClassType.PMT);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (Payments) resultSelect.getValue().get(i);
                cur.setCredit(cur.getCredit()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
    
    @Test
    public void testUpdateTypeCredits() throws Exception {
        System.out.println("Update Type of Credits");
        CsvAPI instance = new CsvAPI();
        TypeCredits cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("sumOf", "2.0", ClassType.TCD);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (TypeCredits) resultSelect.getValue().get(i);
                cur.setSumOf(cur.getSumOf()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
    
    @Test
    public void testUpdateDelay() throws Exception {
        System.out.println("Update Delay");
        CsvAPI instance = new CsvAPI();
        Delay cur;
        ResultWithValue resultSelect;
        Result result;
        String assertValue = StatusType.OK.toString();
        try{
            resultSelect = instance.select("sum", "2.0", ClassType.DLY);
            if (resultSelect.getValue().isEmpty()) {
                throw new RecordNotFoundException(0);
            }
            for (int i = 0; i < resultSelect.getValue().size(); i++) {
                cur = (Delay) resultSelect.getValue().get(i);
                cur.setSum(cur.getSum()*100);
                result=instance.update(resultSelect.getValue().get(i));
                if (result.getStatus().equals(StatusType.ERROR.toString())) {
                    assertValue=result.getStatus();
                }
            }
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
        }catch(Exception e){
            log.debug(e.getMessage());
        }
        assertEquals(StatusType.OK.toString(), assertValue);
    }
}
