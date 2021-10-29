import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditCardPage extends BasePage {

    private final By paymentMethodLocator = new By.ByCssSelector("div.sardesPaymentPage-index-credit_card_title");
    private final By cardNoLocator = new By.ByCssSelector("input[name='cardNumber']");
    private final By cardNameLocator = new By.ByCssSelector("input[name='holderName']");
    private final By expirationDateLocator = new By.ByCssSelector("input[name='expireDate']");
    private final By cvvLocator = new By.ByCssSelector("input[name='cvv']");
    private final By goHomePageFromCard = new By.ByCssSelector("div.header_link");


    public CreditCardPage(WebDriver driver) {
        super(driver);
    }


    public void choosePaymentMethod() {

        find(paymentMethodLocator).click();

    }

    public void complatePaymentInformation() throws InterruptedException {

        find(cardNoLocator).sendKeys("5555555555555555");
        find(cardNameLocator).sendKeys("osman hamdi");
        find(expirationDateLocator).sendKeys("1202");
        find(cvvLocator).sendKeys("286");
        Thread.sleep(1000);
        find(goHomePageFromCard).click();

    }


}
