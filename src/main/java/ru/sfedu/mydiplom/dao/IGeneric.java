package ru.sfedu.mydiplom.dao;

import java.util.Optional;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.Applications;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public interface IGeneric {
    public Result insert(GenericDto object)throws Exception; 
    public Result update(GenericDto object)throws Exception;   
    public Result delete(String arg, String value, ClassType type)throws Exception;  
    public ResultWithValue select(String arg, String value, ClassType type)throws Exception; 
//    public Optional<Applications>getApplicationById(Long Id);
}
