package Screens;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    private WebDriverWait wait;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        try{
            this.driver = driver;
            this.wait = new WebDriverWait(this.driver, 10);
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MainPage enterUserName(String username) {
        log.info("Entering username: {}", username);
        wait.until(ExpectedConditions.visibilityOf(userNameInput)).click();
        userNameInput.sendKeys(username);
        return new MainPage(driver);
    }

    public MainPage enterPassword(String password) {
        log.info("Entering password: {}", password);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).click();
        passwordInput.sendKeys(password);

        return new MainPage(driver);
    }

    public void clickLoginButton(){
        log.info("Clicking log in button.");
        loginButton.click();
    }

}
