package ru.sfedu.mydiplom.dao.xml;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.XmlAPI;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.*;

public class XmlAPIUpdateTest {

    @Test
    public void testDeleteApplications() throws Exception {
        System.out.println("Update Applications");
        Result res = null;
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.APP).get();
            Applications payment = (Applications) result.get(11);
            payment.setDate(101l);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectApplication();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }

    @Test
    public void testDeleteClients() throws Exception {
        System.out.println("Update Clients");
        Result res = null;
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.CLT).get();
            Clients payment = (Clients) result.get(4);
            payment.setPassportNumber(10001);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectClient();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }

    @Test
    public void testDeleteDelay() throws Exception {
        System.out.println("Update Delay");
        Result res = null;
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.DLY).get();
            Delay payment = (Delay) result.get(4);
            payment.setDate(10001l);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectDelay();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }

    @Test
    public void testDeletePayment() throws Exception {
        System.out.println("Update Payment");
        Result res = null;
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.PMT).get();
            Payments payment = (Payments) result.get(4);
            payment.setDate(10001l);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectPayment();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }

    @Test
    public void testDeleteTypeCredits() throws Exception {
        System.out.println("Update Tipe Credits");
        Result res = null;
        try {
            XmlAPI instance = new XmlAPI();
            List<GenericDto> result;
            result = instance.select(ClassType.TCD).get();
            TypeCredits payment = (TypeCredits) result.get(11);
            payment.setRateUp(10001f);
            res = instance.update(payment);
            XmlAPISelectTest selectTest = new XmlAPISelectTest();
            selectTest.testSelectTypeCredits();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertEquals(res.getStatus(), StatusType.OK.toString());
    }
}
