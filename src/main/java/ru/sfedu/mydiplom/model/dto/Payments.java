package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

public class Payments extends GenericDto{
    private long date;
    private long credit;
    
    public Payments() throws InterruptedException {
        super(ClassType.PMT, 1l);
        Thread.sleep(1);
    }

    public Payments(long id, long date, long credit) throws InterruptedException {
        super(ClassType.PMT, id);
        this.date = date;
        this.credit = credit;
        Thread.sleep(1);
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }
    
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id+";"+date;
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
        final Payments other = (Payments) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}