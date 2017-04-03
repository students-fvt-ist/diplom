package ru.sfedu.mydiplom.model.dto.joinedtable;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "DebitAccountJoinedTable")
@PrimaryKeyJoinColumn(name = "account_id")
public class DebitAccountJoinedTable extends AccountJoinedTable{
    BigDecimal overdraftFree;

    public DebitAccountJoinedTable() {
    }

    public DebitAccountJoinedTable(BigDecimal overdraftFree, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
