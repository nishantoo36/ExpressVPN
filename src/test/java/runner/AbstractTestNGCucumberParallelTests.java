package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import helpers.ReportHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


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

    @AfterMethod(alwaysRun = true)
    public void killDriver(ITestResult result) {
        String path = null;
        String ImageFileName = result.getMethod().getMethodName()
                + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
        if(MobileRunner.driver!=null) {
            if (result.isSuccess()) {
                path = System.getProperty("user.dir") + "//screenshots/Mobile/Pass//" + ImageFileName;
            } else {
                path = System.getProperty("user.dir") + "//screenshots/Mobile/Fail-Skip//" + ImageFileName;
            }
            takeScreenShot(ImageFileName, path, MobileRunner.driver);
            MobileRunner.driver.quit();
            MobileRunner.driver=null;
        }else if(WebRunner.driver!=null){
            if (result.isSuccess()) {
                path = System.getProperty("user.dir") + "//screenshots/Web/Pass//" + ImageFileName;
            } else {
                path = System.getProperty("user.dir") + "//screenshots/Web/Fail-Skip//" + ImageFileName;
            }
            takeScreenShot(ImageFileName, path, WebRunner.driver);
            WebRunner.driver.quit();
            WebRunner.driver=null;
        }
    }

}
