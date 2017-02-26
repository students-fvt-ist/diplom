
package ru.sfedu.mydiplom.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Clients extends GenericDto{
    @Element
    private long dateOfBirth;
    @Element
    private int status;
    @Element
    private int passportNumber;
    @Element
    private float salary;
    @Element
    private float experience;
    @Element
    private float experienceOfLastWP;
    @Element
    private float totalGain;
    @Element
    private boolean conviction;
    @Element
    private boolean working;
    @Element
    private boolean changedPassport;
    @Element
    private String name;
    @Element
    private String placeOfWorking;
    @Element
    private String addres;
    @Element
    private String phone;
    @Element
    private String workPhone;
    @Element
    private String passportData;
    @Element
    private String otherDocument;

    /**
     *
     * @throws InterruptedException
     */
    public Clients() throws InterruptedException {
        super(ClassType.CLT, 1l);
    }

    /**
     *
     * @param id
     * @param dateOfBirth
     * @param status
     * @param passportNumber
     * @param salary
     * @param experience
     * @param experienceOfLastWP
     * @param totalGain
     * @param conviction
     * @param working
     * @param changedPassport
     * @param name
     * @param placeOfWorking
     * @param addres
     * @param phone
     * @param workPhone
     * @param passportData
     * @param otherDocument
     * @throws InterruptedException
     */
    public Clients(long id, long dateOfBirth, int status, int passportNumber, float salary, float experience, float experienceOfLastWP, float totalGain, boolean conviction, boolean working, boolean changedPassport, String name, String placeOfWorking, String addres, String phone, String workPhone, String passportData, String otherDocument) throws InterruptedException {
        super(ClassType.CLT, id);
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
    }
    
    /**
     *
     * @return
     */
    public boolean isConviction(){
        return conviction;
    }
    
    /**
     *
     * @return
     */
    public boolean isWorking(){
        return working;
    }
    
    /**
     *
     * @return
     */
    public boolean isChangedPassport(){
        return changedPassport;
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
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public long getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @return
     */
    public int getPassportNumber() {
        return passportNumber;
    }

    /**
     *
     * @return
     */
    public float getSalary() {
        return salary;
    }

    /**
     *
     * @return
     */
    public float getExperience() {
        return experience;
    }

    /**
     *
     * @return
     */
    public float getExperienceOfLastWP() {
        return experienceOfLastWP;
    }

    /**
     *
     * @return
     */
    public float getTotalGain() {
        return totalGain;
    }

    /**
     *
     * @return
     */
    public String getPlaceOfWorking() {
        return placeOfWorking;
    }

    /**
     *
     * @return
     */
    public String getAddres() {
        return addres;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return
     */
    public String getWorkPhone() {
        return workPhone;
    }

    /**
     *
     * @return
     */
    public String getPassportData() {
        return passportData;
    }

    /**
     *
     * @return
     */
    public String getOtherDocument() {
        return otherDocument;
    }

    /**
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @param passportNumber
     */
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     *
     * @param experience
     */
    public void setExperience(float experience) {
        this.experience = experience;
    }

    /**
     *
     * @param experienceOfLastWP
     */
    public void setExperienceOfLastWP(float experienceOfLastWP) {
        this.experienceOfLastWP = experienceOfLastWP;
    }

    /**
     *
     * @param totalGain
     */
    public void setTotalGain(float totalGain) {
        this.totalGain = totalGain;
    }

    /**
     *
     * @param conviction
     */
    public void setConviction(boolean conviction) {
        this.conviction = conviction;
    }

    /**
     *
     * @param working
     */
    public void setWorking(boolean working) {
        this.working = working;
    }

    /**
     *
     * @param changedPassport
     */
    public void setChangedPassport(boolean changedPassport) {
        this.changedPassport = changedPassport;
    }

    /**
     *
     * @param placeOfWorking
     */
    public void setPlaceOfWorking(String placeOfWorking) {
        this.placeOfWorking = placeOfWorking;
    }

    /**
     *
     * @param addres
     */
    public void setAddres(String addres) {
        this.addres = addres;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param workPhone
     */
    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    /**
     *
     * @param passportData
     */
    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    /**
     *
     * @param otherDocument
     */
    public void setOtherDocument(String otherDocument) {
        this.otherDocument = otherDocument;
    }

    @Override
    public String toString() {
        return "Clients{" + "dateOfBirth=" + dateOfBirth + ", status=" + status + ", passportNumber=" + passportNumber + ", salary=" + salary + ", experience=" + experience + ", experienceOfLastWP=" + experienceOfLastWP + ", totalGain=" + totalGain + ", conviction=" + conviction + ", working=" + working + ", changedPassport=" + changedPassport + ", name=" + name + ", placeOfWorking=" + placeOfWorking + ", addres=" + addres + ", phone=" + phone + ", workPhone=" + workPhone + ", passportData=" + passportData + ", otherDocument=" + otherDocument + '}';
    }
    
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Clients other = (Clients) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        return true;
//    }
    
}
