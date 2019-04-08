package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewOrderPage extends BasePage {

    private Button proceedToCheckout;
    private By proceedToCheckoutSelector = By.xpath("//a[text() = 'Proceed to checkout']");

    private Label addedItemNameLabel;
    private By addedItemNameSelector = By.cssSelector("td[data-th='Item'] span");
    private Label addedItemQuantityLabel;
    private By addedItemQuantitySelector = By.cssSelector("td[data-th='Quantity'] input.quantity");
    private Label addedItemPriceLabel;
    private By addedItemPriceSelector = By.cssSelector("td[data-th='Price']");
    private Label addedItemTotalLabel;
    private By addedItemTotalSelector = By.cssSelector("td[data-th='Total']");

    private Label subtotalShoppingCart;
    private By subtotalShoppingCartSelector = By.xpath("//tr[1]//td[1]//span[contains(@class, 'amount')]");
    private Label totalShoppingCart;
    private By totalShoppingCartSelector = By.xpath("//tr[2]//td[1]//span[contains(@class, 'amount')]");

    private Button recalculateShoppingcart;
    private By recalculateShoppingcartSelector = By.xpath("//a[contains(text(),'Recalculate')]");

    private Button removeFromCart;
    private By removeFromCartSelector = By.xpath("//i[@class='fa fa-times']");


    public ReviewOrderPage(WebDriver driver) {
        super(driver);
    }

    public void chooseProceedCheckout() {
        this.proceedToCheckout = new Button(this.driver, proceedToCheckoutSelector);
        proceedToCheckout.click();
    }

    public ReviewOrderPage changeItemQuantity(String string) {
        new Label(this.driver, addedItemNameSelector).inputValue();
        return this;
    }

    public ReviewOrderPage recalulateShoppingCart() {
        this.recalculateShoppingcart = new Button(this.driver, recalculateShoppingcartSelector);
        this.recalculateShoppingcart.clickWithJs();
        return this;
    }

    public void removeItemFromCart() {
        this.removeFromCart = new Button(this.driver, removeFromCartSelector);
        this.removeFromCart.clickWithJs();
    }

    private String isTotalCorrect() {
        this.totalShoppingCart = new Label(this.driver, totalShoppingCartSelector);
        return totalShoppingCart.read();
    }

    private String isSubotalCorrect() {
        this.subtotalShoppingCart = new Label(this.driver, subtotalShoppingCartSelector);
        return subtotalShoppingCart.read();
    }

    public boolean isTotalAndSubtotalCorrect() {
        double total = Double.parseDouble(isTotalCorrect().substring(1));
        double subtotal = Double.parseDouble(isSubotalCorrect().substring(1));
        double subtotalPriceOfCart = Double.parseDouble(new Label(this.driver, addedItemPriceSelector).read().substring(1));
        double totalPriceOfCart = Double.parseDouble(new Label(this.driver, addedItemTotalSelector).read().substring(1));

        return total == totalPriceOfCart && subtotal == subtotalPriceOfCart;
    }

    public boolean isCartContentCorrect() {
        String actualName = new Label(this.driver, addedItemNameSelector).read();
        int actualQuantity = Integer.parseInt(new Label(this.driver, addedItemQuantitySelector).getValue());
        double actualPrice = Double.parseDouble(new Label(this.driver, addedItemPriceSelector).read().substring(1));
        double actualTotal = Double.parseDouble(new Label(this.driver, addedItemTotalSelector).read().substring(1));

        String expectedName = "Chic vintage DeVille";
        int expectedQuantity = 1;
        double expectedPrice = 78.00;
        double expectedTotal = expectedPrice * expectedQuantity;

        return actualName.equals(expectedName) && actualQuantity == expectedQuantity
                && actualPrice == expectedPrice && actualTotal == expectedTotal;
    }

}

