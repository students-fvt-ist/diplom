package ru.sfedu.mydiplom.model.dto.singletable;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CreditAccountSingleTable")
public class CreditAccountSingleTable extends AccountSingleTable{
    BigDecimal creditLimit;

    public CreditAccountSingleTable() {
    }

    public CreditAccountSingleTable(BigDecimal creditLimit, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
