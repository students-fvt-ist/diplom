package ru.sfedu.mydiplom.model.dto.mappedsuperclass;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity(name = "CreditAccountMappedSuperclass")
public class CreditAccountMappedSuperclass extends AccountMappedSuperclass{
    BigDecimal creditLimit;

    public CreditAccountMappedSuperclass() {
    }

    public CreditAccountMappedSuperclass(BigDecimal creditLimit, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
