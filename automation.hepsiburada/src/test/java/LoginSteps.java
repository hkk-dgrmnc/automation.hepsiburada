import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;



public class LoginSteps extends BaseTest {




    public HomePage homePage ;
    public LoginPage loginPage ;
    public BasketPage basketPage ;

    @BeforeStep
    public void getAlls(){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Step("Giriş sayfası giriş yap butonuna tıklanır.")
    public void clickHomeLoginButon() throws InterruptedException {

     homePage.clickHomePageLogin();

    }


    @Step("Username <gmail> and password <password> girilir .")
    public void addUsernameAndPassword(String gmail , String password) throws InterruptedException {

    loginPage.addLoginInformation(gmail,password);

    }

    @Step("Login sayfası giriş yap butonuna tıklanır.")
    public void clickLogin()  {

    loginPage.clickLoginPageLogin();

    }


    @Step("Login kontrolü yapılır Eğer login başarılı olmuşsa sepet tutar kontrolü yapılır.")
    public void loginControl() throws InterruptedException {

    Assertions.assertTrue(homePage.isLogin(), "Not successful login");

    boolean x = homePage.isLogin();

    if ( x )   {

       homePage.goBasket();
       Thread.sleep(2000);
       String basketBeginningPrice = basketPage.controlBasketPrice();
       Assertions.assertEquals(basketBeginningPrice , "Sepetin şu an boş"); }

    }

    @Step("Homepage'e git.")
    public void goHomePage(){

        basketPage.goHomePageFromBasket();

    }

    @Step("bu kadar <second> saniye beklet")
    public void waitminute(long second) throws InterruptedException {

        Thread.sleep(second*1000);

    }


}
