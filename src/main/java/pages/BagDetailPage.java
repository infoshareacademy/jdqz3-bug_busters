package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BagDetailPage extends BasePage {

    private Button writeAReview;
    private By writeAReviewSelector = By.xpath("//a[text()='Write a review']");


    public BagDetailPage(WebDriver driver) {
        super(driver);
        this.writeAReview = new Button(this.driver, writeAReviewSelector);
    }

    public AddAReviewPage chooseWriteAReviewBtn(){
        writeAReview.click();
        return new AddAReviewPage(driver);
    }
}
