package ru.sfedu.mydiplom.model.dto;

public enum ApplicationStatusType {
    
    BLK("Blank"),
    APP("Application"),
    CRD("Credit");
    
    private String description;
    private ApplicationStatusType() {
    }

    private ApplicationStatusType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return description;
    }
}
