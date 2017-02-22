package ru.sfedu.mydiplom.exception;

/**
 *
 * @author seyran
 */
public class RecordExistException extends Exception{
    private final long num;

    /**
     *
     * @return
     */
    public long getNum() {
        return num;
    }
    
    /**
     *
     * @param num
     */
    public RecordExistException(long num){
        super("Record exist.");
        this.num=num;
    }
}
