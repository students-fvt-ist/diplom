package ru.sfedu.mydiplom.model.dto;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;

public class Delay extends GenericDto{
    @CsvBindByName
    private long id = 1l;
    @CsvBindByName
    private long credit;
    @CsvBindByName
    private long date;
    @CsvBindByName
    private float sum;

    public Delay() throws InterruptedException {
        super(ClassType.DLY, 1l);
    }

    public Delay(long id, long credit, long date, float sum) throws InterruptedException {
        super(ClassType.DLY, id);
        this.id = id;
        this.credit = credit;
        this.date = date;
        this.sum = sum;
        Thread.sleep(1);
    }

    /**
     *
     * @return
     */
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
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

    public float getSum() {
        return sum;
    }

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
