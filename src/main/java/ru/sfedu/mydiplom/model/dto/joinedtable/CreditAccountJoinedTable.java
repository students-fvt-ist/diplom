package ru.sfedu.mydiplom.model.dto.joinedtable;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "CreditAccountJoinedTable")
@PrimaryKeyJoinColumn(name = "account_id")
public class CreditAccountJoinedTable extends AccountJoinedTable{
    BigDecimal creditLimit;

    public CreditAccountJoinedTable() {
    }

    public CreditAccountJoinedTable(BigDecimal creditLimit, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
        super(id, balance, owner, interestRate);
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "CreditAccount{" + "creditLimit=" + creditLimit + super.toString() + '}';
    }
    
}
