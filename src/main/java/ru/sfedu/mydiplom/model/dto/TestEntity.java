package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table
public class TestEntity implements Serializable{
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Date dateCreated;
    @Column
    private Boolean check;

    public TestEntity() {
    }

    public TestEntity(Long id, String name, String description, Date dateCreated, Boolean check) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.check = check;
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

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
