package testcase;

import browser.DriverManager;
import browser.DriverManagerFactory;
import browser.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.DellComputerPage;
import pages.GoogleSearchPage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class amazonFiveStarRatingCount {
    DriverManager driverManager;
    WebDriver driver;
    private GoogleSearchPage googlesSearchPage ;
    private AmazonHomePage amazonHomePage ;
    private DellComputerPage dellComputerPage ;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void fiveStarRatingCountFirstPage() throws InterruptedException {
        googlesSearchPage.using(driver)
                .goToGoogle()
                .setSearchText("amazon")
                .goToAmazon();
        amazonHomePage.using(driver)
                .setSearchText("dell computers");
        DellComputerPage.using(driver)
                .setSearchText("20000" ,"30000");

        List<WebElement> allfivestarRatingFirstPage = DellComputerPage.allsStarRatingProduct;
       int numberofStarRating= allfivestarRatingFirstPage.size();
        assertThat(numberofStarRating).isGreaterThan(0).isLessThan(5);

        }
    @Test
    public void fiveStarRatingCountSecondPage() throws InterruptedException {
        googlesSearchPage.using(driver)
                .goToGoogle()
                .setSearchText("amazon")
                .goToAmazon();
        amazonHomePage.using(driver)
                .setSearchText("dell computers");
        DellComputerPage.using(driver)
                .setSearchText("20000" ,"30000")
                .goToSecondSearchPage();


        List<WebElement> allfivestarRatingFirstPage = DellComputerPage.allsStarRatingProduct;
        int numberofStarRating= allfivestarRatingFirstPage.size();
        assertThat(numberofStarRating).isGreaterThan(0).isEqualTo(1);

    }
    }

