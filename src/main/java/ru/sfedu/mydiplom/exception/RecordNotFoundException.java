package ru.sfedu.mydiplom.exception;

public class RecordNotFoundException extends Exception{
    private final long num;

    public long getNum() {
        return num;
    }
 
    public RecordNotFoundException(long num) {
        super("Record not found");
        this.num=num;
    }
    
}
