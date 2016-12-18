package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

public class TypeCredits extends GenericDto{
    private String name;
    private int maturityOf;
    private int maturityUp;
    private float sumOf;
    private float sumUp;
    private float rateOf;
    private float rateUp;

    public TypeCredits() throws InterruptedException {
        super(ClassType.TCD, 1l);
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaturityOf() {
        return maturityOf;
    }

    public void setMaturityOf(int maturityOf) {
        this.maturityOf = maturityOf;
    }

    public int getMaturityUp() {
        return maturityUp;
    }

    public void setMaturityUp(int maturityUp) {
        this.maturityUp = maturityUp;
    }

    public float getSumOf() {
        return sumOf;
    }

    public void setSumOf(float sumOf) {
        this.sumOf = sumOf;
    }

    public float getSumUp() {
        return sumUp;
    }

    public void setSumUp(float sumUp) {
        this.sumUp = sumUp;
    }

    public float getRateOf() {
        return rateOf;
    }

    public void setRateOf(float rateOf) {
        this.rateOf = rateOf;
    }

    public float getRateUp() {
        return rateUp;
    }

    public void setRateUp(float rateUp) {
        this.rateUp = rateUp;
    }

    @Override
    public String toString() {
        return "id=" + id;
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