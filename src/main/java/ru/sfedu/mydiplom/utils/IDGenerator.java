package ru.sfedu.mydiplom.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import ru.sfedu.mydiplom.Main;

public class IDGenerator {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Main.class);
    private static IDGenerator instance;

    private IDGenerator() {
    }

    public static IDGenerator getIDGenerator() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }
    
    public long getID(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            log.error("InterruptedException in" + ex.getClass() + " : " +ex.getMessage());
        }
        return System.currentTimeMillis();
    }
}
