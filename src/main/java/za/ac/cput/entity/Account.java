package za.ac.cput.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import za.ac.cput.entity.enums.AccountType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Account {
    @Id
    private long accountId;
    private AccountType accountType;
    private LocalDateTime dateCreated;
    private LocalDate expiryDate;

    protected Account(){}

    public Account(Builder builder) {
        this.accountId = builder.accountId;
        this.accountType = builder.accountType;
        this.dateCreated = builder.dateCreated;
        this.expiryDate = builder.expiryDate;
    }

    public long getAccountId() {
        return accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId && accountType == account.accountType && Objects.equals(dateCreated, account.dateCreated) && Objects.equals(expiryDate, account.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountType, dateCreated, expiryDate);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType=" + accountType +
                ", dateCreated=" + dateCreated +
                ", expiryDate=" + expiryDate +
                '}';
    }
    public static class Builder{
        private long accountId;
        private AccountType accountType;
        private LocalDateTime dateCreated;
        private LocalDate expiryDate;

        public Builder setAccountId(long accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setAccountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setDateCreated(LocalDateTime dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder copy(Account account){
            this.accountId = account.accountId;
            this.accountType = account.accountType;
            this.dateCreated = account.dateCreated;
            this.expiryDate = account.expiryDate;
            return this;
        }
        public Account build(){ return new Account(this); }
    }
}
