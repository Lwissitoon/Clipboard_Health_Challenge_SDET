package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "feature-bullets")
    public WebElement AboutItemSect;

}
