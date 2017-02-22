package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.Delay;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class XmlAPITest {
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Result result = new Result();
        XmlAPI instance = new XmlAPI();
        Result expResult = new Result();
        expResult.setStatus(StatusType.OK.toString());
        ArrayList<GenericDto> list = new ArrayList<>();
        list.add(new Delay(1, 1, 1, 1));
        list.add(new Delay(2, 2, 2, 2));
        result = instance.insert(list);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSelect() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("insert");
        XmlAPI instance = new XmlAPI();
//        ArrayList<GenericDto> list = new ArrayList<>();
//        list.add(new Delay(5, 5, 5, 5));
//        list.add(new Delay(6, 6, 6, 6));
        try {
            result = instance.select(ClassType.DLY);
            for (GenericDto get : result.get()) {
                System.out.println(get);
            }
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
