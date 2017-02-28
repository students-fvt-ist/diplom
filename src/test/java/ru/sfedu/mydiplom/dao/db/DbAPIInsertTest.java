package ru.sfedu.mydiplom.dao.db;

import org.apache.log4j.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import ru.sfedu.mydiplom.dao.DbAPI;
import ru.sfedu.mydiplom.model.dto.ApplicationStatusType;
import ru.sfedu.mydiplom.model.dto.Applications;
import ru.sfedu.mydiplom.model.dto.Clients;
import ru.sfedu.mydiplom.model.dto.Delay;
import ru.sfedu.mydiplom.model.dto.Payments;
import ru.sfedu.mydiplom.model.dto.TypeCredits;
import static ru.sfedu.mydiplom.utils.IDGenerator.getIDGenerator;

public class DbAPIInsertTest {

    private static final Logger log = Logger.getLogger(DbAPIInsertTest.class);
    
    @Test
    public void DbAPIaddTypeCreditsTest() throws Exception {
        DbAPI db = new DbAPI();
        db.addTypeCredits(new TypeCredits(getIDGenerator().getID(), "as", 1, 2, 3.0f, 4.0f, 5.0f, 6.0f));
        assertNotNull(db);
    }
    
    @Test
    public void DbAPIaddApplicationsTest() throws Exception {
        DbAPI db = new DbAPI();
        db.addApplications(new Applications(10000.0f, 1, 2.0f, 3, ApplicationStatusType.APP.toString(), 1488246082992l, 1488246083113l, getIDGenerator().getID()));
        assertNotNull(db);
    }
    
    @Test
    public void DbAPIaddClient() throws Exception {
        DbAPI db = new DbAPI();
        Clients obj = new Clients(getIDGenerator().getID(), 1, 0, 0, 0, 0, 0, 0, true, false, true, "Name", "Work", "Street", "234567", "276543", "pd", "as");
        db.addClints(obj);
        assertNotNull(db);
    }
    
    @Test
    public void DbAPIaddDelay() throws Exception {
        DbAPI db = new DbAPI();
        Delay obj = new Delay(getIDGenerator().getID(), 1488246209741l, System.currentTimeMillis(), 1000.0f);
        db.addDelay(obj);
        assertNotNull(db);
    }
    
    @Test
    public void DbAPIaddPayments() throws Exception {
        DbAPI db = new DbAPI();
        Payments obj = new Payments(getIDGenerator().getID(), System.currentTimeMillis(), 1488246209741l);
        db.addPayments(obj);
        assertNotNull(db);
    }
}
