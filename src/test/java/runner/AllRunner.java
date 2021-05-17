package runner;

import cucumber.api.CucumberOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"})
public class AllRunner extends AbstractTestNGCucumberParallelTests{
}
