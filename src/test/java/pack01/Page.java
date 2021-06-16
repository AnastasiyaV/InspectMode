package pack01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pack01.pages.*;

import java.util.logging.Logger;

public class Page {
    private static final Logger logger = Logger.getLogger(Page.class.getName());
    private int timeOut = 10;
    public WebDriver driver;
    public WebDriverWait wait;
    private AuthPage authPage;
    private HomePage homePage;
    private DocPage docPage;
    private AssetsScreenPage assetsScreenPage;
    private InspectModePage inspectModePage;

    public Page(WebDriver driver) {
        logger.info("Page construction");
        this.driver = driver;
        //wait object for all pages
        wait = new WebDriverWait(this.driver, timeOut);
    }

    public AuthPage authPage() {
        logger.info("Instantiating the Authentication Page");
        return (authPage == null) ? (authPage = new AuthPage(this)) : (authPage);
    }

    public HomePage homePage() {
        logger.info("Instantiating the Home Page");
        return (homePage == null) ? (homePage = new HomePage(this)) : (homePage);
    }

    public DocPage docPage() {
        logger.info("Instantiating the Documentation Page");
        return (docPage == null) ? (docPage = new DocPage(this)) : (docPage);
    }

    public AssetsScreenPage assetsScreenPage() {
        logger.info("Instantiating the Assets Screen Page");
        return (assetsScreenPage == null) ? (assetsScreenPage = new AssetsScreenPage(this)) : (assetsScreenPage);
    }

    public InspectModePage inspectModePage() {
        logger.info("Instantiating the Inspect Mode Page");
        return (inspectModePage == null) ? (inspectModePage = new InspectModePage(this)) : (inspectModePage);
    }

    public void openUrl(String url) {
        logger.info("Openning the URL");
        driver.get(url);
    }

    public void click(By selector) {
        logger.info("Clicking on the selector");
        driver.findElement(selector).click();
    }

    public void click(WebElement element) {
        logger.info("Clicking on the element");
        element.click();
    }

    public void typeText(By selector, String text) {
        logger.info("Writing Text using Selector");
        driver.findElement(selector).sendKeys(text);
    }

    public void typeText(WebElement element, String text) {
        logger.info("Writing using Web Element");
        element.sendKeys(text);
    }

    public String getText(By selector) {
        logger.info("Getting Text from Selector");
        return driver.findElement(selector).getText();
    }

    public String getText(WebElement element) {
        logger.info("Getting Text from Webelement");
        return element.getText();
    }

    public void wait(ExpectedCondition<WebElement> presenceOfElementLocated) {
        logger.info(String.format("Waiting if [%s] webelement is present", presenceOfElementLocated));
    }
}
