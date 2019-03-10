package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewOrderPage extends BasePage {

    private Button proceedToCheckout;
    private By proceedToCheckoutSelector = By.xpath("//a[text() = 'Proceed to checkout']");
    private Label itemName;
    private By itemNameSelector = By.cssSelector(".nomargin");
    private Label itemPrice;
    private By itemPriceSelector = By.cssSelector("td[data-th = 'Price']");


    public ReviewOrderPage(WebDriver driver){
        super(driver);
        this.proceedToCheckout = new Button(this.driver, proceedToCheckoutSelector);
        this.itemName = new Label(this.driver, itemNameSelector);
        this.itemPrice = new Label(this.driver, itemPriceSelector);
    }

    public void chooseProceedCheckout(){
        proceedToCheckout.click();
    }

    private String getItemFromTable(){
       return itemName.read();
    }

    private String getPriceFromTable(){
        return  itemPrice.read();
    }

//    public boolean isCartContentCorrect() {
//        String actualItem = "Chic vintage DeVille";
//        String actualPrice = "$78.00";
//
//        return actualItem.equals(getItemFromTable()) && actualPrice.equals(getPriceFromTable());
//    }
}
