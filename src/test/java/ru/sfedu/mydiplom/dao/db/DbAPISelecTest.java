package ru.sfedu.mydiplom.dao.db;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.DbAPI;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;
import ru.sfedu.mydiplom.model.dto.TypeCredits;
import static ru.sfedu.mydiplom.utils.IDGenerator.getIDGenerator;

public class DbAPISelecTest {
    @Test
    public void SelectAppTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.APP).get();
        for (GenericDto genericDto : result) {
            System.out.println(genericDto);
        }
        assertNotNull(db);
    }
    
    @Test
    public void SelectCltTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.CLT).get();
        for (GenericDto genericDto : result) {
            System.out.println(genericDto);
        }
        assertNotNull(db);
    }
    
    @Test
    public void SelectDlyTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.DLY).get();
        for (GenericDto genericDto : result) {
            System.out.println(genericDto);
        }
        assertNotNull(db);
    }
    
    @Test
    public void SelectPmtTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.PMT).get();
        for (GenericDto genericDto : result) {
            System.out.println(genericDto);
        }
        assertNotNull(db);
    }
    
    @Test
    public void SelectTcdTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.TCD).get();
        for (GenericDto genericDto : result) {
            System.out.println(genericDto);
        }
        assertNotNull(db);
    }
}
