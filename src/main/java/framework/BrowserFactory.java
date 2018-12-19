package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;

    public static void initDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch(Config.browser) {

            case CHROME:

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;

            case ANDROID:

//                WebDriverManager.chromedriver().version("2.30").setup();

                capabilities.setCapability("deviceName", "emulator-5554");
                capabilities.setCapability("platformName","Android");
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);

//                try {
//                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//                } catch (MalformedURLException e) {}
                startAppiumDriver(capabilities);

                break;

            case iOS:

                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone XR");
                capabilities.setCapability("udid", "E63A34A1-D665-4CA2-A1DA-02CC5E59B1F3");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("browserName", "Safari");
                capabilities.setCapability("nativeWebTap", true);

                startAppiumDriver(capabilities);

                break;
        }
    }

    public static void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    private static void startAppiumDriver(DesiredCapabilities capabilities) {
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {}
    }
}
