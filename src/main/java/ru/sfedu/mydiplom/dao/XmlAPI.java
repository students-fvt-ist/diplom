package ru.sfedu.mydiplom.dao;

import java.io.File;
import java.util.List;
import java.util.Optional;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.*;

public class XmlAPI implements IGeneric{

    @Override
    public Result insert(GenericDto object) throws Exception {
        Result result = new Result();
        
        Serializer serializer = new Persister();
        
        File xmFile = new File("delay.xml");

        serializer.write(object, xmFile);
        
        result.setStatus(StatusType.OK.toString());
        return result;
    }

    @Override
    public Result update(GenericDto object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result delete(String arg, String value, ClassType type) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> select(String arg, String value, ClassType type) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> getObjectByID(long id, ClassType type) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> getDelayByCreditID(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> getPaymentByCreditID(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> getApplicationsByTypeID(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<GenericDto>> getApplicatonByClientID(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
