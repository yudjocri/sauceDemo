import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = RunCukesTest.featureFilePath, tags = {"@Sort"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        monochrome = true
)
public class RunCukesTest {
    final public static String featureFilePath = "./src/test/resources/features";
    public  static org.slf4j.Logger logger = LoggerFactory.getLogger(RunCukesTest.class.getName());

    String cucumberOptions = System.getProperty("cucumber.options");
    
}
