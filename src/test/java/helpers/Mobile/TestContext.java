package helpers.Mobile;
import ObjectManager.WebPageObjectManager;
import runner.MobileRunner;
import ObjectManager.MobilePageObjectManager;
import runner.WebRunner;

import java.io.IOException;


public class TestContext {
	private MobilePageObjectManager mobilePageObjectManger;
	private MobileRunner cucumberMobileRunner;
	public TestContext() throws IOException {
		cucumberMobileRunner = new MobileRunner();
		mobilePageObjectManger = new MobilePageObjectManager(cucumberMobileRunner.getAndroidDriver());
	}
	public MobilePageObjectManager getMobilePageObjectManger() {
		return mobilePageObjectManger;
	}
}
