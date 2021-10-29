import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class ProductsPage extends BasePage {

    private final By brandsLocator = new By.ByCssSelector("input[name='markalar']");
    private final By minimumPriceLocator = new By.ByCssSelector("input[placeholder='En az']");
    private final By maximumPriceLocator = new By.ByCssSelector("input[placeholder='En çok']");
    private final By searchProductsLocator = new By.ByCssSelector("div.content-rangeInputRoot>button");
    private final By searchAllSpecificProductLocator = new By.ByCssSelector("li.productListContainer-item");
    private final By searchAllSpecificProductsPriceLocator = new By.ByCssSelector("div[data-test-id='price-current-price']");
    private final By searchAllSpecificProductsNameLocator = new By.ByCssSelector("h3[data-test-id='product-card-name']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseBrand(int brandNumber) {

        getAllBrands().get(brandNumber).click();

    }


    public void priceRange(String min_number, String max_number) {

        find(minimumPriceLocator).sendKeys(min_number);
        find(maximumPriceLocator).sendKeys(max_number);

    }

    public void searchProducts() {

        find(searchProductsLocator).click();

    }

    public void selectOneProduct(int specificProductNumber) {

        getAllSpecificProducts().get(specificProductNumber).click();

    }


    public void selectOneProductPrice(int specificProductPriceNumber) throws IOException {

        addInformationToFile("Ürünün markası ve ismi : " + getAllSpecificProductsPrice().get(specificProductPriceNumber).getText());
        ScenarioDataStore.put("price-InProductPage", getAllSpecificProductsPrice().get(specificProductPriceNumber).getText());
    }


    public void selectOneProductName(int specificProductNameNumber) throws IOException {

        addInformationToFile("Seçilen ürünün fiyatı : " + getAllSpecificProductsName().get(specificProductNameNumber).getText());

    }


    private List<WebElement> getAllSpecificProducts() {
        return findAll(searchAllSpecificProductLocator);
    }

    private List<WebElement> getAllBrands() {
        return findAll(brandsLocator);
    }

    private List<WebElement> getAllSpecificProductsPrice() {
        return findAll(searchAllSpecificProductsPriceLocator);
    }

    private List<WebElement> getAllSpecificProductsName() {
        return findAll(searchAllSpecificProductsNameLocator);
    }


}