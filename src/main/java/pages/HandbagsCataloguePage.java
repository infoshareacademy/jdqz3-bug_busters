package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandbagsCataloguePage extends BasePage {

    private Button addToCart;
    private By addToCartSelector = By.cssSelector("div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private Button shoppingCart;
    private By shoppingCartSelector = By.cssSelector("div#miniCartSummary a");
    private Button checkout;
    private By checkoutSelector = By.xpath("//div[contains(@class, 'shop-cart')]//a[text()='Checkout']");
    private Button selectBag;
    private By selectBagSelector = By.xpath("//a[@href='shop/product/chic-vintage-deville.html']");

    public HandbagsCataloguePage(WebDriver driver) {
        super(driver);
    this.addToCart = new Button(this.driver, addToCartSelector);
    this.shoppingCart = new Button(this.driver, shoppingCartSelector);
    this.selectBag = new Button(this.driver, selectBagSelector);
    }

    public void addBagToCart(){
        this.addToCart.click();
    }

    public void proceedToCheckout(){
        this.shoppingCart.safeClick();
        this.checkout = new Button(this.driver, checkoutSelector);
        this.checkout.clickWithJs();
    }

    public BagDetailPage chooseBagToReview(){
        this.selectBag.click();
        return new BagDetailPage(driver);

    }
}