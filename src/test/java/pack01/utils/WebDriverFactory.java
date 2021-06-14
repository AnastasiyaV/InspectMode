package pack01.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
//    private static final boolean REMOTE = FileOperations.getConfigProperty("remote").equals("true");
//    private static final String HUB = FileOperations.getConfigProperty("hub");
    public WebDriver webDriver;

    public static WebDriver getDriverType(String browser) throws Exception {
        WebDriver webDriver;
        switch (browser){
            case "chrome":
            case "chromedriver":
            case "ch":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("incognito");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                webDriver = new FirefoxDriver(ffOptions);
                break;
            default:
                throw new Exception("Add valid parameters 'browser'. instead of " + browser);
        }
         return webDriver;
    }

}
