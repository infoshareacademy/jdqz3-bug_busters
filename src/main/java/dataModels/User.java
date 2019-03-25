package dataModels;

import generators.CredentialsGenerator;

public class User extends UserBase{

    private String password;

    public User(){
        this.isRegistred = true;
        this.password = CredentialsGenerator.generatePassword();
        Address add = new Address(true);
        this.setAddress(add);
        this.setShippingAddress(add);
    }

    public User(boolean withAlternativeShippingAddress){
        if (withAlternativeShippingAddress){
            this.isRegistred = true;
            this.password = CredentialsGenerator.generatePassword();
            this.setAddress(new Address(true));
            this.setShippingAddress(new Address(true));
        } else {
            new User();
        }
    }

    public String getPassword() {
        return password;
    }
}
