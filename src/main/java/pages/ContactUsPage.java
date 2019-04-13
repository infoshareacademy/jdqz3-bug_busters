

package pages;

import dataModels.User;
import elements.Button;
import elements.Label;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private By contactUsSelektor = By.xpath("//a[contains(text(),'Contact Us')]");
    private Button contactUs;

    private By nameSelektor = By.id("name");
    private TextInput name;

    private By emailSelektor = By.id("email");
    private TextInput email;

    private By subjectSelektor = By.id("subject");
    private TextInput subject;

    private By commentsSelektor = By.id("comment");
    private TextInput comments;

    private By sendSelektor = By.xpath("//a[contains(text(),'submitContact')]");
    private Button send;

    private By captchaSelektor = By.xpath("//a[contains(text(),'recaptcha-anchor')]");
    private Button captcha;

    private By sentSuccessSelector = By.id("store.success");
    private Label sentSuccess;

    public ContactUsPage (WebDriver driver) {
        super(driver);
        this.name = new TextInput(this.driver, nameSelektor);
        this.email = new TextInput(this.driver, emailSelektor);
        this.subject = new TextInput(this.driver, subjectSelektor);
        this.comments = new TextInput(this.driver, commentsSelektor);
    }

    public ContactUsPage fillInContactUsData(User user){

        this.name.type(user.getFirstname());
        this.email.type(user.getEmail());
        this.subject.type("123");
        this.comments.type("abc123");
        return this;

//        generator.generate(length)
    }

    public ContactUsPage clickCaptcha() {
        this.captcha = new Button(this.driver, captchaSelektor);
        this.captcha.click();
        return this;
    }

    public ContactUsPage clickContactUs() {
        this.contactUs = new Button(this.driver, contactUsSelektor);
        this.contactUs.click();
        return this;
    }

    public ContactUsPage clickSendButton() {
        this.send = new Button (this.driver, sendSelektor);
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
