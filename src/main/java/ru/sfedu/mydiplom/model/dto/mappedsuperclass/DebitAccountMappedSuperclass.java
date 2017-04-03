package ru.sfedu.mydiplom.model.dto.mappedsuperclass;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity(name = "DebitAccountMappedSuperclass")
public class DebitAccountMappedSuperclass extends AccountMappedSuperclass{
    BigDecimal overdraftFree;

    public DebitAccountMappedSuperclass() {
    }

    public DebitAccountMappedSuperclass(BigDecimal overdraftFree, long id, BigDecimal balance, String owner, BigDecimal interestRate) {
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
