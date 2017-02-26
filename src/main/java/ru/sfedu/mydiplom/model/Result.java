
package ru.sfedu.mydiplom.model;

import java.util.Objects;

/**
 *
 * @author seyran
 */
public class Result {
    private String status;
    private String errorMsg;

    /**
     *
     */
    public Result() {
    }
    
    public Result(String status) {
        this.status = status;
    }
    
    public Result(String status, String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param satus the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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
        final Result other = (Result) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
    
}
