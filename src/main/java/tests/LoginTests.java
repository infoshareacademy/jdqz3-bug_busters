package tests;

import addins.Snapshot;
import categories.AdditionalTests;
import categories.MainTests;
import dataModels.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.MenuPage;
import pages.SignInPage;
import prerequisites.Preconditions;


@RunWith(JUnitParamsRunner.class)
public class LoginTests {

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
    public void logout() throws Exception {
        try {
            MenuPage menuPage = new MenuPage(driver);
            menuPage.chooseSignIn()
                    .fillInLoginData(user)
                    .chooseSignInButton();
            menuPage.chooseLogout();

            Assert.assertTrue("Logout process has failed", menuPage.isUserLoggedOut());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }

    @Test
    @Category(AdditionalTests.class)
    public void loginPositiveScenario() throws Exception {
        try {
            MenuPage menuPage = new MenuPage(driver);
            menuPage
                    .chooseSignIn()
                    .fillInLoginData(user)
                    .chooseSignInButton();

            Assert.assertTrue("Login process has failed", menuPage.isUserLoggedIn(user));
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }

    @Test
    @Parameters(method = "loginParams")
    @Category(MainTests.class)
    public void loginWithIncorrectData(String mail, String pass) throws Exception {
        try {
            MenuPage menuPage = new MenuPage(driver);

            menuPage
                    .chooseSignIn()
                    .fillInLoginDataWithIncorrectData(mail, pass)
                    .chooseSignInButton();

            SignInPage signInPage = new SignInPage(driver);
            Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }

    private Object[][] loginParams() {

        return new Object[][]{
                {"login@incorrect", "pass1234"},
                {"", ""}
        };
    }

    @Test
    @Category(AdditionalTests.class)
    public void loginWithIncorrectPassword() throws Exception {
        try {
            MenuPage menuPage = new MenuPage(driver);
            menuPage.chooseSignIn().fillInLoginDataWithIncorrectPassword(user).chooseSignInButton();

            SignInPage signInPage = new SignInPage(driver);
            Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }
}
