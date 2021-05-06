package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helpers.ReportHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;


public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() throws IOException {
        ReportHelper.generateCucumberReport();
    }

    public void takeScreenShot(String screenshotName, String path,Object driver) {
        try {
            File sourcePath = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(path + screenshotName + ".png");
            FileUtils.copyFile(sourcePath, destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
