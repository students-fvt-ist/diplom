package ru.sfedu.mydiplom.dao.db;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.DbAPI;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public class DbAPIDeleteTest {
    @Test
    public void DeleteAppTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.APP).get();
        db.delete(result.get(0));
        DbAPISelecTest test = new DbAPISelecTest();
        test.SelectAppTest();
        assertNotNull(db);
    }
    
    @Test
    public void DeleteCltTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.CLT).get();
        db.delete(result.get(0));
        DbAPISelecTest test = new DbAPISelecTest();
        test.SelectCltTest();
        assertNotNull(db);
    }
    
    @Test
    public void DeleteDlyTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.DLY).get();
        db.delete(result.get(0));
        DbAPISelecTest test = new DbAPISelecTest();
        test.SelectDlyTest();
        assertNotNull(db);
    }
    
    @Test
    public void DeletePmtTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.PMT).get();
        db.delete(result.get(0));
        DbAPISelecTest test = new DbAPISelecTest();
        test.SelectPmtTest();
        assertNotNull(db);
    }
    
    @Test
    public void DeleteTcdTest() throws Exception{
        List<GenericDto> result;
        DbAPI db = new DbAPI();
        result = db.select(ClassType.TCD).get();
        db.delete(result.get(0));
        DbAPISelecTest test = new DbAPISelecTest();
        test.SelectTcdTest();
        assertNotNull(db);
    }
}
