package testcase;

import browser.DriverManager;
import browser.DriverManagerFactory;
import browser.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestAmazonSearch {
        DriverManager driverManager;
        WebDriver driver;

        @BeforeTest
        public void beforeTest(String Browser) {
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
        public void launchGoogleTest() throws InterruptedException {
            driver.get("https://www.google.com");
            WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
            search.sendKeys("amazon");
            search.submit();
            driver.findElement(By.xpath("//h3[normalize-space()='Amazon.in']")).click();
            Thread.sleep(20000);
            Select item = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
            item.selectByVisibleText("Electronics");
            Thread.sleep(10000);
            WebElement search2 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            search2.sendKeys("dell computers");
            search2.submit();
            Thread.sleep(20000);
            WebElement searchfilterlow = driver.findElement(By.xpath("//input[@id='low-price']"));
            searchfilterlow.sendKeys("20000");
            WebElement searchfilterhigh = driver.findElement(By.xpath("//input[@id='high-price']"));
            searchfilterhigh.sendKeys("30000");
            driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
            List<WebElement> allProduct = driver.findElements(By.className("a-price-whole"));
            for (WebElement product : allProduct) {

                System.out.println(product.getText());

            }
            System.out.println("*********************");
            driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
            List<WebElement> allProduct2 = driver.findElements(By.className("a-price-whole"));
            for (WebElement product2 : allProduct2) {

                System.out.println(product2.getText());
            }


        }

    }

