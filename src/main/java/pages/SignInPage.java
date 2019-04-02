package pages;

import dataModels.User;
import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    private By customerEmailSelector = By.id("signin_userName");
    private TextInput customerEmail;
    private By passwordSelector = By.id("signin_password");
    private TextInput password;
    private By signInBtnSelector = By.id("genericLogin-button");
    private Button signInBtn;
    private By loginErrorSelector = By.id("loginError");
    private Label loginErrorMessage;


    public SignInPage(WebDriver driver) {
        super(driver);
        this.customerEmail = new TextInput(this.driver, customerEmailSelector);
        this.password = new TextInput(this.driver, passwordSelector);
    }

    public SignInPage fillInLoginData(User user) {
        this.customerEmail.type(user.getEmail());
        this.password.type(user.getPassword());
        return this;
    }

    public SignInPage fillInLoginDataWithIncorrectPassword(User user) {
        this.customerEmail.type(user.getEmail());
        this.password.type(user.getIncorrectPassword());
        return this;
    }

    public void chooseSignInButton() {
        this.signInBtn = new Button(this.driver, signInBtnSelector);
        this.signInBtn.click();
    }



    public boolean isLoginFailed(){
        String message = "Login Failed. Username or Password is incorrect.";
        this.loginErrorMessage = new Label(this.driver, loginErrorSelector);
        return this.loginErrorMessage.read().equals(message);
    }
}
