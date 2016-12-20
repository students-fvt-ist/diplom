package ru.sfedu.mydiplom.dao;

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
    
    /**
     *
     * @param id
     * @param type
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getObjectByID(long id, ClassType type) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getDelayByCreditID(long id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getPaymentByCreditID(long id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getApplicationsByTypeID(long id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Optional<List<GenericDto>> getApplicatonByClientID(long id) throws Exception;
}
