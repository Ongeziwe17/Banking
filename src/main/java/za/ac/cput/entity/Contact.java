package za.ac.cput.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    private String email;
    private String cellNumber;

    protected Contact(){}

    public Contact(Builder builder) {
        this.email = builder.email;
        this.cellNumber = builder.cellNumber;
    }

    public String getEmail() { return email; }

    public String getCellNumber() { return cellNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(cellNumber, contact.cellNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(email, cellNumber);}

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String email;
        private String cellNumber;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public Builder copy(Contact contact){
            this.email = contact.email;
            this.cellNumber = contact.cellNumber;
            return this;
        }

        public Contact build(){ return new Contact(this); }
    }
}
