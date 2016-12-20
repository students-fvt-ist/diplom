package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

/**
 *
 * @author seyran
 */
public class Delay extends GenericDto{
    private long credit;
    private long date;
    private float sum;

    /**
     *
     * @throws InterruptedException
     */
    public Delay() throws InterruptedException {
        super(ClassType.DLY, 1l);
    }

    /**
     *
     * @param id
     * @param credit
     * @param date
     * @param sum
     * @throws InterruptedException
     */
    public Delay(long id, long credit, long date, float sum) throws InterruptedException {
        super(ClassType.DLY, id);
        this.credit = credit;
        this.date = date;
        this.sum = sum;
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

    /**
     *
     * @return
     */
    public float getSum() {
        return sum;
    }

    /**
     *
     * @param sum
     */
    public void setSum(float sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return id + ";" + credit + ";" + date + ";" + sum;
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
        final Delay other = (Delay) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
