package pack01.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public WebDriver webDriver;

    public static WebDriver getDriverType(String browser) throws Exception {
        WebDriver webDriver;
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception ("Add valid parameters 'browser'. instead of " + browser);
        }
         return webDriver;
    }

}
