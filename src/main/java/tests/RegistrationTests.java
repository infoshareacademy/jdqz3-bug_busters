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

public class RegistrationTests {

    private WebDriver driver;
    private MainPage mainPage;
    private User user;

    @Before
    public void startBrowser(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.user = new User(false);
    }

    @After
    public void closeBrowser(){
        mainPage.close();
    }

    @Test
    @Category(AdditionalTests.class)
    public void registrationPositiveScenario(){
        MenuPage menuPage = new MenuPage(driver);

                menuPage
                .chooseRegister()
                .fillInRegistrationData(user)
                .createAnAccount();

        Assert.assertTrue("Registration process has failed", menuPage.isUserLoggedIn(user));
    }
}
