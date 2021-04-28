package utility;

import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepDefs.steps;
import utility.PropertyUtils;


public class BrowserUtils {
    static WebDriver driver;
    public static PropertyUtils propertyUtils;

    public  static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BrowserUtils.class.getName());

    public static WebDriver openBrowser(String browserName) {
        String browser = propertyUtils.getConfigProperty("Browser");
        String newDriver = propertyUtils.getConfigProperty("Driver");
        String path = propertyUtils.getProperty("driverPath") + newDriver;
        if(browserName.equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + path);
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(caps);
        } else {
            logger.debug("Invalid Browser!!");
        }
        return driver;
    }
}
