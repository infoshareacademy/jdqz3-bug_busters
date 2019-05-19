package tests;

import addins.Snapshot;
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
    public void isNewlyRegisteredUserNotLoggedInAfterLogout() throws Exception {
        try {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage
                    .chooseLogout();
            MenuPage menuPage = new MenuPage(driver);
            menuPage.
                    isUserLoggedOut();
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }


    @Test
    @Category(AdditionalTests.class)
    public void changePasswordIncorrect() throws Exception {
        try {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage
                    .chooseChangePassword()
                    .changeActualPassword(user)
                    .clickChangePasswordButton();
            Assert.assertEquals("Invalid password", myAccountPage.getTextFromPasswordLabel());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }
}
