package Tests;

import io.testproject.sdk.drivers.ReportingDriver;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.interfaces.testng.ExceptionsReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ExceptionsReporter {

    public WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    public String baseURL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void beforeMethodSetup(Method method){
        log.info("Running : {}", method.getName());
    }

    @BeforeSuite
    public void beforeClassSetup() throws Exception {
        String TP_DEV_TOKEN = System.getenv().get("TP_DEV_TOKEN");

        driver = new ChromeDriver(TP_DEV_TOKEN,new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public ReportingDriver getDriver() {
        return (ReportingDriver) driver;
    }
}
