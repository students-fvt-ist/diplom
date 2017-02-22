package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Payments extends GenericDto{
    @Element
    private long date;
    @Element
    private long credit;
    
    /**
     *
     * @throws InterruptedException
     */
    public Payments() throws InterruptedException {
        super(ClassType.PMT, 1l);
    }

    /**
     *
     * @param id
     * @param date
     * @param credit
     * @throws InterruptedException
     */
    public Payments(long id, long date, long credit) throws InterruptedException {
        super(ClassType.PMT, id);
        this.date = date;
        this.credit = credit;
    }

    /**
     *
     * @return
     */
    public long getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     */
    public void setCredit(long credit) {
        this.credit = credit;
    }
    
    /**
     *
     * @return
     */
    public long getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payments{" + "date=" + date + ", credit=" + credit + '}';
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