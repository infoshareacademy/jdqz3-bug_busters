package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By handbagsSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBagsCategoryTab;


    public MainPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.handBagsCategoryTab = new Button(this.driver, this.handbagsSelector);
    }


    public HandbagsCataloguePage chooseHandbagsCategory(){
        this.handBagsCategoryTab.click();
        return new HandbagsCataloguePage(driver);
    }


}
