package ru.sfedu.mydiplom.dao.xml;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.XmlAPI;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.*;

public class XmlApiDeleteTest {
    
    @Test
    public void testDeleteApplications() throws Exception {
        System.out.println("Delete Applications");
        Result res = new Result(StatusType.ERROR.toString());
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.APP).get();
            Applications app = (Applications) result.get(0);
            if (result.isEmpty()) {
                throw new Exception("List is empty");
            }
            res = instance.delete(app);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectApplication();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }    
    
    @Test
    public void testDeleteClients() throws Exception {
        System.out.println("Delete Clients");
        Result res = new Result(StatusType.ERROR.toString());
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.CLT).get();
            if (result.isEmpty()) {
                throw new Exception("List is empty");
            }
            Clients clients = (Clients) result.get(0);
            res = instance.delete(clients);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectClient();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }   
    
    @Test
    public void testDeleteDelay() throws Exception {
        System.out.println("Delete Delay");
        Result res = new Result(StatusType.ERROR.toString());
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.DLY).get();
            Delay app = (Delay) result.get(0);
            if (result.isEmpty()) {
                throw new Exception("List is empty");
            }
            res = instance.delete(app);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectDelay();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }   
    
    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Delete Payment");
        Result res = new Result(StatusType.ERROR.toString());
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.PMT).get();
            Payments app = (Payments) result.get(0);
            if (result.isEmpty()) {
                throw new Exception("List is empty");
            }
            res = instance.delete(app);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectPayment();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }   
    
    @Test
    public void testDeleteTypeCredits() throws Exception {
        System.out.println("Delete TypeCredits");
        Result res = new Result(StatusType.ERROR.toString());
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.TCD).get();
            TypeCredits app = (TypeCredits) result.get(0);
            if (result.isEmpty()) {
                throw new Exception("List is empty");
            }
            res = instance.delete(app);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectTypeCredits();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }   
}
