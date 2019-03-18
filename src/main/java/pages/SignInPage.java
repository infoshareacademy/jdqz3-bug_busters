package pages;

import elements.Button;
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

    public SignInPage(WebDriver driver) {
        super(driver);
        this.customerEmail = new TextInput(this.driver, customerEmailSelector);
        this.password = new TextInput(this.driver, passwordSelector);
        this.signInBtn = new Button(this.driver, signInBtnSelector);

    }
}
