
package ru.sfedu.mydiplom.dao;

import ru.sfedu.mydiplom.utils.*;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.getConfigurationEntry;

import ru.sfedu.mydiplom.model.dto.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.exception.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.List;
import java.util.Optional;
import static java.util.Optional.*;

import org.apache.log4j.Logger;

import static ru.sfedu.mydiplom.Constants.*;

/**
 *
 * @author seyran
 */
public class CsvAPI implements IGeneric{
    private static final Logger log = Logger.getLogger(CsvAPI.class);

    /**
     *
     */
    public CsvAPI() {}
        
    /**
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public Result insert(GenericDto obj) throws Exception{
        Result result = new Result();
        ClassType classType = obj.getTypeClass();
        CSVReader reader = new CSVReader(new FileReader(getFile(classType)));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(getStrategy(classType));
            List<GenericDto> list=ctb.parse(getStrategy(classType), reader, filter); // Вызывает ошибку!
            for (GenericDto current : list) {
                if(current.getId()==obj.getId()){
                    throw new RecordExistException(current.getId());
                }
            }
            CSVWriter writer=new CSVWriter(new FileWriter(getFile(classType)));
            try {
                list.add(obj);
                btc.write(getStrategy(classType), writer, list);
                writer.close();
            }catch(Exception e){
                writer.close();
                result.setStatus(StatusType.WARNING.toString());
                result.setErrorMsg(e.getMessage());
                log.warn(e.getMessage());
                throw e;
            }
            reader.close();
            result.setStatus(StatusType.OK.toString());
        }catch(RecordExistException e){
            reader.close();
            result.setStatus(StatusType.WARNING.toString());
            result.setErrorMsg(e.getMessage());
            log.warn("Object already exist with ID:"+e.getNum());
            throw e;
        } catch (Exception e) {
            reader.close();
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg(e.getMessage());
            log.error(e.getMessage());
            throw e;
        }
        return  result;
    }
    
    /**
     *
     * @param object Entry update object
     * @return result
     * @throws Exception
     */
    @Override
    public Result update(GenericDto object) throws Exception {
        Result result = new Result();
        ClassType classType = object.getTypeClass();
        CSVReader reader = new CSVReader(new FileReader(getFile(classType)));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(getStrategy(classType));
            List<GenericDto> list = ctb.parse(getStrategy(classType), reader, filter);
            if(!list.remove(object)) throw new RecordNotFoundException(object.getId());  
            list.add(object);
            CSVWriter writer=new CSVWriter(new FileWriter(getFile(classType)));
            try {
                btc.write(getStrategy(classType), writer, list);
                writer.close();
            }catch(Exception e){
                writer.close();
                result.setStatus(StatusType.WARNING.toString());
                result.setErrorMsg(e.getMessage());
                log.warn(e.getMessage());
                throw e;
            }
            reader.close();
            result.setStatus(StatusType.OK.toString());
        }catch(RecordNotFoundException e){
            reader.close();
            result.setStatus(StatusType.OK.toString());
            result.setErrorMsg(e.getMessage());
            log.warn("Line not found with objects ID:"+e.getNum());
        } catch (Exception e) {
            reader.close();
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg(e.getMessage());
            log.error(e.getMessage());
        }
        return  result;
    }

    /**
     *
     * @param arg
     * @param value
     * @param type
     * @return Result
     * @throws Exception
     */
    @Override
    public Result delete(String arg, String value, ClassType type) throws Exception {
        Result result = new Result();
        CSVReader reader = new CSVReader(new FileReader(getFile(type)));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvDeleteFilter filter = new CsvDeleteFilter(getStrategy(type), arg, value);
            List<GenericDto> list = ctb.parse(getStrategy(type), reader, filter); 
            if (list.isEmpty()) {throw new RecordNotFoundException(0);}
            CSVWriter writer=new CSVWriter(new FileWriter(getFile(type)));
            try {
                btc.write(getStrategy(type), writer, list);
                writer.close();
            }catch(Exception e){
                writer.close();
                result.setStatus(StatusType.WARNING.toString());
                result.setErrorMsg(e.getMessage());
                log.warn(e.getMessage());
                throw e;
            }
            reader.close();
            result.setStatus(StatusType.OK.toString());
        }catch(RecordNotFoundException e){
            reader.close();
            result.setStatus(StatusType.WARNING.toString());
            log.info("Record not found "+arg+" : "+value);
        }catch (Exception e) {
            reader.close();
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg(e.getMessage());
            log.error(e.getMessage());
            throw e;
        }
        return result;
    }

    /**
     *
     * @param arg
     * @param value
     * @param type
     * @return
     * @throws Exception
     */
    @Override
    public Optional<List<GenericDto>> select(String arg, String value, ClassType type) throws Exception {
        Optional<List<GenericDto>> result;
        CSVReader reader = new CSVReader(new FileReader(getFile(type)));
        try {
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(getStrategy(type), arg, value);
            List<GenericDto> list = ctb.parse(getStrategy(type), reader, filter);
            if(list.isEmpty()) throw new RecordNotFoundException(0);
            result = ofNullable(list);
            reader.close();
        }catch(RecordNotFoundException e){
            log.trace(e.getMessage());
            throw e;
        } catch (Exception e) {
            reader.close();
            log.error(e.getMessage());
            throw e;
        }
        return  result;    
    }
    
    /**
     *
     * @param type
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> select(ClassType type) throws Exception {
        return  select(null, null, type);   
    }
    
    /**
     *
     * @param type
     * @return
     * @throws Exception
     */
    public Result delete(ClassType type) throws Exception {
        Result result = new Result();
        CSVWriter writer=new CSVWriter(new FileWriter(getFile(type)));
        try {
            result.setStatus(StatusType.OK.toString());
            writer.close();
        }catch(Exception e){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg(e.getMessage());
            writer.close();
            throw e;
        }
        return  result;
    }

    /**
     *
     * @param id
     * @param type
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getObjectByID(long id, ClassType type) throws Exception {
        return select("id", Long.toString(id), type);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getDelayByCreditID(long id) throws Exception {
        return select("credit", Long.toString(id), ClassType.DLY);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getPaymentByCreditID(long id) throws Exception {
        return select("credit", Long.toString(id), ClassType.PMT);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getApplicationsByTypeID(long id) throws Exception {
        return select("typeCredit", Long.toString(id), ClassType.APP);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getApplicatonByClientID(long id) throws Exception {
        return select("clientID", Long.toString(id), ClassType.APP);
    }
    
    private ColumnPositionMappingStrategy getStrategy(ClassType type) throws Exception{
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(type.getCl());
        strategy.setColumnMapping(type.getDescription());
        return strategy;
    }
    
    private String getFile(ClassType type) throws Exception{
        String file=getConfigurationEntry(PATH_CSV_STORE);
        file+=type.toString()+".csv";
        return file;
    }
}