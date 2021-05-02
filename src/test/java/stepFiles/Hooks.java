
package stepFiles;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestContext;
import driverFactory.DriverFactory;
import runner.CucumberRunner;

import static helpers.ConstantVars.*;

import java.io.IOException;


public class Hooks {
	public static Scenario scenario;
	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}



	@Before(order = 0)
	public void Logging(Scenario scenario) {
		this.scenario = scenario;
	}

	@Before(order = 1)
	public void beforeScenario(Scenario scenario) throws IOException {
		testContext.getPageObjectManger().getDriver();
		featureName = scenario.getId().split(";")[0];
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				String path = screenshotPath + screenshotName + ".png";
				new DriverFactory(testContext.getPageObjectManger().getDriver()).takeScreenShot(screenshotName,screenshotPath);
			} catch (IOException e) {
			}
		}
	}

	@After(order = 0)
	public void afterScenario() throws IOException {
		System.out.println("-----------------End of Scenario-----------------");
		CucumberRunner.driver.quit();
	}




}

