import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsPage extends BasePage {


    private final By productDetailPagePriceLocator = By.id("offering-price");
    private final By addProductInBasketLocator = By.id("addToCart");
    private final By goBasketButonLocator = By.id("shoppingCart");
    private final By goBasketButonFromAlertLocator = new By.ByCssSelector("div.checkoutui-SalesFrontCash-m5Re7>button");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void saveProductPriceInProductDetailPage() {

        ScenarioDataStore.put("price-InProductDetailPage", find(productDetailPagePriceLocator).getText());

    }

    public void addProductInBasket() throws InterruptedException {

        find(addProductInBasketLocator).click();
        Thread.sleep(4000);

    }

    public void goBasketFromProductDetailPage() {

        if (getGoBasketButonFromAlert().get(0).isDisplayed()) {
            getGoBasketButonFromAlert().get(0).click();
        } else {
            find(goBasketButonLocator).click();
        }

    }


    private List<WebElement> getGoBasketButonFromAlert() {
        return findAll(goBasketButonFromAlertLocator);
    }


}
