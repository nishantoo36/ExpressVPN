package helpers.Web;
import ObjectManager.WebPageObjectManager;
import runner.WebRunner;

import java.io.IOException;


public class TestContext {
	private WebPageObjectManager webPageObjectManager;
	private WebRunner cucumberWebRunner;
	public TestContext() throws IOException {
		cucumberWebRunner = new WebRunner();
		webPageObjectManager = new WebPageObjectManager(cucumberWebRunner.getWebDriver());
	}
	public WebPageObjectManager getWebPageObjectManger() {
		return webPageObjectManager;
	}
}
