package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By handbagsSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBagsCategoryTab;
    private By myAccountSelector = By.xpath("//a[text()='My Account']");
    private Button myAccountMenu;
    private By registerSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Register']");
    private Button register;
    private By signInSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Register']");
    private Button signIn;

    public MainPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.handBagsCategoryTab = new Button(this.driver, this.handbagsSelector);
        this.myAccountMenu = new Button(this.driver, this.myAccountSelector);
        this.register = new Button(this.driver, this.registerSelector);
        this.signIn = new Button(this.driver, this.signInSelector);
    }

    public void ChooseHandbagsCategory(){
        this.handBagsCategoryTab.click();
    }

    public void ChooseMyAccountMenu() { this.myAccountMenu.click(); }

    public void ChooseSignIn() { this.signIn.click(); }

    public void ChooseRegister() { this.register.click(); }

}
