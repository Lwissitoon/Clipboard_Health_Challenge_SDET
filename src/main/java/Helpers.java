import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Helpers extends PageObjectCore {
    static WebDriverWait wait;
    static JavascriptExecutor js ;

    static Actions actions;

    static Select selector;

    public static void InitCustomActions(int TimeOut, WebDriver driver){

        wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
        wait.ignoring(NoSuchElementException.class);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);

    }

    public static void WaitForElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void SecondsToWait(int time) throws InterruptedException {

       Thread.sleep(time*1000);
    }

    public static void WaitForElementToHide(WebElement element){

        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public  static  void ScrollToBotton()
    {

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public  static  void ScrollToElement(WebElement element) {
        WaitForElement(element);
        actions.moveToElement(element).perform();
    }


    public  static  boolean ElementIsPresent(WebElement element){

        try{
            return element.isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public  static  void  MoveMouseOverElement(WebElement element){

        actions.moveToElement(element).perform();
    }

    public  static  boolean SearchElementValueList(List<WebElement> elements, String text){
        boolean exist=false;
        for (WebElement element:elements) {

            if (element.getText().toLowerCase().trim().contains(text.toLowerCase().trim())){
                exist=true;

            }
            else {
                exist=false;
                break;
            }
        }
        return  exist;
    }

    public  static  int GetIndexElementList(List<WebElement> elements, String text){
        int i;
        for (i=0;i<=elements.size();i++ ){

            if(elements.get(i).getText().toLowerCase().trim().contains(text.toLowerCase().trim())){
                return i;

            }
        }

        return i;
    }

    public  static  Select  SelectItemFromSelect(WebElement element){

         selector = new Select(element);

        return selector;
    }

    public  static  void SwitchTab(int index){
        ArrayList<String> tabs = new ArrayList<String>(App.driver.getWindowHandles());
        //switch to new tab
        App.driver.switchTo().window(tabs.get(index));
    }
}
