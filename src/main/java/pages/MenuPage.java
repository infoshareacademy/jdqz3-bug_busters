package pages;

import dataModels.User;
import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {

    private By welcomeUserSelector = By.id("customerAccount");
    private Button welcomeUserBtn;
    private Label welcomeUserLabel;
    private By logoutSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Logout']");
    private Button logoutBtn;
    private By myAccountSelector = By.cssSelector("div#customerAccount li[class='click_menu']");
    private Button myAccountMenu;
    private Label myAccountLabel;
    private By registerSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Register']");
    private Button register;
    private By signInSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Sign in']");
    private Button signIn;

    public MenuPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoggedIn() {
        return driver.findElements(welcomeUserSelector).size() != 1;
    }

    public SignInPage chooseSignIn() {
        if (isLoggedIn()) {
            throw new IllegalStateException("You are logged in, SignIn option is not available");
        } else {
            this.myAccountMenu = new Button(this.driver, this.myAccountSelector);
            this.myAccountMenu.click();
            this.signIn = new Button(this.driver, this.signInSelector);
            this.signIn.click();
            return new SignInPage(driver);
        }
    }

    public RegistrationPage chooseRegister() {
        if (isLoggedIn()) {
            throw new IllegalStateException("You are logged in, Register option is not available");
        } else {
            this.myAccountMenu = new Button(this.driver, this.myAccountSelector);
            this.myAccountMenu.click();
            this.register = new Button(this.driver, this.registerSelector);
            this.register.click();
            return new RegistrationPage(driver);
        }
    }

    public String getTextFromWelcomeMenu() {
        this.welcomeUserLabel = new Label(this.driver, this.welcomeUserSelector);
        return welcomeUserLabel.read();
    }

    public String getTextFromAccountMenu() {
        this.myAccountLabel = new Label(this.driver, this.myAccountSelector);
        return myAccountLabel.read();
    }


    public MainPage chooseLogout() {

            this.welcomeUserBtn = new Button(this.driver, this.welcomeUserSelector);
            this.welcomeUserBtn.click();
            this.logoutBtn = new Button(this.driver, this.logoutSelector);
            this.logoutBtn.click();
            return new MainPage(driver);

//        throw new IllegalStateException("You are not logged in, Logout option is not available");
    }

    public boolean isUserLoggedIn(User user) {
        return getTextFromWelcomeMenu().contains(user.getFirstname());
    }

    public boolean isUserLoggedOut() { return getTextFromAccountMenu().contains("My Account"); }

}
