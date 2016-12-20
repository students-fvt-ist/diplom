package ru.sfedu.mydiplom.exception;

/**
 *
 * @author seyran
 */
public class RecordNotFoundException extends Exception{
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
    public RecordNotFoundException(long num) {
        super("Record not found");
        this.num=num;
    }
    
}
