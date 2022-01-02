package runner;

import FileManager.FileReaderManager;
import cucumber.api.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Collections;


@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"})
public class WebRunner extends AbstractTestNGCucumberParallelTests {

    public static WebDriver driver = null;

    private static String browser;

    static {
        browser = FileReaderManager.getInstance().getConfigReader().getBrowserName();
    }

    private WebDriver startDriver() {
        if ("Chrome".equalsIgnoreCase(browser)) {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if ("FireFox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver getWebDriver(){
        if (driver == null || ((RemoteWebDriver)driver).getSessionId()==null)
            startDriver();
        return driver;
    }
}
