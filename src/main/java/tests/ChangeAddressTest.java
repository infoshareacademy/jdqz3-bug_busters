package tests;

import dataModels.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountAddressPage;
import pages.MainPage;
import pages.MyAccountPage;
import prerequisites.Preconditions;

import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeAddressTest {

    private WebDriver driver;
    private MainPage mainPage;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.user = new User(false);
        Preconditions preconditions = new Preconditions(driver);
        preconditions.registration(user);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    public void changeBillingAddress() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage
                .chooseBillingAndShippingInformation()
                .clickEditBillingAddressButton();
        AccountAddressPage accountAddressPage = new AccountAddressPage(driver);
        accountAddressPage
                .fillInAddress(user)
                .clickChangeAddressButton();
        assertThat("Request completed with success", accountAddressPage.isRequestCompleted());
    }

    @Test
    public void addNewShippingAddress() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage
                .chooseBillingAndShippingInformation()
                .clickAddNewShippingAddress();
        AccountAddressPage accountAddressPage = new AccountAddressPage(driver);
        accountAddressPage
                .fillInAddress(user)
                .clickChangeAddressButton();
        assertThat("Request completed with success", accountAddressPage.isRequestCompleted());
    }

}
