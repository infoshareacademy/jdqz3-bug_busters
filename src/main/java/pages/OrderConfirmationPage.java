package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage {

    private By confirmationTextSelect = By.cssSelector("#main-content h1");
    private Label confirmationText;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.confirmationText = new Label(this.driver, confirmationTextSelect);
    }

    public String getConfirmationText() {
        return this.confirmationText.read();
    }
}
