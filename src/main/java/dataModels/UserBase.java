package dataModels;

import generators.AddressGenerator;
import generators.CredentialsGenerator;

public class UserBase {

    private String firstname;
    private String lastname;
    private Address address;
    private Address shippingAddress;
    private String email;
    private Integer phone;
    protected boolean isRegistred;


    protected UserBase(){
        this.firstname = CredentialsGenerator.generateFirstname();
        this.lastname = CredentialsGenerator.generateLastname();
        this.address = new Address(false);
        this.shippingAddress = this.address;
        this.email = CredentialsGenerator.generateEmail();
        this.phone = CredentialsGenerator.generatePhone();

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getPhone() { return phone; }

    public void setPhone(Integer phone) { this.phone = phone; }
}
