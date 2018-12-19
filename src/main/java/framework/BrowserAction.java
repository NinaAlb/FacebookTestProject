package framework;

public class BrowserAction {

    public static void open(String url) {
        BrowserFactory.driver.get(url);
    }
}
