package ru.sfedu.mydiplom.dao;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.Delay;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class XmlAPITest {
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Delay object = new Delay(0, 0, 0, 0);
        XmlAPI instance = new XmlAPI();
        Result expResult = null;
        Result result = instance.insert(object);
        Delay object1 = new Delay(1, 1, 1, 1);
        result = instance.insert(object1);
        Delay object2 = new Delay(2, 2, 2, 2);
        result = instance.insert(object2);
        result = instance.insert(new Delay(3, 3, 3, 3));
        result = instance.insert(new Delay(4, 4, 4, 4));
        result = instance.insert(new Delay(5, 5, 5, 5));
        result = instance.insert(new Delay(6, 6, 6, 6));
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
