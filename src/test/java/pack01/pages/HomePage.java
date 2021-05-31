package pack01.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import pack01.Page;

import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class HomePage {
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    private final Page page;
    private final int WAIT_TIME = 5;
    private final int PAUSE_TIME = 3000;
    public By allDocuments = By.xpath("//*[@class='styles__Root-sc-1myek4t-0 hKqKBY document-type-filter__title__3zFDVX']");
    public By homeDocContainerTitleAssets = By.xpath("//div[normalize-space()='Assets with different asset size, formats']"); //div[@class='styles__StyledTruncate-sc-1775b73-10 dYMWxw']
    public By docContainer = By.id("ds-container");
    public By homeAssertTitle = By.xpath("//*[@id=\"app-shell:feature-root:home\"]/div/section/div[1]/div[4]/div[4]/div/div[1]/div/div[1]/div/div/div/div/div/article");

    public HomePage(Page p) {
        logger.info("Home Page construction");
        page = p;
    }

    public HomePage verifyHomeHeader() throws InterruptedException {
        logger.info("Verifying Home Page Header");
        String homeHeaderString = page.driver.findElement(allDocuments).getText();
        assertTrue(homeHeaderString.contains("All documents"));
        //pause(PAUSE_TIME);
        return this;
    }

    public HomePage getCurrentUrl() throws Exception {
        logger.info("Getting the Current Url");
        String url = page.driver.getCurrentUrl();
        Assert.assertEquals(url, "https://google-chrome.invisionapp.com/docs/all");
        return this;
    }

    public void clickOnAssetsDoc() throws Exception {
        logger.info("Clicking On Assets Doc");
        page.click(homeAssertTitle);
//        String titleString = page.driver.findElement(homeAssertTitle).getText();
//        assertTrue(titleString.contains("Assets with different asset size, formats"));
    }

//    private List<WebElement> getDocumentAsElements() {
//
//        return null;
//    }
//
//    private WebElement getDocumentAsElement(String title) throws Exception {
//        List<WebElement> documents = getDocumentAsElements();
//        for (WebElement document : documents
//        ) {
//            if (document.getText().equals(title)) {
//                return document;
//            }
//        }
//        throw new Exception();
//    }

//    public HomePage isDocumentExist(String title, Boolean expectedResult){
////        List<WebElement> documents = getDocumentAsElements();
////        Boolean actualResult = false;
////
////        for (WebElement document: documents) {
////            if(document.getText().equals(title)) {
////                actualResult = true;
////                break;
////            }
////        }
////        Assert.assertEquals(expectedResult, actualResult, "There is no document with this title");
////        return this;
////https://www.guru99.com/find-element-selenium.html
//
//    }
//    public HomePage clickOnDocument(String title) throws Exception {
//        getDocumentAsElement(title).click();
//        return this;
//    }


    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public boolean isElementPresent(By element) {
        logger.info(String.format("Checking if [%s] element is present", element));
        return page.driver.findElement(element).isDisplayed();
    }


}
