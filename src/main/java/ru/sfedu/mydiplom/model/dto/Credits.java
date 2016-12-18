package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

/**
 *
 * @author seyran
 */
public class Credits extends GenericDto{
    private long id = 1l;
    private int status;
    private long date;
    private long typeCredit;

    public Credits() throws InterruptedException {
        super(ClassType.CRD, 1l);
        Thread.sleep(1);
    }

    public Credits(long id, int status, long date, long typeCredit) throws InterruptedException {
        super(ClassType.CRD, id);
        this.id = id;
        this.status = status;
        this.date = date;
        this.typeCredit = typeCredit;
        Thread.sleep(1);
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
    
    @Override
    public long getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(long typeCredit) {
        this.typeCredit = typeCredit;
    }

    @Override
    public String toString() {
        return "id = "+id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Credits other = (Credits) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
        
}
