package za.ac.cput.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AccountHolder {
    @Id
    private long accountHolderId;
    @Embedded
    private Name name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Contact contact;
    @Embedded
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_Id")
    private  Account account;

    protected AccountHolder() {}

    public AccountHolder(Builder builder) {
        this.accountHolderId = builder.accountHolderId;
        this.name = builder.name;
        this.contact = builder.contact;
        this.address = builder.address;
        this.account = builder.account;
    }

    public long getAccountHolderId() {
        return accountHolderId;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolder that = (AccountHolder) o;
        return accountHolderId == that.accountHolderId && Objects.equals(name, that.name) && Objects.equals(contact, that.contact) && Objects.equals(address, that.address) && Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderId, name, contact, address, account);
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "accountHolderId=" + accountHolderId +
                ", name=" + name +
                ", contact=" + contact +
                ", address=" + address +
                ", account=" + account +
                '}';
    }

    public static class Builder{
        private long accountHolderId;
        private Name name;
        private Contact contact;
        private Address address;
        private  Account account;

        public Builder setAccountHolderId(long accountHolderId) {
            this.accountHolderId = accountHolderId;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public Builder copy(AccountHolder accountHolder){
            this.accountHolderId = accountHolder.accountHolderId;
            this.name = accountHolder.name;
            this.contact = accountHolder.contact;
            this.address = accountHolder.address;
            this.account = accountHolder.account;
            return this;
        }

        public AccountHolder build(){ return new AccountHolder(this); }
    }

}
