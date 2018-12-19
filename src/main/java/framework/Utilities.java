package framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Utilities {

    public static Logger getLogger() {
        return Logger.getLogger("root");
    }


    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) BrowserFactory.driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        getLogger().info("Scroll performed");
    }

    public static boolean isDisplayed(WebElement element, int timeoutInSeconds) {
        try {
            new FluentWait<>(BrowserFactory.driver)
                    .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            getLogger().info("Element is not displayed");
            return false;
        }
        getLogger().info("Element is displayed");
        return true;
    }

    public static boolean isDisplayed(WebElement element) {
        return isDisplayed(element, Config.timeout);

    }

    public static void isListDisplayed(List<WebElement> list) {
        new FluentWait<>(BrowserFactory.driver)
                .withTimeout(Duration.ofSeconds(Config.timeout))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfAllElements(list));
        getLogger().info("Elements in list are displayed");
    }
}
