
package ru.sfedu.mydiplom.dao;

import ru.sfedu.mydiplom.utils.CsvDeleteFilter;
import ru.sfedu.mydiplom.utils.CsvConfig;
import ru.sfedu.mydiplom.utils.CsvFilter;
import ru.sfedu.mydiplom.model.dto.*;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.exception.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.CsvToBean;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import ru.sfedu.mydiplom.model.dto.ClassType;

public class CsvAPI implements IGeneric{
    private static final Logger log = Logger.getLogger(CsvAPI.class);

    public CsvAPI() {}
        
    @Override
    public Result insert(GenericDto obj) throws Exception{
        Result result = new Result();
        CsvConfig config = new CsvConfig(obj);
        CSVReader reader = new CSVReader(new FileReader(config.getFile()));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(config.getStrategy());
            List<GenericDto> list=ctb.parse(config.getStrategy(), reader, filter); // Вызывает ошибку!
            for (GenericDto current : list) {
                if(current.getId()==obj.getId()){
                    throw new RecordExistException(current.getId());
                }
            }
            CSVWriter writer=new CSVWriter(new FileWriter(config.getFile()));
            try {
                list.add(obj);
                btc.write(config.getStrategy(), writer, list);
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

    @Override
    public Result update(GenericDto object) throws Exception {
        Result result = new Result();
        CsvConfig config = new CsvConfig(object);
        CSVReader reader = new CSVReader(new FileReader(config.getFile()));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(config.getStrategy());
            List<GenericDto> list = ctb.parse(config.getStrategy(), reader, filter);
            if(!list.remove(object)) throw new RecordNotFoundException(object.getId());  
            list.add(object);
            CSVWriter writer=new CSVWriter(new FileWriter(config.getFile()));
            try {
                btc.write(config.getStrategy(), writer, list);
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

    @Override
    public Result delete(String arg, String value, ClassType type) throws Exception {
        Result result = new Result();
        CsvConfig config = new CsvConfig(type);
        CSVReader reader = new CSVReader(new FileReader(config.getFile()));
        try {
            BeanToCsv btc = new BeanToCsv();
            CsvToBean ctb = new CsvToBean();
            CsvDeleteFilter filter = new CsvDeleteFilter(config.getStrategy(), arg, value);
            List<GenericDto> list = ctb.parse(config.getStrategy(), reader, filter); 
            if (list.isEmpty()) {throw new RecordNotFoundException(0);}
            CSVWriter writer=new CSVWriter(new FileWriter(config.getFile()));
            try {
                btc.write(config.getStrategy(), writer, list);
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
        return  result;
    }

    @Override
    public ResultWithValue select(String arg, String value, ClassType type) throws Exception {
        ResultWithValue result = new ResultWithValue();
        CsvConfig config = new CsvConfig(type);
        CSVReader reader = new CSVReader(new FileReader(config.getFile()));
        try {
            CsvToBean ctb = new CsvToBean();
            CsvFilter filter = new CsvFilter(config.getStrategy(), arg, value);
            List<GenericDto> list = ctb.parse(config.getStrategy(), reader, filter);
            if(list.isEmpty()) throw new RecordNotFoundException(0);
            result.setValue(list);
            reader.close();
            result.setStatus(StatusType.OK.toString());
        }catch(RecordNotFoundException e){
            result.setStatus(StatusType.OK.toString());
            result.setErrorMsg(e.getMessage());
            log.trace(result.getErrorMsg());
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
    
    public ResultWithValue select(ClassType type) throws Exception {
        return  select(null, null, type);   
    }
    
    public Result delete(ClassType type) throws Exception {
        Result result = new Result();
        CsvConfig config = new CsvConfig(type);
        CSVWriter writer=new CSVWriter(new FileWriter(config.getFile()));
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

    @Override
    public Optional<Applications> getApplicationById(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}