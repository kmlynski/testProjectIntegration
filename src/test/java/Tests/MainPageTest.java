package Tests;

import Screens.MainPage;
import Screens.ProductPage;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.WebDriver;


public class MainPageTest extends BaseTest {
    public WebDriver driver;
    private MainPage mainPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUpBeforeMainPageTests() {
        driver = super.driver;
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }

    @BeforeMethod
    public void beforeEachMethodSetup(){
        driver.navigate().to(baseURL);
    }

    @Test(testName = "login_test")
    void login_test() {
        mainPage.enterUserName("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
        assertThat(productPage.getProductPageHeaderText()).isEqualTo("Products");
    }
}