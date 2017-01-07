package ru.sfedu.mydiplom;

import java.io.IOException;
import static ru.sfedu.mydiplom.Constants.PATH_CSV_STORE;
import org.apache.log4j.Logger;
import static ru.sfedu.mydiplom.utils.ConfigurationUtil.*;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

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
    
    public static void main(String[] args) {
        Main mdc=new Main();
        mdc.logBasicSystemInfo();
        // TODO исправить Proporties
//        try {
//            getConfigurationEntry("a");
//            System.out.println(getConfigurationEntry(PATH_CSV_STORE)+"ASDASD");
//            getConfigurationEntry(PATH_CSV_STORE);
//        } catch (IOException e) {
//            log.error(e+"AAAAaA");
//        } catch(NullPointerException e) {
//            log.error(e.getMessage());
//        }
        
    }
    
    /**
     *
     * @param source
     * @throws java.io.IOException
     */
    public static void cli(String source) throws IOException{
        try{
            CsvAPI  capi = new CsvAPI();
            Optional<List<GenericDto>> ret;
            String[] query;
            ClassType clss;
            log.info("\n>");
            query=divide(System.console().readLine());
            if("exit".equals(query[0])){
                return;
            }
            if (query.length>2){
                log.info("incorect query");
                throw new Exception();
            }
            clss = ClassType.valueOf(query[1].toUpperCase());
            switch(query[0]){
                case "select" : 
                                ret = capi.select(clss);
                                for(int i=0; i<ret.get().size(); i++){
                                    log.info(ret.get().get(i));
                                }
                                break;
                default :        
                                log.info("incorect query");
                                throw new Exception();
            }
            cli(source);
        }catch(FileNotFoundException e){
            String store=getConfigurationEntry(PATH_CSV_STORE);
            File folder = new File(store);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            ClassType[] cts = ClassType.values();
            for (ClassType ct : cts) {
                String file = ct.toString() + ".csv";
                File f = new File(folder, file);
                if(!f.exists()){
                    f.createNewFile();
                }
            }
            log.info(e.getMessage());
            cli(source);
        }catch(Exception e){
            log.info(e.getMessage());
            cli(source);
        }
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static String[] divide(String s) {
        ArrayList<String> tmp = new ArrayList<>();
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
