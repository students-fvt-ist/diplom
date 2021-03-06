package ru.sfedu.mydiplom.model.dto.joinedtable;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity(name = "AccountJoinedTable")
@Inheritance(strategy = InheritanceType.JOINED)
public class AccountJoinedTable implements Serializable{
    @Id
    Long id;
    BigDecimal balance;
    String owner;
    BigDecimal interestRate;

    public AccountJoinedTable() {
    }

    public AccountJoinedTable(long id, BigDecimal balance, String owner, BigDecimal interestRate) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
        this.interestRate = interestRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", balance=" + balance + ", owner=" + owner + ", interestRate=" + interestRate + '}';
    }
    
}
