package ru.sfedu.mydiplom.dao;

import ru.sfedu.mydiplom.model.container.ContainerDelay;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import javax.xml.stream.XMLStreamException;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import static ru.sfedu.mydiplom.Constants.*;
import ru.sfedu.mydiplom.model.Result;
import ru.sfedu.mydiplom.model.StatusType;
import ru.sfedu.mydiplom.model.dto.*;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.getConfigurationEntry;

public class XmlAPI implements IGeneric{
    
    private static final Logger log = Logger.getLogger(XmlAPI.class);
    
    @Override
    public Result insert(ArrayList<GenericDto> objects) throws Exception {
        Optional readValueOptional;
        ContainerDelay container = new ContainerDelay();
        if (objects.isEmpty()) {
            throw new Exception("Not object in List");
        }
        try {
            readValueOptional = select(objects.get(0).getTypeClass());
            objects.addAll((ArrayList<GenericDto>)readValueOptional.get());
        }catch(XMLStreamException e){
            log.info(e.getMessage() + "file is empty");
        }
        container.setContainer(objects);
        return insert(container);
    }
    
    private Result insert(ContainerDelay object) throws Exception {
        Result result = new Result();
        
        Serializer serializer = new Persister();
        
        File xmFile = new File(getFile(object.getContainer().get(0).getTypeClass()));

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
        Optional<List<GenericDto>> result;
        List<GenericDto> list;
        ContainerDelay container;
        Serializer serializer = new Persister();
        File xmFile = new File(getFile(type));
        container = serializer.read(ContainerDelay.class, xmFile);
        list = container.getContainer();
        result=ofNullable(list);
        return result;
    }
    
    public Optional<List<GenericDto>> select(ClassType type) throws Exception {
        return select(null, null, type);
    }
    
    private String getFile(ClassType type) throws Exception{
        String file=getConfigurationEntry(PATH_XML_STORE);
        file+=type.toString()+".xml";
        return file;
    }
}
