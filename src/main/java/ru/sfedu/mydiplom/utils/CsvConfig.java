package ru.sfedu.mydiplom.utils;

import ru.sfedu.mydiplom.model.dto.ClassType;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import org.apache.log4j.Logger;
import static ru.sfedu.mydiplom.Constants.*;
import ru.sfedu.mydiplom.model.dto.*;

/**
 *
 * @author seyran
 */
public class CsvConfig{
    private String file;
    private ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
    private static final Logger log = Logger.getLogger(CsvConfig.class);

    /**
     *
     * @param obj
     */
    public CsvConfig(GenericDto obj) {
        getConfig(obj.getTypeClass());
    }

    /**
     *
     * @param type
     */
    public CsvConfig(ClassType type) {
        getConfig(type);
    }
    
    private void getConfig(ClassType type){
        switch(type){
            case APP :  
                        strategy.setType(Applications.class);
                        file=APPLICATION_FILE_NAME;
                        break;
            case CLT : 
                        strategy.setType(Clients.class);
                        file=CLIENTS_FILE_NAME;
                        break;
            case PMT : 
                        strategy.setType(Payments.class);
                        file=PAYMENTS_FILE_NAME;
                        break;
            case TCD : 
                        strategy.setType(TypeCredits.class);
                        file=TYPECREDITS_FILE_NAME;
                        break;
            case DLY : 
                        strategy.setType(Delay.class);
                        file=DELAY_FILE_NAME;
                        break;
            default : log.error("it is impossible to determine the type of the class"); break;
        }
        strategy.setColumnMapping(type.getDescription());
    }

    /**
     *
     * @return
     */
    public String getFile() {
        return file;
    }

    /**
     *
     * @return
     */
    public ColumnPositionMappingStrategy getStrategy() {
        return strategy;
    }
    
}
