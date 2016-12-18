package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

public class Applications extends GenericDto{
	private long id = 1l;
	private float sum;
	private long credit;
	private int maturity;
	private float rate;
	private long date;
	private int status;
	private long clientID;

    /**
     *
     */
    public Applications() throws InterruptedException{
        super(ClassType.APP, 1l);
        Thread.sleep(1);}
    

    /**
     *
     * @param id
     * @param sum
     * @param credit
     * @param maturity
     * @param rate
     * @param date
     * @param status
     * @param clientID
     */
    public Applications(long id, float sum, long credit, int maturity, float rate, long date, int status, long clientID) throws InterruptedException {
        super(ClassType.APP, id);
        this.id = id;
        this.sum = sum;
        this.credit = credit;
        this.maturity = maturity;
        this.rate = rate;
        this.date = date;
        this.status = status;
        this.clientID = clientID;
        Thread.sleep(1);
    }

        
    /**
     * @return the id
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * @return the sum
     */
    public float getSum() {
        return sum;
    }
    
    @Override
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(float sum) {
        this.sum = sum;
    }

    /**
     * @return the credit
     */
    public long getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(long credit) {
        this.credit = credit;
    }

    /**
     * @return the maturity
     */
    public int getMaturity() {
        return maturity;
    }

    /**
     * @param maturity the maturity to set
     */
    public void setMaturity(int maturity) {
        this.maturity = maturity;
    }

    /**
     * @return the rate
     */
    public float getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the clientID
     */
    public long getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return id + ";" + sum + ";" + credit + ";" + maturity + ";" + rate + ";" + date + ";" + status + ";" + clientID;
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
        final Applications other = (Applications) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
