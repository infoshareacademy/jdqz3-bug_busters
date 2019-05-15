package tests;

import addins.Snapshot;
import dataModels.Opinion;
import dataModels.RatingValue;
import dataModels.User;
import generators.DescriptionGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import prerequisites.Preconditions;

public class AddAReviewTests {

    private WebDriver driver;
    private MainPage mainPage;
    private User user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        this.user = new User(false);
        Preconditions preconditions = new Preconditions(driver);
        preconditions.registration(user);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    public void addAReview() throws Exception {
        try {
            MenuPage menuPage = new MenuPage(driver);
            MainPage mainPage = menuPage.chooseLogoBtn();
            HandbagsCataloguePage handbagsCataloguePage = mainPage.chooseHandbagsCategory();
            BagDetailPage bagDetailPage = handbagsCataloguePage.chooseBagToReview();
            AddAReviewPage addAReviewPage = bagDetailPage.chooseWriteAReviewBtn();
            addAReviewPage.typeAReviewText(new Opinion(this.user, RatingValue.good, DescriptionGenerator.generateRandomDescription()));
            addAReviewPage.submitAReview();

            Assert.assertTrue("A review has not been added", addAReviewPage.isAReviewAdded());
        } finally {
            Snapshot snapshot = new Snapshot(driver, "src/main/Screenshots");
            String name = new Object() {}.getClass().getEnclosingMethod().getName();
            snapshot.takeSnapshot(name);
        }
    }
}
