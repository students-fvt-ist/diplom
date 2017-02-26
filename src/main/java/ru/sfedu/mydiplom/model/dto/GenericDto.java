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
     * @throws InterruptedException
     */
    public GenericDto(ClassType typeClass, long id) throws InterruptedException {
        this.typeClass=typeClass;
        this.id = id;
        Thread.sleep(1);
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
