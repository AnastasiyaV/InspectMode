package pack01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pack01.Page;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InspectModePage {
    private static final Logger logger = Logger.getLogger(InspectModePage.class.getName());
    private final Page page;
    private final int PAUSE_TIME = 2000;
    private List<WebElement> imagesList;
    private int expectedQuantityImages = 8;

    private By horizontalPanel = By.xpath("//div[@class='Panel horizontal Pane1  ']");
    private By assets = By.xpath("//div[normalize-space()='Assets']//div");
    private By rectangle6Asset = By.xpath("//div[text()='6-rectangle-data-1-xpng-2-xjpg-3-xtiff']");
    private By images = By.xpath("//div[@class='sc-iYUSvU kAnoja']/div");
    private By heliosDialog = By.xpath("//div[@data-test-id=\"helios-dialog-foreground\"]");
    private By heliosDialogButton = By.xpath("//button[contains(text(), 'Got it')]");

    public InspectModePage(Page p) {
        logger.info("Inspect Mode Page construction");
        page = p;
    }

    public InspectModePage closeHeliosDilogIfExists() {
        try {
            if (page.driver.findElement(heliosDialog).isDisplayed()) {
                page.driver.findElement(heliosDialogButton).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not present");
        }
        return this;
    }

    public InspectModePage verifyHorizontalPanelPresent() throws InterruptedException {
        logger.info("Verifying if Horizontal Panel is Present");
        assertTrue(isElementPresent(horizontalPanel));
        return this;
    }

    public InspectModePage verifyAssetsPresent() throws InterruptedException {
        logger.info("Verifying if Assets tab is Present");
        assertTrue(isElementPresent(assets));
        return this;
    }

    public InspectModePage clickAssets() throws InterruptedException {
        logger.info("Clicking On Assets tab");
        page.click(assets);
        page.wait(ExpectedConditions.presenceOfElementLocated(rectangle6Asset));
        return this;
    }

    public void verifyRectangle6IsPresent() throws InterruptedException {
        logger.info("Verifying if Rectangle6 is Present");
        assertTrue(isElementPresent(rectangle6Asset));
    }

    public void verifyAssetNameIsCorrect(String name) throws InterruptedException {
    }

    public InspectModePage getImagesAsElements() {
        logger.info("Getting Images As Elements");
        imagesList = page.driver.findElements(images);
        return this;
    }

    private int countImagesElements() {
        logger.info("Counting Images Elements");
        int count = 0;
        for (WebElement element : imagesList) {
            count++;
        }
        return count;
    }

    public void imagesAssertQuantity() {
        assertEquals(countImagesElements(), expectedQuantityImages);
    }

    @Override
    public String toString() {
        return "InspectModePage{" +
                "page=" + page +
                ", PAUSE_TIME=" + PAUSE_TIME +
                ", horizontalPane1=" + horizontalPanel +
                ", assets=" + assets +
                ", rectangle6Asset=" + rectangle6Asset +
                ", images=" + images +
                '}';
    }


    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public boolean isElementPresent(By element) {
        logger.info(String.format("Checking if [%s] element is present", element));
        return page.driver.findElement(element).isDisplayed();
    }

}
