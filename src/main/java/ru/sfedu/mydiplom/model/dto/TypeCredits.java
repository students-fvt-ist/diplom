package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

/**
 *
 * @author seyran
 */
public class TypeCredits extends GenericDto{
    private String name;
    private int maturityOf;
    private int maturityUp;
    private float sumOf;
    private float sumUp;
    private float rateOf;
    private float rateUp;

    /**
     *
     * @throws InterruptedException
     */
    public TypeCredits() throws InterruptedException {
        super(ClassType.TCD, 1l);
    }

    /**
     *
     * @param id
     * @param name
     * @param maturityOf
     * @param maturityUp
     * @param sumOf
     * @param sumUp
     * @param rateOf
     * @param rateUp
     * @throws InterruptedException
     */
    public TypeCredits(long id, String name, int maturityOf, int maturityUp, float sumOf, float sumUp, float rateOf, float rateUp) throws InterruptedException {
        super(ClassType.TCD, id);
        this.name = name;
        this.maturityOf = maturityOf;
        this.maturityUp = maturityUp;
        this.sumOf = sumOf;
        this.sumUp = sumUp;
        this.rateOf = rateOf;
        this.rateUp = rateUp;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getMaturityOf() {
        return maturityOf;
    }

    /**
     *
     * @param maturityOf
     */
    public void setMaturityOf(int maturityOf) {
        this.maturityOf = maturityOf;
    }

    /**
     *
     * @return
     */
    public int getMaturityUp() {
        return maturityUp;
    }

    /**
     *
     * @param maturityUp
     */
    public void setMaturityUp(int maturityUp) {
        this.maturityUp = maturityUp;
    }

    /**
     *
     * @return
     */
    public float getSumOf() {
        return sumOf;
    }

    /**
     *
     * @param sumOf
     */
    public void setSumOf(float sumOf) {
        this.sumOf = sumOf;
    }

    /**
     *
     * @return
     */
    public float getSumUp() {
        return sumUp;
    }

    /**
     *
     * @param sumUp
     */
    public void setSumUp(float sumUp) {
        this.sumUp = sumUp;
    }

    /**
     *
     * @return
     */
    public float getRateOf() {
        return rateOf;
    }

    /**
     *
     * @param rateOf
     */
    public void setRateOf(float rateOf) {
        this.rateOf = rateOf;
    }

    /**
     *
     * @return
     */
    public float getRateUp() {
        return rateUp;
    }

    /**
     *
     * @param rateUp
     */
    public void setRateUp(float rateUp) {
        this.rateUp = rateUp;
    }

    @Override
    public String toString() {
        return "TypeCredits{" + "name=" + name + ", maturityOf=" + maturityOf + ", maturityUp=" + maturityUp + ", sumOf=" + sumOf + ", sumUp=" + sumUp + ", rateOf=" + rateOf + ", rateUp=" + rateUp + '}';
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
        final TypeCredits other = (TypeCredits) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}