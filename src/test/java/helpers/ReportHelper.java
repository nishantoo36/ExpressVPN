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
        Configuration configuration = new Configuration(reportOutputDirectory, "Naggaro");
        configuration.addClassifications("Project", "Naggaro");
        if (FileReaderManager.getInstance().getConfigReader().getPlatform().equalsIgnoreCase("web")) {
            configuration.addClassifications("Platform", FileReaderManager.getInstance().getConfigReader().getPlatform());
            configuration.addClassifications("Browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
        } else if (FileReaderManager.getInstance().getConfigReader().getPlatform().equalsIgnoreCase("android")) {
            configuration.addClassifications("Platform", FileReaderManager.getInstance().getConfigReader().getPlatform());
            configuration.addClassifications("Device", Shell.getDeviceDetails()[1]);
        } else {
            configuration.addClassifications("Platform", "Android and WEb");
            configuration.addClassifications("Browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
            configuration.addClassifications("Device", Shell.getDeviceDetails()[1]);
        }
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
