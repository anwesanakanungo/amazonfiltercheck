package testcase;

import browser.DriverManager;
import browser.DriverManagerFactory;
import browser.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestGet5StarRating {
    DriverManager driverManager;
    WebDriver driver;

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
        Thread.sleep(20000);

      List<WebElement> star =driver.findElements(By.xpath("//span[contains(text(),'5.0 out of 5 stars')]"));
        System.out.println("No of 5Star rating in the First page " +star.size());
        driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
        List<WebElement> starpage2 =driver.findElements(By.xpath("//span[contains(text(),'5.0 out of 5 stars')]"));
        System.out.println("No of 5Star rating in the First page " +starpage2.size());

    }

}