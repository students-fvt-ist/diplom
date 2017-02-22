package ru.sfedu.mydiplom.dao.xml;

import java.util.ArrayList;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.XmlAPI;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.ApplicationStatusType;
import ru.sfedu.mydiplom.model.dto.Applications;
import ru.sfedu.mydiplom.model.dto.Clients;
import ru.sfedu.mydiplom.model.dto.Delay;
import ru.sfedu.mydiplom.model.dto.GenericDto;
import ru.sfedu.mydiplom.model.dto.Payments;
import ru.sfedu.mydiplom.model.dto.TypeCredits;

public class XmlAPIInsertTest {
    @Test
    public void testInsertApplication() throws Exception {
        System.out.println("insert applications");
        Result result;
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Applications(i, i, i, i, ApplicationStatusType.APP, i, i, System.currentTimeMillis()));
        }
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInsertClients() throws Exception {
        System.out.println("insert clients");
        Result result;
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Clients(System.currentTimeMillis(), i, i, i, i, i, i, i, true, true, true, "name", "placeOfWorking", "addres", "phone", "workPhone", "passportData", "otherDocument"));
        }
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInsertDelay() throws Exception {
        System.out.println("insert delay");
        Result result;
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Delay(System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis(), System.currentTimeMillis()));
        }
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testInsertPayment() throws Exception {
        System.out.println("insert payment");
        Result result;
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Payments(System.currentTimeMillis(), System.currentTimeMillis(), i));
        }
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInsertTypeCredits() throws Exception {
        System.out.println("insert type credits");
        Result result;
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new TypeCredits(System.currentTimeMillis(), "Name"+i, i, i, i, i, i, i));
        }
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }
}
