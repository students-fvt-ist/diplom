package ru.sfedu.mydiplom.model.dto;

import java.io.Serializable;
import org.simpleframework.xml.*;

@Root
public class GenericDto implements Serializable{
    @Attribute
    long id=1l;
    @Attribute
    private  ClassType typeClass;

    /**
     *
     * @param typeClass
     * @param id
     */
    public GenericDto(ClassType typeClass, long id){
        this.typeClass=typeClass;
        this.id = id;
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public ClassType getTypeClass() {
        return typeClass;
    }

    /**
     *
     * @param typeClass
     */
    public void setTypeClass(ClassType typeClass) {
        this.typeClass = typeClass;
    }
}
