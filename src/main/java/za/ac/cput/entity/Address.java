package za.ac.cput.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Embeddable
public class Address {

    private int streetNumber;
    private String streetName;
    private String city;
    private int postalCode;

    protected Address (){}

    public Address(Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public int getStreetNumber() { return streetNumber; }

    public String getStreetName() { return streetName; }

    public String getCity() { return city; }

    public int getPostalCode() { return postalCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber && postalCode == address.postalCode && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() { return Objects.hash(streetNumber, streetName, city, postalCode); }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
    public static class Builder{
        private int streetNumber;
        private String streetName;
        private String city;
        private int postalCode;

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(Address address){
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.city = address.city;
            this.postalCode = address.postalCode;
            return this;
        }

        public Address build(){ return new Address(this); }
    }
}
