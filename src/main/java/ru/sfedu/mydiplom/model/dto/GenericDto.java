package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;

public class GenericDto implements Serializable{
    long id=1l;
    private  ClassType typeClass;

    public GenericDto(ClassType typeClass, long id) {
        this.typeClass=typeClass;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassType getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(ClassType typeClass) {
        this.typeClass = typeClass;
    }
    
    
}
