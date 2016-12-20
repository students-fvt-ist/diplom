package ru.sfedu.mydiplom;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.security.auth.login.Configuration;
import static ru.sfedu.mydiplom.Constants.PATH_CSV_STORE;
import org.apache.log4j.Logger;
import static ru.sfedu.mydiplom.Constants.GLOABL_PROR;
import ru.sfedu.mydiplom.dao.CsvAPI;
import ru.sfedu.mydiplom.model.dto.ClassType;
import ru.sfedu.mydiplom.model.dto.GenericDto;
import ru.sfedu.mydiplom.utils.ConfigurationUtil;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.*;

/**
 *
 * @author seyran
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    /**
     *
     */
    public Main() {
        log.debug("<Your constructor name>[0]: starting application.........");

    }
    
    private void logBasicSystemInfo() {
        log.info("Launching the application...");
        log.info(
                "Operating System: " + System.getProperty("os.name") + " "
                + System.getProperty("os.version")
        );
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
}
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException{
    //    Main mdc=new Main();
    //    mdc.logBasicSystemInfo();
        // TODO исправить Proporties
//        try {
//            getConfigurationEntry("a");
       //     log.info(getConfigurationEntry(PATH_CSV_STORE));
      
//            ConfigurationUtil a = new ConfigurationUtil(System.getProperty(GLOABL_PROR));
//            log.info("TEST->"+a.getConfigurationEntry(PATH_CSV_STORE));
//            log.info("");
//            getConfigurationEntry(PATH_CSV_STORE);
//        } catch (IOException e) {
//            log.error(e+"AAAAaA");
//        } catch(NullPointerException e) {
//            log.error(e.getMessage());
//        }
     cli(args[0]);
    }
    
    /**
     *
     * @param source
     */
    public static void cli(String source){
        try{
            Scanner sc = new Scanner(System.in);
            List<GenericDto> ret;
            String[] query;
            ClassType clss;
            String id;
            log.info("> ");
            query=divide(sc.nextLine());
            switch(query[1]){
                case "app" :
                            clss=ClassType.APP;
                            break;
                case "clt" : 
                            clss=ClassType.CLT;
                            break;
                case "pmt" : 
                            clss=ClassType.PMT;
                            break;
                case "tcd" : 
                            clss=ClassType.TCD;
                            break;
                case "dly" : 
                            clss=ClassType.DLY;
                            break;
                default:        
                            throw new Exception();
            }
            id=query[2];
            CsvAPI capi = new CsvAPI();
            switch(query[0]){
                case "select" : 
                                ret=capi.getObjectByID(0, clss).get();
                                for(int i=0; i<ret.size(); i++){
                                    log.info(ret.get(i));
                                }
                                break;
                case "delete" :
                                capi.delete("id", id, clss);
                                log.info("complite delete");
                                break;
                default :        
                                throw new Exception();
                    
            }
            
        }catch(Exception e){
            log.info("incorect query");
            cli(source);
        }
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static String[] divide(String s) {
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;
        boolean f = false;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                if (j > i) {
                    tmp.add(s.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s.length()) {
            tmp.add(s.substring(i));
        }
        return tmp.toArray(new String[tmp.size()]);
    }
}
