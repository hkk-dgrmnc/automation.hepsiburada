import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class UserInformation extends BasePage {


    private final By myAdressLocator = new By.ByCssSelector("a.customerAccount-SubItem-EXVOv");
    private final By deleteMyAdressLocator = new By.ByCssSelector("a[data-bind='click: openDelete']");
    private final By acceptDeleteLocator = new By.ByCssSelector("div.delete-action-buttons>a.btn-md");

    public UserInformation(WebDriver driver) {
        super(driver);
    }


    public void chooseMyAdressAndDeleteMyAdress() throws InterruptedException {

        allUserInformation().get(5).click();
        Thread.sleep(2000);
        find(deleteMyAdressLocator).click();
        Thread.sleep(1000);
        find(acceptDeleteLocator).click();

    }


    private List<WebElement> allUserInformation() {
        return findAll(myAdressLocator);
    }

}
