import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final By loginButonLocator = By.id("login");
    private final By loginTextlocator = new By.ByCssSelector("a[title='Hesabım']");
    private final By getLoginButonLocator = new By.ByCssSelector("span[title='Giriş Yap']");
    private final By goBasketButonLocator = By.id("shoppingCart");
    private final By categoryLocator = new By.ByCssSelector("span.sf-MenuItems-5_2RN");
    private final By subcategoryLocator = new By.ByCssSelector("div.sf-ChildMenuItems-3m2LI");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickHomePageLogin() throws InterruptedException {

        find(getLoginButonLocator).click();
        Thread.sleep(3000);
        find(loginButonLocator).click();


    }

    public boolean isLogin() {


        return !(findAll(loginTextlocator).isEmpty());


    }

    public void goBasket() {

        find(goBasketButonLocator).click();

    }

    public void chooseCategory(int categoryNumber) {

        getAllCategories().get(categoryNumber).click();

    }

    public void chooseSubcategory(int subcategoryNumber) {

        getAllSubcategories().get(subcategoryNumber).click();

    }

    private List<WebElement> getAllCategories() {
        return findAll(categoryLocator);
    }

    private List<WebElement> getAllSubcategories() {
        return findAll(subcategoryLocator);
    }

}

