package tests;

import addins.Snapshot;
import categories.AdditionalTests;
import categories.MainTests;
import dataModels.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
        this.user = new User(false);
        Preconditions preconditions = new Preconditions();
        preconditions.createUser(user);

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    @Category(AdditionalTests.class)
    public void changeBillingAddress() throws Exception {
        try {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage
                    .chooseBillingAndShippingInformation()
                    .clickEditBillingAddressButton();
            AccountAddressPage accountAddressPage = new AccountAddressPage(driver);
            accountAddressPage
                    .fillInAddress(user)
                    .clickChangeAddressButton();
            assertThat("Request completed with success", accountAddressPage.isRequestCompleted());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }

    @Test
    @Category(MainTests.class)
    public void addNewShippingAddress() throws Exception {
        try {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage
                    .chooseBillingAndShippingInformation()
                    .clickAddNewShippingAddress();
            AccountAddressPage accountAddressPage = new AccountAddressPage(driver);
            accountAddressPage
                    .fillInAddress(user)
                    .clickChangeAddressButton();
            assertThat("Request completed with success", accountAddressPage.isRequestCompleted());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }
}
