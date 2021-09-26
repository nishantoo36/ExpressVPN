package helpers;

import FileManager.FileReaderManager;
import driverFactory.Shell;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReportHelper {
    public static void generateCucumberReport() throws IOException {
        File reportOutputDirectory = new File("target");
        ArrayList<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");
        Configuration configuration = new Configuration(reportOutputDirectory, "Web_Mobile_Framework");
        configuration.addClassifications("Project", "Web_Mobile_Framework");
        String platform  = FileReaderManager.getInstance().getConfigReader().getPlatform();
        if (platform.equalsIgnoreCase("web")) {
            configuration.addClassifications("Platform", platform);
            configuration.addClassifications("Browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
        } else if (platform.equalsIgnoreCase("android")) {
            configuration.addClassifications("Platform", platform);
            configuration.addClassifications("Device", Shell.getDeviceDetails()[1]);
        } else {
            configuration.addClassifications("Platform", "Android and Web");
            configuration.addClassifications("Browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
            configuration.addClassifications("Device", Shell.getDeviceDetails()[1]);
        }
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
