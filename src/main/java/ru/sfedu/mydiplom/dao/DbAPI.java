package ru.sfedu.mydiplom.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.log4j.Logger;
import static ru.sfedu.mydiplom.Constants.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.*;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.getConfigurationEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;
import static java.util.Optional.ofNullable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DbAPI implements IGeneric{
 
    private static final Logger log = Logger.getLogger(DbAPI.class);
    
    private static String url;
    private static String user;
    private static String password;

    public DbAPI() throws IOException {
        this.url = getConfigurationEntry(DATA_BASE_URL);
        this.user = getConfigurationEntry(DATA_BASE_USER);
        this.password = getConfigurationEntry(DATA_BASE_PASSWORD);
    }
    
    @Override
    public Result insert(ArrayList<GenericDto> objects) throws Exception {
        Result result = new Result(StatusType.OK.toString());
        switch(objects.get(0).getTypeClass()){
            case APP : for (GenericDto object : objects) {
                    addApplications((Applications) object);
                }; break;
            case CLT : for (GenericDto object : objects) {
                    addClints((Clients) object);
                }; break;
            case DLY : for (GenericDto object : objects) {
                    addDelay((Delay) object);
                }; break;
            case PMT : for (GenericDto object : objects) {
                    addPayments((Payments) object);
                }; break;
            case TCD : for (GenericDto object : objects) {
                    addTypeCredits((TypeCredits) object);
                }; break;
            default : throw new Exception("Unexpected type");
        }
        return result;
    }

    @Override
    public Result update(GenericDto object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result delete(GenericDto object) throws Exception {
        String query = "delete from ";
        Result result = new Result(StatusType.OK.toString());
        switch(object.getTypeClass()){
            case APP : query += "Applications where id="; break;
            case CLT : query += "Clients where id="; break;
            case DLY : query += "Delay where id="; break;
            case PMT : query += "Payments where id="; break;
            case TCD : query += "TypeCredits where id="; break;
            default : throw new Exception("Unexpected type");
        }
        query += object.getId() + ";";
        execute(query);
        return result;
    }
    
    public void delete(ClassType type) throws Exception{
        String query = "delete from ";
        switch(type){
            case APP : query += "Applications;"; break;
            case CLT : query += "Clients;"; break;
            case DLY : query += "Delay;"; break;
            case PMT : query += "Payments;"; break;
            case TCD : query += "TypeCredits;"; break;
            default : throw new Exception("Unexpected type");
        }
        execute(query);
    }

    @Override
    public Optional<List<GenericDto>> select(ClassType type) throws Exception {
        Optional<List<GenericDto>> result;
        List<GenericDto> list = null;
        String query = "SELECT * FROM ";
        switch(type){
            case APP : list = getApplications(); break;
            case CLT : list = getClients(); break;
            case DLY : list = getDelay(); break;
            case PMT : list = getPayments(); break;
            case TCD : list = getTypeCredits(); break;
            default : throw new Exception("Unexpected type");
        }
        result=ofNullable(list);
        return result;
    }
    
    public List<GenericDto> getTypeCredits() throws SQLException, InterruptedException{
        List<GenericDto> list = new ArrayList<>();
        String query = "SELECT * FROM TypeCredits;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            resultSet = statement.executeQuery(query);
            
            
            while(resultSet.next()){
                list.add(new TypeCredits(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8)));
            }
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
        return list;
    }
    
    public List<GenericDto> getPayments() throws SQLException, InterruptedException{
        List<GenericDto> list = new ArrayList<>();
        String query = "SELECT * FROM Payments;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                list.add(new Payments(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3)));
            }
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
        return list;
    }
    
    public List<GenericDto> getDelay() throws SQLException, InterruptedException{
        List<GenericDto> list = new ArrayList<>();
        String query = "SELECT * FROM Delay;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                list.add(new Delay(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3), resultSet.getFloat(4)));
            }
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
        return list;
    }
    
    public List<GenericDto> getApplications() throws SQLException, InterruptedException{
        List<GenericDto> list = new ArrayList<>();
        String query = "SELECT * FROM Applications;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                list.add(new Applications(resultSet.getFloat(2), resultSet.getInt(3), resultSet.getFloat(4), resultSet.getLong(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getLong(1)));
            }
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
        return list;
    }
    
    public List<GenericDto> getClients() throws SQLException, InterruptedException{
        long id;
        long dateOfBirth;
        int status;
        int passportNumber;
        float salary;
        float experience;
        float experienceOfLastWP;
        float totalGain;
        boolean conviction;
        boolean working;
        boolean changedPassport;
        String name;
        String placeOfWorking;
        String addres;
        String phone;
        String workPhone;
        String passportData;
        String otherDocument;
        List<GenericDto> list = new ArrayList<>();
        String query = "SELECT * FROM Clients;";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                id = resultSet.getLong(1);
                dateOfBirth = resultSet.getLong(2);
                status = resultSet.getInt(3);
                passportNumber = resultSet.getInt(4);
                salary = resultSet.getFloat(5);
                experience = resultSet.getFloat(6);
                experienceOfLastWP = resultSet.getFloat(7);
                totalGain = resultSet.getFloat(8);
                if (resultSet.getInt(9)==1) {
                    conviction = true;
                }else{
                    conviction = false;
                }
                if (resultSet.getInt(10)==1) {
                    working = true;
                }else{
                    working = false;
                }
                if (resultSet.getInt(11)==1) {
                    changedPassport = true;
                }else{
                    changedPassport = false;
                }
                name = resultSet.getString(12);
                placeOfWorking = resultSet.getString(13);
                addres = resultSet.getString(14);
                phone = resultSet.getString(15);
                workPhone = resultSet.getString(16);
                passportData = resultSet.getString(17);
                otherDocument = resultSet.getString(18);
                list.add(new Clients(id, dateOfBirth, status, passportNumber, salary, experience, experienceOfLastWP, totalGain, conviction, working, changedPassport, name, placeOfWorking, addres, phone, workPhone, passportData, otherDocument));
            }
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
        
        return list;
    }
    
    public void addApplications(Applications object) throws SQLException{
        long id = object.getId();
        float sum = object.getSum();
        int maturity = object.getMaturity();
        float rate = object.getRate();
        long date = object.getDate();
        String status = object.getStatus();
        long clientID = object.getClientID();
        long typeCredit = object.getTypeCredit();
        String query = "insert into Applications Values("+ id + ", " + sum + ", " + maturity + ", ";
        query += rate +", " + date + ", \"" + status +"\", " + clientID + ", " + typeCredit + ");";
        execute(query);
    }
    
    public void addDelay(Delay object) throws SQLException{
        long id = object.getId();
        long credit = object.getCredit();
        long date = object.getDate();
        float sum = object.getSum();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Driver driver = null;
        String query = "insert into Delay Values("+ id + ", " + credit + ", " + date + ", " + sum + ");";
        execute(query);
    }
    
    public void addPayments(Payments object) throws SQLException{
        long id = object.getId();
        long date = object.getDate();
        long credit = object.getCredit();
        String query = "insert into Payments Values("+ id + ", " + date + ", " + credit + ");";
        execute(query);
    }
    
    public void addClints(Clients object) throws SQLException{
        long id = object.getId();
        long dateOfBirth = object.getDateOfBirth();
        int status = object.getStatus();
        int passportNumber = object.getPassportNumber();
        float salary = object.getSalary();
        float experience = object.getExperience();
        float experienceOfLastWP = object.getExperienceOfLastWP();
        float totalGain = object.getTotalGain();
        int conviction;
            if (object.isConviction()) {
                conviction = 1;
            }else{
                conviction = 0;
            }
        int working;
            if (object.isWorking()) {
                working = 1;
            }else{
                working = 0;
            }
        int changedPassport;
            if (object.isChangedPassport()) {
                changedPassport = 1;
            }else{
                changedPassport = 0;
            }
        String name = object.getName();
        String placeOfWorking = object.getPlaceOfWorking();
        String addres = object.getAddres();
        String phone = object.getPhone();
        String workPhone = object.getWorkPhone();
        String passportData = object.getPassportData();
        String otherDocument = object.getOtherDocument();
        String query = "insert into Clients Values("+ id + ", " + dateOfBirth + ", " + status + ", " + passportNumber +", " + salary + ", ";
        query += experience +", " + experienceOfLastWP + ", " + totalGain + ", " + conviction + ", " + working + ", " + changedPassport + ", \"";
        query += name + "\", \"" + placeOfWorking + "\", \"" + addres + "\", \"" + phone + "\", \"" + workPhone + "\", \"" + passportData + "\", \"";
        query += otherDocument + "\");";
        execute(query);
    }
    
    public void addTypeCredits(TypeCredits object) throws SQLException{
        String query = "insert into TypeCredits Values("+ object.getId() + ", \"" + object.getName() + "\", " + object.getMaturityOf() + ", " + object.getMaturityUp() +", " + object.getSumOf() + ", " + object.getSumUp() +", " + object.getRateOf() + ", " + object.getRateUp() + ");";
        execute(query);
    }
    
    private void execute(String query) throws SQLException{
        Connection connection = null;
        Statement statement = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                log.trace("Conection with DB");
            }
            statement = connection.createStatement();
            statement.execute("use diplom");
            statement.execute(query);
            
            
            connection.close();
            if (connection.isClosed()) {
                log.trace("Not conection with DB");
            }
        }catch(SQLException e){
            log.error(e.getMessage());
            throw e;
        }
    }
}
