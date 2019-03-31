package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends MainPage {

    private Button myAccount;
    private By myAccountSelector = By.xpath("//a[@href='/shop/customer/dashboard.html']");

    private Button billingAndShippingInformation;
    private By billingAndShippingInformationSelector = By.xpath("//a[@href='/shop/customer/billing.html']");

    private Button changePassword;
    private By changePasswordSelector = By.xpath("//a[contains(text(),'Change password')]");

    private Button logout;
    private By logoutSelector = By.xpath("//ul[@class='nav nav-list']//a[contains(text(),'Logout')]");


    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.myAccount = new Button(this.driver, myAccountSelector);
        this.billingAndShippingInformation = new Button(this.driver, billingAndShippingInformationSelector);
        this.changePassword = new Button(this.driver, changePasswordSelector);
        this.logout = new Button(this.driver, logoutSelector);
    }

    public void chooseMyAccount() {
        this.myAccount.click();
    }

    public void chooseBillingAndShippingInformation() {
        this.billingAndShippingInformation.click();
    }

    public void chooseChangePassword() {
        this.changePassword.click();
    }

    public void chooseLogout() {
        this.logout.click();
    }

}
