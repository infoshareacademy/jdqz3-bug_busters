package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchModePage;

public class SearchModeTests {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    public void searchMode() {
        SearchModePage searchModePage = new SearchModePage (driver);
        searchModePage
                .fillInData()
                .clickSearchButton();

        Assert.assertEquals("7 item(s) found", searchModePage.getTextFromItemsLabel());
    }
}
