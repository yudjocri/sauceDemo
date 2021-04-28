package utility;

import org.slf4j.LoggerFactory;
import stepDefs.steps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public  static org.slf4j.Logger logger = LoggerFactory.getLogger(PropertyUtils.class.getName());

    public static String getProperty(String key) {
        Properties props = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("properties/ui.properties");

        try {
            props.load(is);
        } catch (IOException var4) {
            logger.debug(var4.getMessage());
        }
        return props.getProperty(key);
    }

    public static String getConfigProperty(String key) {
        Properties props = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("properties/config.properties");

        try {
            props.load(is);
        } catch (IOException var4) {
            logger.debug(var4.getMessage());
        }
        return props.getProperty(key);
    }
}
