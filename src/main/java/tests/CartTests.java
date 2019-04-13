package tests;

import categories.AdditionalTests;
import categories.MainTests;
import dataModels.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertNotEquals;

public class CartTests {

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
    @Category(MainTests.class)
    public void purchaseOrderForNonRegisteredUserCompleted() {
        mainPage.chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage.
                chooseProceedCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage
                .fillInCompleteAddress(user)
                .chooseSubmitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage
                .getConfirmationText();

        Assert.assertEquals("Order not completed", "Order completed", orderConfirmationPage.getConfirmationText());
    }

    @Test
    @Category(AdditionalTests.class)
    public void isMoneyOrderTheSameAsOnTheMainPage() {
        mainPage
                .chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .chooseProceedCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage
                .getMoneyOrderAddress();
        checkoutPage.
                isMoneyOrderAddressTheSame();
    }

    @Test
    @Category(MainTests.class)
    public void areCartDetailsCorrect() {
        mainPage
                .chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .isCartContentCorrect();
    }

    @Test
    @Category(AdditionalTests.class)
    public void isTotalAndSubtotalCorrect() {
        mainPage
                .chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .isTotalAndSubtotalCorrect();
    }

    @Test
    @Category(AdditionalTests.class)
    public void isAppReloadedToTheMainPageAfterRemovingItemFromTheCart() {
        mainPage
                .chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .removeItemFromCart();
        assertNotEquals("Url is the same", "http://demo.shopizer.com:8080/shop/", this.driver.getCurrentUrl());
    }

    @Test
    @Category(AdditionalTests.class)
    public void recalculateItemInCart() {
        mainPage
                .chooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .changeItemQuantity("2")
                .recalulateShoppingCart()
                .isTotalAndSubtotalCorrect();
    }
}
