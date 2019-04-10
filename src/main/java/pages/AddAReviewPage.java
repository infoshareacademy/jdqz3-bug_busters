package pages;

import dataModels.Opinion;
import dataModels.User;
import elements.Button;
import elements.Label;
import elements.TextInput;
import generators.DescriptionGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAReviewPage extends BasePage {

    private static final String REVIEW_CREATED = "You have successfully created a product review";

    private TextInput reviewText;
    private By reviewTextSelector = By.cssSelector("#description");
    private Button starBadButton;
    private By starBadButtonSelector = By.cssSelector("div#rateMe img[title='bad']");
    private Button starPoorButton;
    private By starPoorButtonSelector = By.cssSelector("div#rateMe img[title='poor']");
    private Button starRegularButton;
    private By starRegularButtonSelector = By.cssSelector("div#rateMe img[title='regular']");
    private Button starGoodButton;
    private By starGoodButtonSelector = By.cssSelector("div#rateMe img[title='good']");
    private Button starGorgeousButton;
    private By starGorgeousButtonSelector = By.cssSelector("div#rateMe img[title='gorgeous']");
    private Button submitButton;
    private By submitButtonSelector = By.cssSelector("form#review button.btn");
    private Label alertLabel;
    private By alertLabelSelector = By.xpath("//ul[@class='click_menu_show']/li/a[text()='Register']"); //TODO do zmiany selctor

    public AddAReviewPage(WebDriver driver) {
        super(driver);
        this.reviewText = new TextInput(this.driver, reviewTextSelector);
        this.starBadButton = new Button(this.driver, starBadButtonSelector);
        this.starPoorButton = new Button(this.driver, starPoorButtonSelector);
        this.starRegularButton = new Button(this.driver, starRegularButtonSelector);
        this.starGoodButton = new Button(this.driver, starGoodButtonSelector);
        this.starGorgeousButton = new Button(this.driver, starGorgeousButtonSelector);
        this.submitButton = new Button(this.driver, submitButtonSelector);

    }

    public String getTextFromAlertLabel() {
        this.alertLabel = new Label(this.driver, alertLabelSelector);
        return alertLabel.read();
    }

    private void starsProductRating(Opinion opinion) {
        switch (opinion.getRating()) {
            case bad:
                starBadButton.click();
            case good:
                starGoodButton.click();
            case poor:
                starPoorButton.click();
            case regular:
                starRegularButton.click();
            case gorgeous:
                starGorgeousButton.click();
                break;
        }
    }

    public void typeAReviewText(Opinion opinion) {
        reviewText.type(opinion.getOpinionText());
        starsProductRating(opinion);
    }

    public void submitAReview() {
        submitButton.click();
    }

    public boolean isAReviewAdded(){
        return getTextFromAlertLabel().contains(REVIEW_CREATED);
    }
}

