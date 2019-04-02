package tests;

import dataModels.User;
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

public class LoginTests {

    private WebDriver driver;
    private MainPage mainPage;
    private User user;

    @Before
    public void startBrowser(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.user = new User(false);
//        MenuPage menuPage = new MenuPage(driver);
        Preconditions preconditions = new Preconditions(driver);
        preconditions.registration(user);
        preconditions.logout();


    }

    @After
    public void closeBrowser(){
        mainPage.close();
    }

//    @Test
//    public void logout(){
//        MenuPage menuPage = new MenuPage(driver);
//        menuPage.chooseLogout();
//    }

    @Test
    public void loginPositiveScenario(){
        MenuPage menuPage = new MenuPage(driver);
        menuPage
                .chooseSignIn()
                .fillInLoginData(user)
                .chooseSignInButton();


        Assert.assertTrue("Login process has failed", menuPage.isUserLoggedIn(user) );

    }

    @Test
    public void loginWithoutData(){
        MenuPage menuPage = new MenuPage(driver);

        menuPage
                .chooseSignIn()
                .chooseSignInButton();

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
    }

    @Test
    public void loginWithIncorrectPassword(){
        MenuPage menuPage = new MenuPage(driver);
        menuPage.chooseSignIn().fillInLoginDataWithIncorrectPassword(user).chooseSignInButton();

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue("There is no proper message", signInPage.isLoginFailed());
    }

}
