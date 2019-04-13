package pages;

import dataModels.Payment;
import dataModels.User;
import elements.Button;
import elements.Label;
import elements.Select;
import elements.TextInput;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private TextInput firstName;
    private By firstNameSelector = By.cssSelector("input[name='customer.billing.firstName']");
    private TextInput lastName;
    private By lastNameSelector = By.cssSelector("input[name='customer.billing.lastName']");
    private TextInput billingCompany;
    private By billingCompanySelector = By.cssSelector("input[name='customer.billing.company']");
    private TextInput streetAddress;
    private By streetAddressSelector = By.cssSelector("input[name='customer.billing.address']");
    private TextInput city;
    private By citySelector = By.cssSelector("input[name='customer.billing.city']");
    private Select country;
    private By countrySelector = By.cssSelector("select[name='customer.billing.country']");
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

    private Label moneyOrderAddress;
    private By moneyOrderAddressSelector = By.xpath("//p[contains(text(),'Send your payment to')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.firstName = new TextInput(this.driver, firstNameSelector);
        this.lastName = new TextInput(this.driver, lastNameSelector);
        this.billingCompany = new TextInput(this.driver, billingCompanySelector);
        this.streetAddress = new TextInput(this.driver, streetAddressSelector);
        this.city = new TextInput(this.driver, citySelector);
        this.country = new Select(this.driver, countrySelector);
        this.email = new TextInput(this.driver, emailSelector);
        this.phone = new TextInput(this.driver, phoneSelector);
    }

    private CheckoutPage fillInAvailableAddressData(User user) {
        firstName.type(user.getFirstname());
        lastName.type(user.getLastname());
        billingCompany.type(user.getCompanyName());
        streetAddress.type(user.getAddress().getStreetAddress());
        city.type(user.getAddress().getCity());
        country.selectByText(user.getAddress().getCountry());
        email.type(user.getEmail());
        phone.type(user.getPhone());
        return this;
    }

    private CheckoutPage fillInAddressDataAfterReload(User user) {

        state = new TextInput(driver, stateSelector);
        postalCode = new TextInput(driver, postalCodeSelector);
        state.type(user.getAddress().getState());
        postalCode.type(user.getAddress().getPostalCode());
        return this;
    }

    public CheckoutPage fillInCompleteAddress(User user) {
        fillInAvailableAddressData(user);
        fillInAddressDataAfterReload(user);
        return this;
    }

    public OrderConfirmationPage chooseSubmitOrder() {
        submitOrder = new Button(driver, submitOrderSelector);
        submitOrder.clickWithJs();
        return new OrderConfirmationPage(driver);
    }

    public String getMoneyOrderAddress() {
        this.moneyOrderAddress = new Label(this.driver, moneyOrderAddressSelector);
        String address =  moneyOrderAddress.read().replaceAll("\n", ",");
        return StringUtils.substring(address,21);
    }

    public boolean isMoneyOrderAddressTheSame(){
        Payment payment = new Payment();
        return payment.equals(getMoneyOrderAddress());
    }
}
