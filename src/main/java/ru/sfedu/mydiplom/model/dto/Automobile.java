package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Automobile implements Serializable{
    @Column(name = "AUTOMOBILE_VENDER", nullable = false)
    private String vender;
    @Column(name = "AUTOMOBILE_MODEL", nullable = false)
    private String model;
    @Column(name = "AUTOMOBILE_NUMBER", nullable = false)
    private String number;

    public Automobile() {
    }

    public Automobile(String vender, String model, String number) {
        this.vender = vender;
        this.model = model;
        this.number = number;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Automobile{" + "vender=" + vender + ", model=" + model + ", number=" + number + '}';
    }

}
