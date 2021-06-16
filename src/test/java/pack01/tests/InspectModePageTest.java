package pack01.tests;

import org.testng.annotations.Test;
import pack01.BaseTest;

public class InspectModePageTest extends BaseTest {
    @Test
    public void testVerifyRectangle6IsPresent() throws Exception {
        page.openUrl(baseURL);
        page.authPage().verifyAuthH1Title()
                .inputUserLogin()
                .inputUserPassword()
                .clickButton();

        page.homePage().verifyHomeHeader()
                .clickOnAssetsDoc();

        page.docPage().verifyOverviewScreensWrapperrPresent()
                .clickAssetsScreen();

        page.assetsScreenPage().verifyInspectModePresent()
                .clickInspectMode();

        page.inspectModePage().closeHeliosDilogIfExists()
                .verifyAssetsPresent()
                .clickAssets()
                .verifyRectangle6IsPresent();
    }
}
