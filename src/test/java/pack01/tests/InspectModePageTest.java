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

        page.homePage().getCurrentUrl()
                .clickOnAssetsDoc();

        page.docPage().verifyOverviewScreensWrapperrPresent()
                .clickAssetsScreen();

        page.assetsScreenPage().verifyInspectModePresent()
                .clickInspectMode();

        page.inspectModePage().verifyAssetsPresent()
                .verifyAssetsPresent()
                .clickAssets()
                .verifyRectangle6IsPresent();
    }
     @Test
    public void testVerifyCountImagesElements() throws Exception {
        page.openUrl(baseURL);
        page.authPage().verifyAuthH1Title()
                .inputUserLogin()
                .inputUserPassword()
                .clickButton();

        page.homePage().getCurrentUrl()
                .clickOnAssetsDoc();

        page.docPage().verifyOverviewScreensWrapperrPresent()
                .clickAssetsScreen();

        page.assetsScreenPage().verifyInspectModePresent()
                .clickInspectMode();

        page.inspectModePage().verifyAssetsPresent()
                .verifyAssetsPresent()
                .clickAssets()
                .getImagesAsElements()
                .imagesAssertQuantity();
    }

}
