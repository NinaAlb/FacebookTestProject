package framework;

public class Config {

    public static int timeout = Integer.valueOf(PropertyLoader.getProperty("timeout"));

    public static Browser browser = Browser.valueOf(retrieveProperty("webdriver.browser"));

    public static String facebookLogin = PropertyLoader.getProperty("facebook.username");
    public static String facebookPassword = PropertyLoader.getProperty("facebook.password");

    private static String retrieveProperty(String key) {
        return System.getProperty(key, PropertyLoader.getProperty(key));
    }
}
