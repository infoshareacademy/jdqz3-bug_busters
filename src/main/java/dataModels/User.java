package dataModels;

import generators.CredentialsGenerator;

public class User extends UserBase{

    private String password;
    private String incorrectPassword;


    public User(boolean withAlternativeShippingAddress){
        this.isRegistred = true;
        this.password = CredentialsGenerator.generatePassword();
        this.incorrectPassword = CredentialsGenerator.generatePassword();
        this.setAddress(new Address(true));
        if (withAlternativeShippingAddress){
            this.setShippingAddress(new Address(true));
        }
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

    public String getPassword() {
        return password;
    }
}
