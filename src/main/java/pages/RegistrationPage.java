package pages;

import dataModels.User;
import elements.Button;
import elements.Select;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private By firstNameSelector = By.id("firstName");
    private TextInput firstName;
    private By lastNameSelector = By.id("lastName");
    private TextInput lastName;
    private By countrySelector = By.id("registration_country");
    private Select country;
    private By stateSelector = By.id("hidden_zones");
    private TextInput state;
    private By emailSelector = By.id("emailAddress");
    private TextInput email;
    private By passwordSelector = By.id("password");
    private TextInput password;
    private By repeatPasswordSelector = By.id("passwordAgain");
    private TextInput repeatPassword;
    private By createAnAccountSelector = By.xpath("//button[text()='Create an account']");
    private Button createAnAccountBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.firstName = new TextInput(this.driver, firstNameSelector);
        this.lastName = new TextInput(this.driver, lastNameSelector);
        this.country = new Select(this.driver, countrySelector);
        this.state = new TextInput(this.driver, stateSelector);
        this.email = new TextInput(this.driver, emailSelector);
        this.password = new TextInput(this.driver, passwordSelector);
        this.repeatPassword = new TextInput(this.driver, repeatPasswordSelector);
    }

    public RegistrationPage fillInRegistrationData(User user){
        this.firstName.type(user.getFirstname());
        this.lastName.type(user.getLastname());
        this.country.selectByText(user.getAddress().getCountry());
        this.state.type(user.getAddress().getState());
        this.email.type(user.getEmail());
        this.password.type(user.getPassword());
        this.repeatPassword.type(user.getPassword());
        return this;
    }

    public void createAnAccount(){
        this.createAnAccountBtn = new Button(this.driver, createAnAccountSelector);
        this.createAnAccountBtn.click();
    }
}
