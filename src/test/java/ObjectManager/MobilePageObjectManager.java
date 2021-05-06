package ObjectManager;

import Pages.Mobile.ChromePage;
import Pages.Mobile.CommonPageAction;
import Pages.Mobile.HomePagePage;
import Pages.Mobile.RegistrationPage;
import io.appium.java_client.android.AndroidDriver;
import runner.MobileRunner;


public class MobilePageObjectManager extends MobileRunner {

    public HomePagePage homePagePage;
    public ChromePage chromePage;
    public CommonPageAction commonPageAction;
    public RegistrationPage registrationPage;

    public MobilePageObjectManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePagePage getFirstPage() {
        return (homePagePage == null) ? homePagePage = new HomePagePage(driver) : homePagePage;
    }

    public ChromePage getChromePage() {
        return (chromePage == null) ? chromePage = new ChromePage(driver) : chromePage;
    }

    public CommonPageAction getCommonPage() {
        return (commonPageAction == null) ? commonPageAction = new CommonPageAction(driver) : commonPageAction;
    }

    public RegistrationPage getRegistrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }


}
