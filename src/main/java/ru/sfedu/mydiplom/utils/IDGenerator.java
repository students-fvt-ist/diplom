package ru.sfedu.mydiplom.utils;

public class IDGenerator {
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
        return System.currentTimeMillis();
    }
}
