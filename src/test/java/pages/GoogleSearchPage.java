package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    private final  WebDriver driver;

    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchText;


    @FindBy(xpath = "//h3[normalize-space()='Amazon.in']")
    private WebElement amazonLink;


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static GoogleSearchPage using(WebDriver driver) {
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage goToGoogle() {
        driver.get("https://www.google.com");
        return this;
    }
    public GoogleSearchPage setSearchText(String textSearch) {
        this.searchText.sendKeys(textSearch);
        searchText.submit();
        return this;
    }

    public  void goToAmazon() {
        this.amazonLink.click();
          }

}
