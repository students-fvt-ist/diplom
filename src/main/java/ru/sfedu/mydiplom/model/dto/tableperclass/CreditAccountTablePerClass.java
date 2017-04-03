package ru.sfedu.mydiplom.model.dto.tableperclass;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity(name = "CreditAccountTablePerClass")
public class CreditAccountTablePerClass extends AccountTablePerClass{
    BigDecimal creditLimit;

    public CreditAccountTablePerClass() {
    }

    public CreditAccountTablePerClass(BigDecimal creditLimit, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
