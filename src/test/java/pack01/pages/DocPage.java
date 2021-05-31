package pack01.pages;

import org.openqa.selenium.By;
import pack01.Page;

import static org.testng.Assert.assertTrue;

public class DocPage {
    private final Page page;
    private final int PAUSE_TIME = 3000;
    public By overviewScreensWrapper = By.id("overviewScreensWrapper");
    public By screenAssets = By.xpath("//a[.='View screen']");

    public DocPage(Page p) {
        page = p;
    }

    public DocPage verifyOverviewScreensWrapperrPresent() throws InterruptedException {
        assertTrue(isElementPresent(overviewScreensWrapper));
        return this;
    }

    public void clickAssetsScreen() throws InterruptedException {
        page.click(screenAssets);
        pause(PAUSE_TIME);
    }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public boolean isElementPresent(By element) {
        return page.driver.findElement(element).isDisplayed();
    }


}
