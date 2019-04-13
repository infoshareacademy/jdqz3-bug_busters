package pages;

import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchModePage extends BasePage {

    private By searchFieldSelector = By.id("searchField");
    private TextInput searchField;

    private By searchModeSelector = By.xpath("//a[contains(text(),'searchMode')]");
    private Button searchMode;

    private By numberOfItemsSelector = By.id("products-qty");
    private Label numberOfItems;

    public SearchModePage(WebDriver driver) {
        super(driver);
        this.searchField = new TextInput(this.driver, searchFieldSelector);
    }

    public SearchModePage fillInData() {
        this.searchField.type("Vintage courier bag");
        return this;
    }

    public SearchModePage clickSearchButton() {
        this.searchMode = new Button(this.driver, searchModeSelector);
        this.searchMode.click();
        return this;
    }

    public void close() {
        this.driver.quit();
    }

    public String getTextFromItemsLabel() {
        this.numberOfItems = new Label (this.driver, numberOfItemsSelector);
        return this.numberOfItems.read();
    }
}
