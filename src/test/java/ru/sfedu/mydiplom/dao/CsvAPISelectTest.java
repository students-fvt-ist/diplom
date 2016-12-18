package ru.sfedu.mydiplom.dao;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.mydiplom.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.Applications;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class CsvAPISelectTest {
    private static final Logger log = Logger.getLogger(Main.class);

    /**
     * Test of Selects method, of class CsvAPI.
     * @throws java.lang.Exception
     */
    @Test
    public void testSelectApplication() throws Exception {
        System.out.println("Select Application");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result;
        result = instance.select("sum", "35000.0", ClassType.APP);
//   result.getValue().addAll(instance.select(ClassType.APP).getValue());
        for (GenericDto obj : result.get()) {
            log.trace(obj);
        }
        assertNotNull(result.get().get(0));
    }
 
    @Test
    public void testSelectClient() throws Exception {
        System.out.println("Select Client");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result = instance.select("dateOfBirth", "2", ClassType.CLT);
        assertNotNull(result.get().get(0));
    }
    
    @Test
    public void testSelectCredit() throws Exception {
        System.out.println("Select Credit");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result = instance.select("status", "2", ClassType.CRD);
        assertNotNull(result.get().get(0));
    }
    
    @Test
    public void testSelectPayment() throws Exception {
        System.out.println("Select Payment");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result = instance.select("credit", "2", ClassType.PMT);
        assertNotNull(result.get().get(0));
    }
    
    @Test
    public void testSelectTypeCredits() throws Exception {
        System.out.println("Select Type of Credits");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result = instance.select("sumOf", "2.0", ClassType.TCD);
        assertNotNull(result.get().get(0));
    }
    
    @Test
    public void testSelectDelay() throws Exception {
        System.out.println("Select Credit");
        CsvAPI instance = new CsvAPI();
        Optional<List<GenericDto>> result = instance.select("sum", "2.0", ClassType.DLY);
        assertNotNull(result.get().get(0));
    }
}
