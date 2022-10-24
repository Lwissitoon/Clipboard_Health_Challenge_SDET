package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "nav-hamburger-menu")
    public WebElement HamburgerMenu;
    @FindBy(xpath = "//a[.='TV, Appliances, Electronics']")
    public WebElement TvElectronicsBtn;

    @FindBy(xpath = "//a[.='Televisions']")
    public WebElement TelevisionsBtn;

    @FindBy(xpath = "//span[.='Brands']/../..//span[.='Samsung']")
    public WebElement SamsungBrandBtn;

    @FindBy(id = "s-result-sort-select")
    public WebElement SortMenu;

    @FindBy(xpath = "//div[contains(@class, 's-product-image-container')]")
    public List<WebElement> Products;
}
