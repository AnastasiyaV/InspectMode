package pack01.pages;

import org.openqa.selenium.By;
import pack01.Page;

import static org.testng.Assert.assertTrue;

public class AssetsScreenPage {
    private final Page page;
    private final int PAUSE_TIME = 3000;
    public By inspectMode = By.xpath("//a[contains(.,'Enter Inspect Mode')]");


    public AssetsScreenPage(Page p) {
        page = p;
    }

    public AssetsScreenPage verifyInspectModePresent() throws InterruptedException {
        assertTrue(isElementPresent(inspectMode));
        return this;
    }

    public void clickInspectMode() throws InterruptedException {
        page.click(inspectMode);
        pause(PAUSE_TIME);
    }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public boolean isElementPresent(By element) {
        return page.driver.findElement(element).isDisplayed();
    }
}
