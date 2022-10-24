import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Hooks {

    @BeforeTest
    @Parameters({"browser"})
    public  void  Setup(String browser) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, MalformedURLException {
        App.Initdriver(browser,10);
        App.driver.navigate().to("https://www.amazon.in/");

    }

    @AfterTest
    public void Cleanup(){
       App.CloseDriver();
    }
}
