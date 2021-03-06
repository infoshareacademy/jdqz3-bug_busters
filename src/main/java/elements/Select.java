package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Select {
    private int timeout = 10;
    private WebElement element;
    private WebDriver driver;
    private org.openqa.selenium.support.ui.Select select;

    public Select(WebDriver driver, By by){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable((by)));
        select = new org.openqa.selenium.support.ui.Select(this.element);
    }

    public void selectByText(String text){
        select.selectByVisibleText(text);
    }

    public String read(){
        return this.select.getFirstSelectedOption().getText();
    }
}
