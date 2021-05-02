package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driverFactory.Shell;
import helpers.ReportHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;


@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", format = {"pretty", "json:target/cucumber.json"}
        , tags = {"@TestngScenario"})

public class CucumberRunner extends AbstractTestNGCucumberTests {

    public static AndroidDriver driver = null;
    static int freePort;

    static {
        try {
            freePort = findFreePort();
            startAppiumServer();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startAppiumServer() throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(freePort);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

        //Start the server with the builder
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();

        Thread.sleep(5000);
    }


    public void androidDriver() throws IOException {
        String buildPath = System.getProperty("user.dir") + "/src/main/resources/App/selendroid-test-app.apk";
        String[] deviceDetails = Shell.getDeviceDetails();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceDetails[1]);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", buildPath);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("autoDismissAlerts", "true");
        driver = new AndroidDriver(new URL("http://localhost:" + String.valueOf(freePort) + "/wd/hub"), capabilities);
    }

    public void stopAppiumServer() {
        Shell.command("killall node", ".");
    }


    public AndroidDriver getDriver() throws IOException {
        if (driver == null || driver.getSessionId() == null) {
            androidDriver();
        }
        return driver;
    }

    public static int findFreePort() throws IOException {
        for (int port = 4723; port < 9999; port++) {
            try {
                ServerSocket socket = new ServerSocket(port);
                socket.close();
                return port;
            } catch (IOException e) {

            }
        }
        throw new IOException("Unable to find free port");

    }

    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() throws IOException {
        ReportHelper.generateCucumberReport();
    }
}
