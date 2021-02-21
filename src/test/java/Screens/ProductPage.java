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

public class ProductPage {
    private static final Logger log = LogManager.getLogger();
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='product_label']")
    private WebElement productPageHeader;

    public ProductPage(WebDriver driver) {
        try{
            this.wait = new WebDriverWait(driver, 10);
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getProductPageHeaderText() {
        wait.until(ExpectedConditions.visibilityOf(productPageHeader));
        String header = productPageHeader.getText();
        log.info("Header is : '{}'",header);
        return header;
    }
}
