package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverWrapperUtil;

public class AmazonHomePage {

    private final WebDriver driver;

    @FindBy(id = "searchDropdownBox")
    private WebElement amazonDropDown;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonSearch;


    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static AmazonHomePage using(WebDriver driver) {
        return new AmazonHomePage(driver);
    }

    public AmazonHomePage setSearchText(String textSearch) {
        WebDriverWrapperUtil.selectItemFromDropdown(amazonDropDown,"Electronics");
        amazonSearch.sendKeys(textSearch);
        amazonSearch.submit();
        return this;
    }


}
