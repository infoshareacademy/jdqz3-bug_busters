package tests;

import dataModels.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsPage;
import pages.MainPage;
import pages.MenuPage;

public class ContactUsTests {

    private WebDriver driver;
    private MainPage mainPage;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        user = new User(false);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    public void contactUs() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickContactUs();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage
                .fillInContactUsData(user)
                .clickCaptcha()
                .clickSendButton();
        Assert.assertEquals("Your message has been sent", contactUsPage.getTextFromContactUsLabel());
    }
}