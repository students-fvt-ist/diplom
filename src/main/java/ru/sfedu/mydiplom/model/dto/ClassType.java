package ru.sfedu.mydiplom.model.dto;

import static ru.sfedu.mydiplom.Constants.*;

/**
 *
 * @author seyran
 */
public enum ClassType {

    /**
     *
     */
    APP(COLUMNS_APP, Applications.class),

    /**
     *
     */
    CLT(COLUMNS_CLT, Clients.class),

    /**
     *
     */
    PMT(COLUMNS_PMT, Payments.class),

    /**
     *
     */
    TCD(COLUMNS_TCD, TypeCredits.class),

    /**
     *
     */
    DLY(COLUMNS_DLY, Delay.class);
    
    private String[] description;
    private Class cl;
    private ClassType() {
    }

    private ClassType(String[] description, Class cl) {
        this.description = description;
        this.cl=cl;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String[] getDescription() {
        return description;
    }

    public Class getCl() {
        return cl;
    }
    
}
