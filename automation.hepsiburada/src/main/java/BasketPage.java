import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


public class BasketPage extends BasePage {

    private final By basketBeginingText = new By.ByCssSelector("div.content_Z9h8v>h1");
    private final By goHomePageFromBasketLocator = new By.ByCssSelector("a.sf-Header-26esO");
    private By increaseTheProductsOfNumberLocator = new By.ByCssSelector("a.product_increase_3SpEx");
    private final By OtherIncreaseTheProductsOfNumberLocator = new By.ByCssSelector("button[type='button']");
    private final By informationThereIsNoEnoughProductLocator = new By.ByCssSelector("div.message_content_37ljR");
    private final By productsTotalPriceLocator = new By.ByCssSelector("div.price_1D8UZ");
    private final By productsTotalCargoPrice = new By.ByCssSelector("span.shipping-Basket-customPriceBasketText");
    private final By completeTheTransactionLocator = By.id("continue_step_btn");
    private final By deleteProdutsLocator = new By.ByCssSelector("a[aria-label='Ürünü Kaldır']");
    private final By additionalDelete = new By.ByCssSelector("button.iDSyON");
    private final By firstStepUserConnctionLocator = new By.ByCssSelector("span.sf-Account-2tUrX");
    private final By userConnectionLocator = new By.ByCssSelector("a.sf-Account-XL2c6");


    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public String controlBasketPrice() {

        return find(basketBeginingText).getText();

    }


    public void goHomePageFromBasket() {

        find(goHomePageFromBasketLocator).click();

    }

    public void increaseTheProductsOfNumber(int total) throws InterruptedException {

        for (int x = 1; x <= total; x++) {
            increaseTheProductsOfNumberLocator = new By.ByCssSelector("a.product_increase_3SpEx");
            increaseTheProductsOfNumberSpecial();
            Thread.sleep(3000);
            if (find(informationThereIsNoEnoughProductLocator).isDisplayed()) {
                getOtherIncreaseButton().get(0).click();
            }
            Thread.sleep(3000);
        }
    }


    public void writeTextAllProductsPrice() throws IOException, InterruptedException {

        addInformationToFile("Toplam tutar : " + find(productsTotalPriceLocator).getText());
        Thread.sleep(1000);
        addInformationToFile("Kargo tutarı : " + find(productsTotalCargoPrice).getText());
        Thread.sleep(1000);
        find(completeTheTransactionLocator).click();
    }


    public void deleteAllProducts() throws InterruptedException {

        int deleteSize = getDeleteAll().size();

        for (int i = 0; i < deleteSize; i++) {

            getDeleteAll().get(0).click();
            Thread.sleep(2000);
            if (!(findAll(additionalDelete).isEmpty())) {
                find(additionalDelete).click();
            }
            Thread.sleep(2000);

        }
    }

    public void goUserInformation() throws InterruptedException {

        find(firstStepUserConnctionLocator).click();
        Thread.sleep(100);
        find(userConnectionLocator).click();
        Thread.sleep(2500);

    }


    private void increaseTheProductsOfNumberSpecial() {
        getAllPlus().get(0).click();
    }

    private List<WebElement> getOtherIncreaseButton() {
        return findAll(OtherIncreaseTheProductsOfNumberLocator);
    }

    private List<WebElement> getAllPlus() {
        return findAll(increaseTheProductsOfNumberLocator);
    }

    private List<WebElement> getDeleteAll() {
        return findAll(deleteProdutsLocator);
    }


}
