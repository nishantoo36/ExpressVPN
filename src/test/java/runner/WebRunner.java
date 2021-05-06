package runner;

import FileManager.FileReaderManager;
import cucumber.api.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.GregorianCalendar;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"}
        , tags = {"@WebScenarios"})
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

    @AfterMethod(alwaysRun = true)
    public void killDriver(ITestResult result) {
        String path = null;
        String ImageFileName = result.getMethod().getMethodName()
                + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
        if (result.isSuccess()) {
            path = System.getProperty("user.dir") + "//screenshots/Web/Pass//" + ImageFileName;
        } else {
            path = System.getProperty("user.dir") + "//screenshots/Web/Fail-Skip//" + ImageFileName;
        }
        takeScreenShot(ImageFileName,path,driver);
        driver.quit();
    }

}
