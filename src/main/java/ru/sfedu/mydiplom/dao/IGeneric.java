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
    
    public Optional<List<GenericDto>> getObjectByID(long id, ClassType type) throws Exception;
    public Optional<List<GenericDto>> getDelayByCreditID(long id) throws Exception;
    public Optional<List<GenericDto>> getPaymentByCreditID(long id) throws Exception;
    public Optional<List<GenericDto>> getApplicationsByTypeID(long id) throws Exception;
    public Optional<List<GenericDto>> getApplicatonByClientID(long id) throws Exception;
}
