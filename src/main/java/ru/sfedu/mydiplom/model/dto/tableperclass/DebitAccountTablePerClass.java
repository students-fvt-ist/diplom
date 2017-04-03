package ru.sfedu.mydiplom.model.dto.tableperclass;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity(name = "DebitAccountTablePerClass")
public class DebitAccountTablePerClass extends AccountTablePerClass{
    BigDecimal overdraftFree;

    public DebitAccountTablePerClass() {
    }

    public DebitAccountTablePerClass(BigDecimal overdraftFree, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
        super(id, balance, owner, interestRate);
        this.overdraftFree = overdraftFree;
    }

    public BigDecimal getOverdraftFree() {
        return overdraftFree;
    }

    public void setOverdraftFree(BigDecimal overdraftFree) {
        this.overdraftFree = overdraftFree;
    }

    @Override
    public String toString() {
        return "DebitAccount{" + "overdraftFree=" + overdraftFree + super.toString() +'}';
    }
    
}
