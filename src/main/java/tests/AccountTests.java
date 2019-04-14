package tests;

import categories.AdditionalTests;
import dataModels.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.MenuPage;
import pages.MyAccountPage;
import prerequisites.Preconditions;

public class AccountTests {

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
    @Category(AdditionalTests.class)
    public void isNewlyRegisteredUserNotLoggedInAfterLogout() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage
                .chooseLogout();
        MenuPage menuPage = new MenuPage(driver);
        menuPage.
                isUserLoggedOut();
    }

    @Test
    @Category(AdditionalTests.class)
    public void changePasswordIncorrect() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage
                .chooseChangePassword()
                .changeActualPassword(user)
                .clickChangePasswordButton();
        Assert.assertEquals("Invalid password", myAccountPage.getTextFromPasswordLabel());
    }
}
