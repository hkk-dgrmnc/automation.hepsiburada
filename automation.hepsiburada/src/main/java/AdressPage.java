import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AdressPage extends BasePage {

    private final By addAdressLocator = new By.ByCssSelector("span[data-test-class='new-address-link']");
    private final By addNameLocator = new By.ByCssSelector("input[name='contact.firstName']");
    private final By addLastNameLocator = new By.ByCssSelector("input[name='contact.lastName']");
    private final By addNumberLocator = new By.ByCssSelector("input.form-control");

    private final By chooseBox = new By.ByCssSelector("input.fake_input_12C-D");
    private final By isDisLoc = new By.ByCssSelector("input.is_opened_2BXQI");
    private final By chooseAdressLocator = new By.ByCssSelector("div[tabindex='-1']");

    private final By addAdressInformationLocator = new By.ByCssSelector("textarea[name='detail']");
    private final By addAdressNameLocator = new By.ByCssSelector("input[name='name']");
    private final By clickSomethingLocator = new By.ByCssSelector("input[name='setAlsoAsBillingAddress']");
    private final By complateAdressLocators = new By.ByCssSelector("button.button_QwrsX");

    private final By continueLocator = new By.ByCssSelector("button.cxvjoB");


    public AdressPage(WebDriver driver) { super(driver); }


    public void addAdress() throws InterruptedException {

        find(addAdressLocator).click();
        Thread.sleep(1000);
        find(addNameLocator).sendKeys("osman");
        find(addLastNameLocator).sendKeys("hamdi");
        find(addNumberLocator).sendKeys("5066874523");

        getChooseBox().get(0).click();
        while (setIsDisLoc().isEmpty()) {
            getChooseBox().get(0).click();
        }
        getChooseAdress().get(2).click();

        getChooseBox().get(1).click();
        while (setIsDisLoc().isEmpty()) {
            getChooseBox().get(1).click();
        }
        getChooseAdress().get(2).click();

        while (!(getChooseBox().size() == 3)) {
            while (setIsDisLoc().isEmpty()) {
                getChooseBox().get(2).click();
            }
            getChooseAdress().get(2).click();
        }

        find(addAdressInformationLocator).sendKeys("osman sokak 23/4 kat:2 kara apartmanı");
        find(addAdressNameLocator).sendKeys("ev adresi");
        Thread.sleep(1000);
        find(clickSomethingLocator).click();
        Thread.sleep(1000);
        find(complateAdressLocators).click();

    }

    public void continueButton() {

        find(continueLocator).click();

    }


    private List<WebElement> getChooseBox() {
        return findAll(chooseBox);
    }

    private List<WebElement> getChooseAdress() {
        return findAll(chooseAdressLocator);
    }

    private List<WebElement> setIsDisLoc() {
        return findAll(isDisLoc);
    }

}
