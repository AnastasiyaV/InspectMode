package pack01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pack01.Page;

import java.util.List;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InspectModePage {
    private static final Logger logger = Logger.getLogger(InspectModePage.class.getName());
    private final Page page;
    private final int PAUSE_TIME = 3000;
    private List<WebElement> imagesList;
    private int expectedQuantityImages = 8;

    public By horizontalPanel = By.xpath("//div[@class='Panel horizontal Pane1  ']");
    public By assets = By.xpath("//div[normalize-space()='Assets']//div");
    public By rectangle6Asset = By.xpath("//div[text()='6-rectangle-data-1-xpng-2-xjpg-3-xtiff']");
    //public By images = By.xpath("//div[@class='sc-jXQZqI ciXEmf']");
    public By images = By.xpath("//div[@class='sc-iYUSvU kAnoja']/div");

    public InspectModePage(Page p) {
        logger.info("Inspect Mode Page construction");
        page = p;
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
        pause(PAUSE_TIME);
        return this;
    }

    public void verifyRectangle6IsPresent() throws InterruptedException {
        logger.info("Verifying if Rectangle6 is Present");
        assertTrue(isElementPresent(rectangle6Asset));
    }

    public InspectModePage getImagesAsElements() {
        logger.info("Getting Images As Elements");
        imagesList = page.driver.findElements(images);
        return this;
    }

    private int countImagesElements() {
        logger.info("Counting Images Elements");
        int count=0;
        for (WebElement element : imagesList ) {
            count++;
        }
        return count;
    }

    public void imagesAssertQuantity (){
        assertEquals(countImagesElements(),expectedQuantityImages);
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