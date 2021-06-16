package pack01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pack01.utils.FileOperations;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static pack01.utils.WebDriverFactory.getDriverType;

public class BaseTest {
    protected WebDriver driver;
    protected String baseURL;
    protected Page page;
    protected WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    private final static int SECONDSTOWAIT = 5;
    String isBrowserRendered = "return document.readyState";
    String browserRenderedSuccessfulState = "complete";

    @BeforeClass(description = "Prepare init setup")
    public void setup() throws Exception {
        logger.info("Setup driver and navigate to baseURL");
        initializeProperties();
        waitForBrowserRerndered();
        page = new Page(driver);
    }

    private void waitForBrowserRerndered() {
        wait = new WebDriverWait(driver, SECONDSTOWAIT);
        driver.manage().timeouts().implicitlyWait(SECONDSTOWAIT, TimeUnit.SECONDS);
        wait.until(driver -> ((JavascriptExecutor) driver)
                .executeScript(isBrowserRendered).equals(browserRenderedSuccessfulState));
    }

    private void initializeProperties() {
        baseURL = FileOperations.getConfigProperty("baseUrl");
        try {
            driver = getDriverType(FileOperations.getConfigProperty("browser"));
        } catch (Exception e) {e.printStackTrace();
        }
    }

    @AfterClass(description = "Close browser")
    public void tearDown() {
        logger.info("Close browser");
        driver.quit();
    }
}
