
package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

public class Clients extends GenericDto{
    private long id = 1l;
    private long dateOfBirth;
    private int status;
    private int passportNumber;
    private float salary;
    private float experience;
    private float experienceOfLastWP;
    private float totalGain;
    private boolean conviction;
    private boolean working;
    private boolean changedPassport;
    private String name;
    private String placeOfWorking;
    private String addres;
    private String phone;
    private String workPhone;
    private String passportData;
    private String otherDocument;

    public Clients() throws InterruptedException {
        super(ClassType.CLT, 1l);
        Thread.sleep(1);
    }

    public Clients(long id, long dateOfBirth, int status, int passportNumber, float salary, float experience, float experienceOfLastWP, float totalGain, boolean conviction, boolean working, boolean changedPassport, String name, String placeOfWorking, String addres, String phone, String workPhone, String passportData, String otherDocument) throws InterruptedException {
        super(ClassType.CLT, id);
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.passportNumber = passportNumber;
        this.salary = salary;
        this.experience = experience;
        this.experienceOfLastWP = experienceOfLastWP;
        this.totalGain = totalGain;
        this.conviction = conviction;
        this.working = working;
        this.changedPassport = changedPassport;
        this.name = name;
        this.placeOfWorking = placeOfWorking;
        this.addres = addres;
        this.phone = phone;
        this.workPhone = workPhone;
        this.passportData = passportData;
        this.otherDocument = otherDocument;
        Thread.sleep(1);
    }
    
    public boolean isConviction(){
        return conviction;
    }
    
    public boolean isWorking(){
        return working;
    }
    
    public boolean isChangedPassport(){
        return changedPassport;
    }
    
    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public float getSalary() {
        return salary;
    }

    public float getExperience() {
        return experience;
    }

    public float getExperienceOfLastWP() {
        return experienceOfLastWP;
    }

    public float getTotalGain() {
        return totalGain;
    }

    public String getPlaceOfWorking() {
        return placeOfWorking;
    }

    public String getAddres() {
        return addres;
    }

    public String getPhone() {
        return phone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getPassportData() {
        return passportData;
    }

    public String getOtherDocument() {
        return otherDocument;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public void setExperienceOfLastWP(float experienceOfLastWP) {
        this.experienceOfLastWP = experienceOfLastWP;
    }

    public void setTotalGain(float totalGain) {
        this.totalGain = totalGain;
    }

    public void setConviction(boolean conviction) {
        this.conviction = conviction;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public void setChangedPassport(boolean changedPassport) {
        this.changedPassport = changedPassport;
    }

    public void setPlaceOfWorking(String placeOfWorking) {
        this.placeOfWorking = placeOfWorking;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public void setOtherDocument(String otherDocument) {
        this.otherDocument = otherDocument;
    }
    
    @Override
    public String toString() {
        return + id + ";" + dateOfBirth;
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
        final Clients other = (Clients) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
