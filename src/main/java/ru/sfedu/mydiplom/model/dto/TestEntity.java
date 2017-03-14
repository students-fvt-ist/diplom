package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table
public class TestEntity implements Serializable{
    @Id
    private Long id=1l;
    private String name;
    private String description;
    private Date dateCreated;
    private boolean checke;
    @Embedded
        @AttributeOverrides( {
            @AttributeOverride(name="vender",
                column = @Column(name="OWEN_VENDER") ),
            @AttributeOverride(name ="model",
                column = @Column(name="OWEN_MODEL") ),
            @AttributeOverride(name = "number",
                column = @Column(name="OWEN_NUMBER") )
    })
    private Automobile owenAutomobile;
    @Embedded
        @AttributeOverrides( {
            @AttributeOverride(name="vender",
                column = @Column(name="WORKING_VENDER") ),
            @AttributeOverride(name ="model",
                column = @Column(name="WORKING_MODEL") ),
            @AttributeOverride(name = "number",
                column = @Column(name="WORKING_NUMBER") )
    })
    private Automobile workingAutomobile;

    public TestEntity() {
    }

    public TestEntity(String name, String description, Date dateCreated, boolean checke, Automobile owenAutomobile, Automobile workingAutomobile) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.checke = checke;
        this.owenAutomobile = owenAutomobile;
        this.workingAutomobile = workingAutomobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isChecke() {
        return checke;
    }

    public void setChecke(boolean checke) {
        this.checke = checke;
    }

    public Automobile getOwenAutomobile() {
        return owenAutomobile;
    }

    public void setOwenAutomobile(Automobile owenAutomobile) {
        this.owenAutomobile = owenAutomobile;
    }

    public Automobile getWorkingAutomobile() {
        return workingAutomobile;
    }

    public void setWorkingAutomobile(Automobile workingAutomobile) {
        this.workingAutomobile = workingAutomobile;
    }

}
