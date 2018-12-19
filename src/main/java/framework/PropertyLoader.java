package framework;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static Properties configProperties = new Properties();

    static {
        loadConfigProperties();
    }

    public static String getProperty(String key) {
        return configProperties.getProperty(key);
    }

    private static void loadConfigProperties() {
        try {
            configProperties.load(ClassLoader.getSystemResource("config.properties").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
