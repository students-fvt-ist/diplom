package ru.sfedu.mydiplom;

import org.apache.log4j.Logger;

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
        // TODO code application logic here
        Main mdc=new Main();
        mdc.logBasicSystemInfo();
    }
    
}
