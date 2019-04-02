package prerequisites;

import dataModels.User;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.MenuPage;

public class Preconditions extends BasePage{

    public Preconditions(WebDriver driver) {
        super(driver);
    }

    public void registration(User user) {
        MenuPage menuPage = new MenuPage(driver);

        menuPage
                .chooseRegister()
                .fillInRegistrationData(user)
                .createAnAccount();
    }

    public void logout() {
        MenuPage menuPage = new MenuPage(driver);

        menuPage.chooseLogout();
    }

}
