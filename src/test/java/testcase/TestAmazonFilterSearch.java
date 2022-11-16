package testcase;

import browser.DriverManager;
import browser.DriverManagerFactory;
import browser.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.DellComputerPage;
import pages.GoogleSearchPage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAmazonFilterSearch {
    private static Logger logger = LoggerFactory.getLogger(TestAmazonFilterSearch.class);
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
    public void filterPriceTest() throws InterruptedException {
        googlesSearchPage.using(driver)
                .goToGoogle()
                .setSearchText("amazon")
                .goToAmazon();
        amazonHomePage.using(driver)
                .setSearchText("dell computers");
        DellComputerPage.using(driver)
                .setSearchText("20000" ,"30000")
                .goToSecondSearchPage();

        List<WebElement> allProductPrice = DellComputerPage.getAllProductPrice();
        for (WebElement product : allProductPrice) {
            System.out.println(product.getText());
            logger.info("Verifing product count");
           Integer Actaul = Integer.parseInt(product.getText());
   // int  Actaul= Integer.parseInt(String.valueOf(product.getText()));
            if (Actaul < 30000){
                System.out.println("Filter is working fine");
            }
else  {
                System.out.println("Filter is not working fine");
            }

        }
    }
    }
