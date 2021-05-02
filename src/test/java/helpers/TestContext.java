package helpers;
import runner.PageObjectManager;
import runner.CucumberRunner;

import java.io.IOException;


public class TestContext {
	private PageObjectManager pageObjectManger;
	private CucumberRunner cucumberRunner;
	public TestContext() throws IOException {
		cucumberRunner = new CucumberRunner();
		pageObjectManger = new PageObjectManager(cucumberRunner.getDriver());
	}
	public PageObjectManager getPageObjectManger() {
		return pageObjectManger;
	}
}
