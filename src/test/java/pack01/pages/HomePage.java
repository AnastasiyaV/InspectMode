package pack01.pages;

import org.openqa.selenium.By;
import pack01.Page;
import java.util.logging.Logger;
import static org.testng.Assert.assertTrue;

public class HomePage {
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    private final Page page;
    private final int WAIT_TIME = 5;
    private final int PAUSE_TIME = 5000;
    private By allDocuments = By.xpath("//div[@class='styles__Root-sc-1myek4t-0 cmYQek document-type-filter__title__3zFDVX']");// TODO: //div[normalize-space()='All documents']
    private By homeDocContainerTitleAssets = By.xpath("//a[@aria-label='Assets with different asset size, formats']");
    private By docContainer = By.id("ds-container");

    private By getDocument(String name){
        return By.xpath(String.format("//a[@aria-label='%s']", name));
    }

    public HomePage(Page p) {
        logger.info("Home Page construction");
        page = p;
    }

    public HomePage verifyHomeHeader() throws InterruptedException {
        logger.info("Verifying Home Page Header");
        String homeHeaderString = page.driver.findElement(allDocuments).getText();
        assertTrue(homeHeaderString.contains("All documents"));
        return this;
    }

    public void clickOnAssetsDoc() throws Exception {
        logger.info("Clicking On Assets Doc");
        page.click(getDocument("Assets with different asset size, formats"));
    }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public boolean isElementPresent(By element) {
        logger.info(String.format("Checking if [%s] element is present", element));
        return page.driver.findElement(element).isDisplayed();
    }
}
