package ru.sfedu.mydiplom.dao;

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
import ru.sfedu.mydiplom.model.*;
import ru.sfedu.mydiplom.model.dto.*;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.getConfigurationEntry;

public class XmlAPI implements IGeneric{
    
    private static final Logger log = Logger.getLogger(XmlAPI.class);
    
    @Override
    public Result insert(ArrayList<GenericDto> objects) throws Exception {
        Optional readValueOptional;
        ContainerBean container = new ContainerBean();
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
    
    private Result insert(ContainerBean object) throws Exception {
        Result result = new Result();
        
        Serializer serializer = new Persister();
        
        File xmFile = new File(getFile(object.getContainer().get(0).getTypeClass()));

        serializer.write(object, xmFile);
        
        result.setStatus(StatusType.OK.toString());
        return result;
    }

    @Override
    public Result update(GenericDto object) throws Exception {
        Result result = new Result();
        try{
            result=delete(object);
            if(!result.getStatus().equals(StatusType.OK.toString())){
                throw new Exception(result.getErrorMsg());
            }
            ArrayList<GenericDto> list = new ArrayList<>();
            list.add(object);
            result=insert(list);
            if(!result.getStatus().equals(StatusType.OK.toString())){
                throw new Exception(result.getErrorMsg());
            }
        }catch(Exception e){
            result.setStatus(StatusType.ERROR.toString());
            result.setErrorMsg(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public Result delete(GenericDto object) throws Exception {
        Result result = new Result();
                try {
                    Serializer serializer = new Persister();
                    ContainerBean container = new ContainerBean();
                    List<GenericDto> list;
                    Optional<List<GenericDto>> rv = select(object.getTypeClass());
                    list = rv.get();
                    if(list.isEmpty()){
                        throw new Exception("File is empty");
                    }
                    list.remove(select(object.getTypeClass()).get().get(0));
                    container.setContainer(list);
                    File file = new File(getFile(list.get(0).getTypeClass()));
                    serializer.write(container, file);
                    result.setStatus(StatusType.OK.toString());
                } catch (Exception e) {
                    result.setStatus(StatusType.ERROR.toString());
                    result.setErrorMsg("Error : " + e.getMessage());
                    throw e;
                }
        return result;    
    }
    
    @Override
    public Optional<List<GenericDto>> select(ClassType type) throws Exception {
        Optional<List<GenericDto>> result;
        List<GenericDto> list;
        ContainerBean container;
        Serializer serializer = new Persister();
        File xmFile = new File(getFile(type));
        container = serializer.read(ContainerBean.class, xmFile);
        list = container.getContainer();
        result=ofNullable(list);
        return result;
    }
    
    private String getFile(ClassType type) throws Exception{
        String file=getConfigurationEntry(PATH_XML_STORE);
        file+=type.toString()+".xml";
        return file;
    }
}
