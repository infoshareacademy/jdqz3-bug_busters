package tests;

import dataModels.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void purchaseOrderForNonRegisteredUserCompleted() {
        mainPage.ChooseHandbagsCategory();
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
    public void isMoneyOrderTheSameAsOnTheMainPage() {
        mainPage
                .ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .chooseProceedCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        String moneyOrderAddress = checkoutPage
                .getMoneyOrderAddress().replaceAll("\n", ",");

        assertThat(moneyOrderAddress)
                .contains("Vintage Bags")
                .contains("350 Du Languedoc")
                .contains("Bourcherville")
                .contains("Canada")
                .contains("QC")
                .contains("J4B 0A4");
    }

    @Test
    public void areCartDetailsCorrect() {
        mainPage
                .ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .isCartContentCorrect();
    }

    @Test
    public void isTotalAndSubtotalCorrect() {
        mainPage
                .ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .isTotalAndSubtotalCorrect();
    }

    @Test
    public void isAppReloadedToTheMainPageAfterRemovingItemFromTheCart() {
        mainPage
                .ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsPage = new HandbagsCataloguePage(driver);
        handbagsPage
                .addBagToCart()
                .proceedToCheckout();

        ReviewOrderPage reviewOrderPage = new ReviewOrderPage(driver);
        reviewOrderPage
                .removeItemFromCart();
        assertNotEquals("Url is the same", "http://demo.shopizer.com:8080/shop/", this.driver.getCurrentUrl());
    }

    @Test //TODO fix problem with sending of the quantity
    public void recalculateItemInCart() {
        mainPage
                .ChooseHandbagsCategory();
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
