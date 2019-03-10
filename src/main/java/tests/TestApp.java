package tests;

import categories.CartTest;
import categories.PurchaseTests;
import dataModels.RegisteredUser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class TestApp {

    private WebDriver driver;
    private MainPage mainPage;
    private RegisteredUser registeredUser;

    @Before
    public void startBrowser(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.registeredUser = new RegisteredUser(true);
    }

    @After
    public void closeBrowser(){
        mainPage.close();
    }

    @Category(PurchaseTests.class)
    @Test
    public void purchase(){
        mainPage.ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage.addBagToCart();
        handbagsPage.proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage.chooseProceedCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillInCompleteAddress(registeredUser);
        checkoutPage.chooseSubmitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.getConfirmationText();
        Assert.assertTrue("Order not completed", orderConfirmationPage.getConfirmationText().equals("Order completed"));
    }
//    @Category(CartTest.class)
//    @Test
//    public void addToCart(){
//        mainPage.ChooseHandbagsCategory();
//        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
//        handbagsPage.addBagToCart();
//        handbagsPage.proceedToCheckout();
//
//        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
//
//        Assert.assertTrue("Cart content is not correct", reviewOrderPage.isCartContentCorrect());
//    }
}