public class Steps {

    public static void ClickHamburgerMenu(){
        App.WaitForElement(App.Homepage.HamburgerMenu);
        App.Homepage.HamburgerMenu.click();
    }

    public static void ClickTvElectronicsBtn(){
        App.WaitForElement(App.Homepage.TvElectronicsBtn);
        App.Homepage.TvElectronicsBtn.click();
    }

    public static void ClickTelevisionsBtn(){
        App.WaitForElement(App.Homepage.TelevisionsBtn);
        App.Homepage.TelevisionsBtn.click();
    }

    public static void ClickSamsungBrandBtn(){
        App.WaitForElement(App.Homepage.SamsungBrandBtn);
        App.Homepage.SamsungBrandBtn.click();
    }

    public static void SelectFromSortMenu(String value){
        App.WaitForElement(App.Homepage.SortMenu);
        App.SelectItemFromSelect(App.Homepage.SortMenu).selectByVisibleText(value);

    }

    public static void SimpleClickProduct(int index) throws InterruptedException {
            App.WaitForElement(App.Homepage.SortMenu);
            App.Homepage.Products.get(index).click();
            App.SecondsToWait(2);
            App.SwitchTab(1);

    }


}
