package runner;


import cucumber.api.CucumberOptions;
import driverFactory.Shell;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"}
        , tags = {"@MobileScenario"})

public class MobileRunner extends AbstractTestNGCucumberParallelTests {

    public static AndroidDriver driver = null;
    static int freePort;
    public static boolean isAppiumServerStarted = false;

    static {
        try {
            if (!isAppiumServerStarted) {
                freePort = findFreePort();
                startAppiumServer();
                isAppiumServerStarted = true;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startAppiumServer() throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(freePort);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //Start the server with the builder
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();

        Thread.sleep(5000);
    }

    private void androidDriver() throws IOException {
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

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        Shell.command("killall node", ".");
        isAppiumServerStarted = false;
    }

    public AndroidDriver getAndroidDriver() throws IOException {
        if (driver == null || driver.getSessionId() == null)
            androidDriver();
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

    @AfterMethod(alwaysRun = true)
    public void killDriver(ITestResult result) {
        String path = null;
        String ImageFileName = result.getMethod().getMethodName()
                + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
        if (result.isSuccess()) {
            path = System.getProperty("user.dir") + "//screenshots/Mobile/Pass//" + ImageFileName;
        } else {
            path = System.getProperty("user.dir") + "//screenshots/Mobile/Fail-Skip//" + ImageFileName;
        }
        takeScreenShot(ImageFileName, path, driver);
        driver.quit();
    }


}
