import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class Amazon_Tests extends Hooks {

    @Test
    public  void Tes01() throws InterruptedException {
        Steps.ClickHamburgerMenu();
        Steps.ClickTvElectronicsBtn();
        Steps.ClickTelevisionsBtn();
        Steps.ClickSamsungBrandBtn();
        Steps.SelectFromSortMenu("Price: High to Low");
        Steps.SimpleClickProduct(1);

        App.ScrollToElement(App.Productpage.AboutItemSect);
        Assert.assertTrue(App.ElementIsPresent(App.Productpage.AboutItemSect),"Section is present");
    }
}
