import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class SelectionProductSteps extends BaseTest {

    public HomePage homePage ;
    public ProductsPage productsPage ;
    public ProductDetailsPage productDetailsPage ;
    public BasketPage basketPage ;

    @BeforeStep
    public void getAlls(){

        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Step("Katagori seç .")
    public void getCategory(){

        homePage.chooseCategory(0);

    }

    @Step("Alt kategori seç .")
    public void getSubcategory(){

        homePage.chooseSubcategory(2);

    }

    @Step("Bir marka seç <brandNumber> .")
    public void getBrand(int brandNumber){

     productsPage.chooseBrand(brandNumber);

    }

    @Step("Fiyat aralıkları gir <min_number> , <max_number> .")
    public void getPriceRange(String min_number , String max_number){

        productsPage.priceRange(min_number , max_number) ;


    }


    @Step("Kriterleri ayarlanmış ürünleri arat .")
    public void getAllProducts(){

        productsPage.searchProducts();

    }



    @Step("Kriterleri ayarlanmış seçilen ürünün ürün sayfasındaki ISMI csv dosyasına yazdırmak için specificProductNumber ile aynı sayı giriniz <specificProductNameNumber> .")
    public void getProductPageName(int specificProductNameNumber) throws IOException {
        productsPage.selectOneProductName(specificProductNameNumber);

    }


    @Step("Kriterleri ayarlanmış bir ürünü seç <specificProductNumber> .")
    public void getProducts(int specificProductNumber){

        productsPage.selectOneProduct(specificProductNumber);
    }

    @Step("Kriterleri ayarlanmış seçilen ürünün ürün sayfasındaki FIYATI csv dosyasına yazdırmak için specificProductNumber ile aynı sayı giriniz <specificProductPriceNumber> .")
    public void getProductPagePrice(int specificProductPriceNumber) throws IOException {

        productsPage.selectOneProductPrice(specificProductPriceNumber);

    }



    @Step("Ürünler sayfası ile ürünler detay sayfasındaki fiyatı karşılaştır .")
    public void compareTheTwoPrices() throws InterruptedException {
        productDetailsPage.saveProductPriceInProductDetailPage();
        Thread.sleep(1000);
        String priceInProductDetailPage = (String) ScenarioDataStore.get("price-InProductDetailPage");
        String priceInProductPage = (String) ScenarioDataStore.get("price-InProductPage");

        Assertions.assertEquals(priceInProductPage , priceInProductDetailPage);
    }


    @Step("Ürünü sepete ekle .")
    public void setAddProductInBasket() throws InterruptedException {

        productDetailsPage.addProductInBasket();

    }

    @Step("Sepete gidilir .")
    public void setGoBasketFromProductDetailPage(){

        productDetailsPage.goBasketFromProductDetailPage();

    }



    @Step("Ürün sayısını istediğiniz kadar arttırın . arttırmak istediğiniz sayıyı girin <total>")
    public void setIncreaseTheProductsOfNumber(int total) throws InterruptedException {

        basketPage.increaseTheProductsOfNumber(total);

    }


    @Step("Ürün toplamı değeri ve kargo tutarı csv dosyasına yazdırılır ve alışverişi tamamla butonuna tıklanır.")
    public void setWriteTextAllProductsPrice() throws IOException, InterruptedException {

        basketPage.writeTextAllProductsPrice();

    }









}
