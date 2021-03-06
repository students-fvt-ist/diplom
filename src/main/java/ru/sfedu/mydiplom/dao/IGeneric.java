package ru.sfedu.mydiplom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;

/**
 *
 * @author seyran
 */
public interface IGeneric {
    
    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public Result insert(ArrayList<GenericDto> object)throws Exception; 

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    public Result update(GenericDto object)throws Exception;   

    /**
     *
     * @param object 
     * @return
     * @throws Exception
     */
    public Result delete(GenericDto object)throws Exception;  

    /**
     *
     * @param type
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> select(ClassType type)throws Exception; 
    
}
