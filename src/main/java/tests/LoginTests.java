package tests;

import dataModels.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.MenuPage;
import pages.SignInPage;
import prerequisites.Preconditions;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class LoginTests {

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
        preconditions.logout();
    }

    @After
    public void closeBrowser(){
        mainPage.close();
    }


    @Test
    public void logout() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage.chooseSignIn()
                .fillInLoginData(user)
                .chooseSignInButton();
        menuPage.chooseLogout();

        Assert.assertTrue("Logout process has failed", menuPage.isUserLoggedOut());
    }


    @Test
    public void loginPositiveScenario() {
        MenuPage menuPage = new MenuPage(driver);
        menuPage
                .chooseSignIn()
                .fillInLoginData(user)
                .chooseSignInButton();

        Assert.assertTrue("Login process has failed", menuPage.isUserLoggedIn(user) );
    }


    @Test
    @Parameters(method = "loginParams")
    public void loginWithIncorrectData(String mail, String pass){
        MenuPage menuPage = new MenuPage(driver);

        menuPage
                .chooseSignIn()
                .fillInLoginDataWithIncorrectData(mail, pass)
                .chooseSignInButton();

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
    }

    private Object[][] loginParams() {

        return new Object[][]{
                {"login@incorrect", "pass1234"},
                {"", ""}
        };
    }


    @Test
    public void loginWithIncorrectPassword() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.chooseSignIn().fillInLoginDataWithIncorrectPassword(user).chooseSignInButton();

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
    }


}
