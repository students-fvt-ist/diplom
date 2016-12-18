package ru.sfedu.mydiplom.dao;

import java.util.List;
import java.util.Optional;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

public interface IGeneric {

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public Result insert(GenericDto object)throws Exception; 

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public Result update(GenericDto object)throws Exception;   

    /**
     *
     * @param arg
     * @param value
     * @param type
     * @return
     * @throws Exception
     */
    public Result delete(String arg, String value, ClassType type)throws Exception;  

    /**
     *
     * @param arg
     * @param value
     * @param type
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> select(String arg, String value, ClassType type)throws Exception; 
    public Optional<GenericDto> getApplicationById(Long Id);
}
