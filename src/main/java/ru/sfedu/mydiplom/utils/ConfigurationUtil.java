package ru.sfedu.mydiplom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration utility. Allows to get configuration properties from the
 * default configuration file
 *
 * @author Boris Jmailov
 */
public class ConfigurationUtil {

    private static final String DEFAULT_CONFIG_PATH = "mydiplom.properties";
    private static final Properties configuration = new Properties();
    private static String pathEnv;
    /**
     * Hides default constructor
     */
    private ConfigurationUtil() {
        pathEnv = DEFAULT_CONFIG_PATH;
    }
    
    public ConfigurationUtil(String pathTofile){
        this.pathEnv = pathTofile;
    }
    
    private static Properties getConfiguration() throws IOException {
        if(pathEnv==null){
            pathEnv = DEFAULT_CONFIG_PATH;
        }
        if(configuration.isEmpty()){
            loadConfiguration();
        }
        return configuration;
    }

    /**
     * Loads configuration from <code>DEFAULT_CONFIG_PATH</code>
     * @throws IOException In case of the configuration file read failure
     */
    private static void loadConfiguration() throws IOException{
        
        File nf = new File(pathEnv);
        InputStream in = new FileInputStream(nf);//utStream nf.getpathEnv.getClass().getResourceAsStream(pathEnv);
        try {
            configuration.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally{
            in.close();
        }
    }
    /**
     * Gets configuration entry value
     * @param key Entry key
     * @return Entry value by key
     * @throws IOException In case of the configuration file read failure
     */
    public static String getConfigurationEntry(String key) throws IOException{
        return getConfiguration().getProperty(key);
    }
    
}