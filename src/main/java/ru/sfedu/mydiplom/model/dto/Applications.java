package ru.sfedu.mydiplom.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author seyran
 */
@Root
public class Applications extends GenericDto{
    @Element
    private float sum;
    @Element
    private int maturity;
    @Element
    private float rate;
    @Element
    private long date;
    @Element
    private String status;
    @Element
    private long clientID;
    @Element
    private long typeCredit;

    public Applications(){
        super(ClassType.APP, 1l);
    }

    /**
     *
     * @param sum
     * @param maturity
     * @param rate
     * @param date
     * @param status
     * @param clientID
     * @param typeCredit
     * @param id
     * @throws InterruptedException
     */
    public Applications(float sum, int maturity, float rate, long date, String status, long clientID, long typeCredit, long id) throws InterruptedException {
        super(ClassType.APP, id);
        this.sum = sum;
        this.maturity = maturity;
        this.rate = rate;
        this.date = date;
        this.status = status;
        this.clientID = clientID;
        this.typeCredit = typeCredit;
    }

    /**
     *
     * @return
     */
    public long getTypeCredit() {
        return typeCredit;
    }

    /**
     *
     * @param typeCredit
     */
    public void setTypeCredit(long typeCredit) {
        this.typeCredit = typeCredit;
    }

    /**
     * @return the sum
     */
    public float getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(float sum) {
        this.sum = sum;
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
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
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
        return "Applications{" + "sum=" + sum + ", maturity=" + maturity + ", rate=" + rate + ", date=" + date + ", status=" + status + ", clientID=" + clientID + ", typeCredit=" + typeCredit + '}';
    }
    
    
 /*   
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
    }*/
    
}
