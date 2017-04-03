package ru.sfedu.mydiplom.model.dto.singletable;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "DebitAccountSingleTable")
@DiscriminatorValue("Debit")
public class DebitAccountSingleTable extends AccountSingleTable{
    BigDecimal overdraftFree;

    public DebitAccountSingleTable() {
    }

    public DebitAccountSingleTable(BigDecimal overdraftFree, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
