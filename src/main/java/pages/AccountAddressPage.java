package pages;

import dataModels.RegisteredUser;
import elements.Button;
import elements.Label;
import elements.Select;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountAddressPage extends BasePage {

    private Button editBillingAddress;
    private By editBillingAddressSelector = By.xpath("//p[contains(text(),'Billing Address')]");

    private TextInput firstNameInput;
    private By firstNameSelector = By.id("#firstName");
    private TextInput lastNameInput;
    private By lastNameSelector = By.id("#lastName");
    private TextInput companyNameInput;
    private By companyNameSelector = By.id("#company");
    private TextInput streetAddressInput;
    private By streetAddressSelector = By.id("#address");
    private TextInput cityInput;
    private By citySelector = By.id("#city");
    private Select countrySelect;
    private By countrySelector = By.id("#customer_country");
    private TextInput stateProvinceInput;
    private By stateprovinceSelector = By.id("");
    private TextInput postalcodeInput;
    private By postalCodeSelector = By.id("#billingPostalCode");
    private TextInput phoneNumberInput;
    private By phoneNumberSelector = By.id("#phone");

    private Button changeAddressButton;
    private By changeAddressSelector = By.id("#submitAddress");

    private Label requestInformation;
    private By requestInformationSelector = By.xpath("//div[@class='alert alert-success']");


    public AccountAddressPage(WebDriver driver) {
        super(driver);
        this.firstNameInput = new TextInput(this.driver, firstNameSelector);
        this.lastNameInput = new TextInput(this.driver, lastNameSelector);
        this.companyNameInput = new TextInput(this.driver, companyNameSelector);
        this.streetAddressInput = new TextInput(this.driver, streetAddressSelector);
        this.cityInput = new TextInput(this.driver, citySelector);
        this.countrySelect = new Select(this.driver, countrySelector);
        this.stateProvinceInput = new TextInput(this.driver, stateprovinceSelector);
        this.postalcodeInput = new TextInput(this.driver, postalCodeSelector);
        this.phoneNumberInput = new TextInput(this.driver, phoneNumberSelector);
    }

    private void fillInAddress(RegisteredUser registeredUser) {
        firstNameInput.type(registeredUser.getFirstname());
        lastNameInput.type(registeredUser.getLastname());
        companyNameInput.type(registeredUser.getCompanyName());
        streetAddressInput.type(registeredUser.getAddress().getStreetAddress());
        cityInput.type(registeredUser.getAddress().getCity());
        countrySelect.selectByText(registeredUser.getAddress().getCountry());
        postalcodeInput.type(registeredUser.getAddress().getPostalCode());
        phoneNumberInput.type(registeredUser.getPhone());
    }

    public void clickEditBillingAddressButton() {
        this.editBillingAddress = new Button(this.driver, editBillingAddressSelector);
        editBillingAddress.safeClick();
    }

    public void clickChangeAddressButton() {
        this.changeAddressButton = new Button(this.driver, changeAddressSelector);
        changeAddressButton.safeClick();
    }

    public String getCompletedRequestedConfirmation() {
        this.requestInformation = new Label(this.driver, requestInformationSelector);
        return requestInformation.read();
    }

    public boolean isRequestCompleted() {
        String requestCompleted = "Request completed with success";
        return requestCompleted.equals(getCompletedRequestedConfirmation());
    }

}
