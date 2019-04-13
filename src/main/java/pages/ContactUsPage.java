

package pages;

import dataModels.User;
import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {



    private By nameSelector = By.id("name");
    private TextInput name;

    private By emailSelector = By.id("email");
    private TextInput email;

    private By subjectSelector = By.id("subject");
    private TextInput subject;

    private By commentsSelector = By.id("comment");
    private TextInput comments;

    private By sendSelector = By.xpath("//a[contains(text(),'submitContact')]");
    private Button send;

    private By captchaSelector = By.id("recaptcha-anchor");
    private Button captcha;

    private By sentSuccessSelector = By.id("store.success");
    private Label sentSuccess;

    public ContactUsPage (WebDriver driver) {
        super(driver);
        this.name = new TextInput(this.driver, nameSelector);
        this.email = new TextInput(this.driver, emailSelector);
        this.subject = new TextInput(this.driver, subjectSelector);
        this.comments = new TextInput(this.driver, commentsSelector);
    }

    public ContactUsPage fillInContactUsData(User user){

        this.name.type(user.getFirstname());
        this.email.type(user.getEmail());
        this.subject.type(user.getCompanyName());
        this.comments.type(user.getCompanyName()+ user.getPhone());
        return this;
    }

    public ContactUsPage clickCaptcha() {
        this.captcha = new Button(this.driver, captchaSelector);
        this.captcha.click();
        return this;
    }

    public ContactUsPage clickSendButton() {
        this.send = new Button (this.driver, sendSelector);
        this.send.click();
        return this;
    }

    public String getTextFromContactUsLabel() {
        this.sentSuccess = new Label(this.driver, sentSuccessSelector);
        return this.sentSuccess.read();
    }

    public void close() {
        this.driver.quit();
    }
}
