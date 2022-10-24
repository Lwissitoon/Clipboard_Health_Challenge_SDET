import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

public class App extends Helpers {
    public static WebDriver driver;
    private  static  WebDriver parentDriver;
    private  static WebDriverListener listener;
    private static ChromeOptions options;
    public static void Initdriver(String browser,int Timeout) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, MalformedURLException {

        options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("sessionTimeout", "15m");
            put("enableVideo", true);
        }});
        options.setCapability("enableVNC", true);


        if (browser.equalsIgnoreCase("Local")) {

            parentDriver = WebDriverManager.chromedriver().create();
        }
        else if (browser.equalsIgnoreCase("Remote")) {
            parentDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
        }

        listener = new Listeners();

        driver = new EventFiringDecorator(listener).decorate(parentDriver);
        driver.manage().window().maximize();
        InitCustomActions(Timeout,driver);
        InitObjects();

    }

    public static void InitObjects() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Field[] allFields = PageObjectCore.class.getDeclaredFields();

        Class<?>[] type = {WebDriver.class};
        for (Field field:allFields) {
            Class<?> cl = Class.forName(field.getType().toString().substring(6));
            Constructor<?> cons = cl.getConstructor(type);
            Object[] obj = { driver};
            field.set("driver", cons.newInstance(obj));
        }

    }


    public  static  void CloseDriver(){
        driver.quit();
    }
}
