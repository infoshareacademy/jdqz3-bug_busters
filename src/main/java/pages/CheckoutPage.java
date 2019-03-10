package pages;

import dataModels.RegisteredUser;
import elements.Button;
import elements.Select;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private TextInput firstName;
    private By firstNameSelector = By.cssSelector("input[name='customer.billing.firstName']");
    private TextInput lastName;
    private By lastNameSelector = By.cssSelector("input[name='customer.billing.lastName']");
    private TextInput billingCompany;
    private By billingComapnySelector = By.cssSelector("input[name='customer.billing.company']");
    private TextInput streetAddress;
    private By streetAddressSelector = By.cssSelector("input[name='customer.billing.address']");
    private TextInput city;
    private By citySelector = By.cssSelector("input[name='customer.billing.city']");
    private Select country;
    private By coutrySelector = By.cssSelector("select[name='customer.billing.country']");
    private TextInput state;
    private By stateSelector = By.cssSelector("input[name='customer.billing.stateProvince']");
    private TextInput postalCode;
    private By postalCodeSelector = By.cssSelector("input[name='customer.billing.postalCode']");
    private TextInput email;
    private By emailSelector = By.cssSelector("input[name='customer.emailAddress']");
    private TextInput phone;
    private By phoneSelector = By.cssSelector("input[name='customer.billing.phone']");
    private Button submitOrder;
    private By submitOrderSelector = By.cssSelector("button#submitOrder");

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.firstName = new TextInput(this.driver, firstNameSelector);
        this.lastName = new TextInput(this.driver, lastNameSelector);
        this.billingCompany = new TextInput(this.driver, billingComapnySelector);
        this.streetAddress = new TextInput(this.driver, streetAddressSelector);
        this.city = new TextInput(this.driver, citySelector);
        this.country = new Select(this.driver, coutrySelector);
        this.email = new TextInput(this.driver, emailSelector);
        this.phone = new TextInput(this.driver, phoneSelector);
    }

    private void fillInAvailableAddressData (RegisteredUser registeredUser){
        firstName.type(registeredUser.getFirstname());
        lastName.type(registeredUser.getLastname());
        billingCompany.type(registeredUser.getCompanyName());
        streetAddress.type(registeredUser.getAddress().getStreetAddress());
        city.type(registeredUser.getAddress().getCity());
        country.selectByText(registeredUser.getAddress().getCountry());
        email.type(registeredUser.getEmail());
        phone.type(registeredUser.getPhone());
    }

    private void fillInAddressDataAfterReload (RegisteredUser registeredUser){

        state = new TextInput(driver, stateSelector);
        postalCode = new TextInput(driver, postalCodeSelector);
        state.type(registeredUser.getAddress().getState());
        postalCode.type(registeredUser.getAddress().getPostalCode());
    }

    public void fillInCompleteAddress(RegisteredUser registeredUser){
        fillInAvailableAddressData(registeredUser);
        fillInAddressDataAfterReload(registeredUser);
    }

    public void chooseSubmitOrder(){
        submitOrder = new Button(driver, submitOrderSelector);
        submitOrder.click();
    }



}
