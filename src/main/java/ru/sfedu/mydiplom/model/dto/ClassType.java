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
    APP(COLUMNS_APP),

    /**
     *
     */
    CLT(COLUMNS_CLT),

    /**
     *
     */
    PMT(COLUMNS_PMT),

    /**
     *
     */
    TCD(COLUMNS_TCD),

    /**
     *
     */
    DLY(COLUMNS_DLY);
    
    private String[] description;
    private ClassType() {
    }

    private ClassType(String[] description) {
        this.description = description;
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
    
}
