package za.ac.cput.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class Name implements Serializable {

    private String firstName;
    private String lastName;

    protected Name (){}

    public Name(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName;}

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private String firstName;
        private String lastName;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name){
            this.firstName = name.firstName;
            this.lastName = name.lastName;
            return this;
        }
        public Name build(){ return new Name(this); }
    }
}
