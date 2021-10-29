import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;

public class ShoppingInformationSteps extends BaseTest {

    public HomePage homePage;
    public AdressPage adressPage;
    public CreditCardPage creditCardPage;
    public BasketPage basketPage;
    public UserInformation userInformation;

    @BeforeStep
    public void getAlls() {

        adressPage = new AdressPage(driver);
        creditCardPage = new CreditCardPage(driver);
        basketPage = new BasketPage(driver);
        homePage = new HomePage(driver);
        userInformation = new UserInformation(driver);
    }

    @Step("Yeni adres ekle butonuna tıklanır ve adres eklenir.")
    public void setAddAdress() throws InterruptedException {

        adressPage.addAdress();

    }

    @Step("Devam et butonuna tıklanır .")
    public void setContinueButton() {

        adressPage.continueButton();

    }

    @Step("Ödeme tipi kredi kartı seçilir .")
    public void setChoosePaymentMethod() {

        creditCardPage.choosePaymentMethod();

    }

    @Step("Kredi bilgileri doldurulur ve ana sayfaya dönülür .")
    public void setComplatePaymentInformation() throws InterruptedException {

        creditCardPage.complatePaymentInformation();
        Thread.sleep(2000);
        basketPage.goHomePageFromBasket();

    }

    @Step("Sepete tıklanır ve sepet temizlenir .")
    public void setDeleteBasket() throws InterruptedException {

        homePage.goBasket();
        Thread.sleep(3000);
        basketPage.deleteAllProducts();


    }

    @Step("Daha sonra adreslerim alanına gidilir ve eklenen adresler silinir ve test sonlandırılır .")
    public void setDeleteAdress() throws InterruptedException {

        basketPage.goUserInformation();
        userInformation.chooseMyAdressAndDeleteMyAdress();

    }

}
