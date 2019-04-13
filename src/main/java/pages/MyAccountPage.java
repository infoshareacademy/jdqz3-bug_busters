package pages;

import dataModels.User;
import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    private Button myAccount;
    private By myAccountSelector = By.xpath("//a[@href='/shop/customer/dashboard.html']");
    private Button billingAndShippingInformation;
    private By billingAndShippingInformationSelector = By.xpath("//a[@href='/shop/customer/billing.html']");
    private Button changePassword;
    private By changePasswordSelector = By.xpath("//a[contains(text(),'Change password')]");
    private Button logout;
    private By logoutSelector = By.xpath("//ul[@class='nav nav-list']//a[contains(text(),'Logout')]");
    private Button editBillingAddress;
    private By editBillingAddressSelector = By.xpath("//p[contains(text(),'Billing Address')]//a[text()='Edit']");
    private Button addNewShippingAddress;
    private By addNewShippingAddressSelector = By.xpath("//a[contains(text(),'Add a new address')]");
    private TextInput currentPassword;
    private By currentPasswordSelector = By.id("currentPassword");
    private TextInput newPassword;
    private By newPasswordSelector = By.id("password");
    private TextInput repeatPassword;
    private By repeatPasswordSelector = By.id("checkPassword");
    private Button changePasswordButton;
    private By changePasswordButtonSelector = By.id("submitChangePassword");
    private Label invalidPassword;
    private By invalidPasswordSelector = By.id("password.errors");

    public MyAccountPage changeActualPassword(User user) {
        this.currentPassword = new TextInput(driver, currentPasswordSelector);
        this.newPassword = new TextInput(driver, newPasswordSelector);
        this.repeatPassword = new TextInput(driver, repeatPasswordSelector);
        this.currentPassword.type(user.getPassword());
        this.newPassword.type(user.getIncorrectPassword());
        this.repeatPassword.type(user.getIncorrectPassword());
        return new MyAccountPage(driver);
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage chooseMyAccount() {
        this.myAccount = new Button(this.driver, myAccountSelector);
        this.myAccount.click();
        return this;
    }

    public MyAccountPage clickChangePasswordButton() {
        this.changePasswordButton = new Button(driver, changePasswordButtonSelector);
        this.changePasswordButton.click();
        return this;
    }

    public MyAccountPage chooseBillingAndShippingInformation() {
        this.billingAndShippingInformation = new Button(this.driver, billingAndShippingInformationSelector);
        this.billingAndShippingInformation.click();
        return new MyAccountPage(driver);
    }

    public MyAccountPage chooseChangePassword() {
        this.changePassword = new Button(this.driver, changePasswordSelector);
        this.changePassword.click();
        return this;
    }

    public MyAccountPage chooseLogout() {
        this.logout = new Button(this.driver, logoutSelector);
        this.logout.click();
        return this;
    }

    public AccountAddressPage clickEditBillingAddressButton() {
        this.editBillingAddress = new Button(this.driver, editBillingAddressSelector);
        editBillingAddress.clickWithJs();
        return new AccountAddressPage(driver);
    }

    public AccountAddressPage clickAddNewShippingAddress() {
        this.addNewShippingAddress = new Button(this.driver, addNewShippingAddressSelector);
        addNewShippingAddress.clickWithJs();
        return new AccountAddressPage(driver);
    }

    public String getTextFromPasswordLabel() {
        this.invalidPassword = new Label(this.driver, invalidPasswordSelector);
        return this.invalidPassword.read();
    }
}
