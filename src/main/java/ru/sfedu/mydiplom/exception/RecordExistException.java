package ru.sfedu.mydiplom.exception;

public class RecordExistException extends Exception{
    private final long num;

    public long getNum() {
        return num;
    }
    
    public RecordExistException(long num){
        super("Record exist.");
        this.num=num;
    }
}
