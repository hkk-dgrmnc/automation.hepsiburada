import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {


    private final By userNameLocator = By.id("txtUserName");
    private final By passwordLocator = By.id("txtPassword");
    private final By clickLoginPageLoginButon = By.id("btnLogin");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void addLoginInformation(String gmail, String password) throws InterruptedException {


        if (passwordIsEmpty().isEmpty()) {
            find(userNameLocator).sendKeys(gmail);
            clickLoginPageLogin();
            Thread.sleep(2000);
            find(passwordLocator).sendKeys(password);
            clickLoginPageLogin();
        } else {

            find(userNameLocator).sendKeys(gmail);
            find(passwordLocator).sendKeys(password);
            Thread.sleep(2000);

        }


    }

    public void clickLoginPageLogin() {

        find(clickLoginPageLoginButon).click();

    }


    private List<WebElement> passwordIsEmpty() {
        return findAll(passwordLocator);
    }

}
