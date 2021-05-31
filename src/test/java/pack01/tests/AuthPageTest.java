package pack01.tests;

import org.testng.annotations.Test;
import pack01.BaseTest;

public class AuthPageTest extends BaseTest {
    @Test
    public void testPositiveLoginField() throws InterruptedException {
        page.openUrl(baseURL);
        page.authPage().verifyAuthH1Title()
                .inputUserLogin()
                .inputUserPassword()
                //.clickButton(HomePage.class).clickDocContainerTitleAssets(); //to put it back when I return generics for negavive tests
                .clickButton();
    }


}
