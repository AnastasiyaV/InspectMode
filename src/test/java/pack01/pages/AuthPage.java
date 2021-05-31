package pack01.pages;

import org.openqa.selenium.By;
import pack01.Page;

import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

public class AuthPage {
    private static final Logger logger = Logger.getLogger(AuthPage.class.getName());
    private final Page page;
    private final int WAIT_TIME = 10;
    private final int PAUSE_TIME = 1000;
    private final String USER_NAME = "anavynogradskamember2@mailinator.com";
    private final String USER_PASSWORD = "!User10000";

    public By titleH1Auth = By.xpath("//h1[normalize-space()='Sign in to Chrome']");
    public By userLogin = By.xpath("//input[@id='signin_email']");
    public By userPassword = By.xpath("//input[@id='signin_password']");
    public By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    public By allDocuments = By.xpath("//div[@class='styles__Root-sc-1myek4t-0 cmYQek document-type-filter__title__3zFDVX']");
    //private Object T;

    public AuthPage(Page p) {
        logger.info("Auth Page construction");
        page = p;
    }

//  public <T> T clickButton(Class<T> contextClass) throws InterruptedException {
//        assertTrue(isElementPresent(signInButton));
//        page.click(signInButton);
//        String titleString = page.driver.findElement(allDocuments).getText();
//        pause(PAUSE_TIME);
//        return (T) contextClass;
//  }

    private void pause(int i) throws InterruptedException {
        Thread.sleep(i);
    }

    public AuthPage verifyAuthH1Title() throws InterruptedException {
        logger.info("Verifying Auth Page H1 Title");
        String titleString = page.driver.findElement(titleH1Auth).getText();
        assertTrue(titleString.contains("Sign in to Chrome"));
        return this;
    }

    public AuthPage inputUserLogin() throws InterruptedException {
        logger.info("Imputing user login");
        page.typeText(userLogin, USER_NAME);
        return this;
    }

    public AuthPage inputUserPassword() throws InterruptedException {
        logger.info("Imputing user password");
        page.click(userLogin);
        page.typeText(userPassword, USER_PASSWORD);
        pause(PAUSE_TIME);
        return this;
    }

    public void clickButton() throws InterruptedException {
        logger.info("Clicking the sign in button");
        assertTrue(isElementPresent(signInButton));
        page.click(signInButton);
        String titleString = page.driver.findElement(allDocuments).getText();
        pause(PAUSE_TIME);
        assertTrue(titleString.contains("All documents"));
        //pause(PAUSE_TIME);
    }


    public boolean isElementPresent(By element) {
        logger.info(String.format("Checking if [%s] element is present", element));
        return page.driver.findElement(element).isDisplayed();
    }

}
