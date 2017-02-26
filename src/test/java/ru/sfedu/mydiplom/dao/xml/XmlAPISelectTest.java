package ru.sfedu.mydiplom.dao.xml;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.XmlAPI;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class XmlAPISelectTest {
    
    @Test
    public void testSelectApplication() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("select application");
        XmlAPI instance = new XmlAPI();
        try {
            result = instance.select(ClassType.APP);
            result.get().stream().forEach((get) -> {
                System.out.println(get);
            });
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testSelectClient() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("select client");
        XmlAPI instance = new XmlAPI();
        try {
            result = instance.select(ClassType.CLT);
            result.get().stream().forEach((get) -> {
                System.out.println(get);
            });
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testSelectDelay() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("select delay");
        XmlAPI instance = new XmlAPI();
        try {
            result = instance.select(ClassType.DLY);
            result.get().stream().forEach((get) -> {
                System.out.println(get);
            });
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testSelectPayment() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("select payment");
        XmlAPI instance = new XmlAPI();
        try {
            result = instance.select(ClassType.PMT);
            result.get().stream().forEach((get) -> {
                System.out.println(get);
            });
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Test
    public void testSelectTypeCredits() throws Exception {
        Optional<List<GenericDto>> result;
        System.out.println("select type credits");
        XmlAPI instance = new XmlAPI();
        try {
            result = instance.select(ClassType.TCD);
            result.get().stream().forEach((get) -> {
                System.out.println(get);
            });
            assertNotNull(result.get().get(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
