package pack01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    private final static int SECONDSTOWAIT = 5;
    protected WebDriver driver;
    protected String baseURL;
    protected Page page;
    protected WebDriverWait wait;

    @BeforeClass(description = "Prepare init setup")
    public void setup() {
        logger.info("Setup driver and navigate to baseURL");
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(SECONDSTOWAIT, TimeUnit.SECONDS);
        baseURL = "https://google-chrome.invisionapp.com/";
        wait = new WebDriverWait(driver, SECONDSTOWAIT);
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete"));
        page = new Page(driver);

    }

    @AfterClass(description = "Close browser")
    public void tearDown() {
        logger.info("Close browser");
        driver.quit();
    }

}
