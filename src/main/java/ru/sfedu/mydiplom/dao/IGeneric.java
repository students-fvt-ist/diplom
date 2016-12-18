package ru.sfedu.mydiplom.dao;

import java.util.List;
import java.util.Optional;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public interface IGeneric {

    
    public Result insert(GenericDto object)throws Exception; 
    public Result update(GenericDto object)throws Exception;   
    public Result delete(String arg, String value, ClassType type)throws Exception;  
    public Optional<List<GenericDto>> select(String arg, String value, ClassType type)throws Exception; 
    public Optional<List<GenericDto>> getClientByID(long id) throws Exception;
    public Optional<List<GenericDto>> getTypeCreditByID(long id) throws Exception;
    public Optional<List<GenericDto>> getApplicationByID(long id) throws Exception;
    public Optional<List<GenericDto>> getPaymentByID(long id) throws Exception;
    public Optional<List<GenericDto>> getDelayByID(long id) throws Exception;
    
}
