package runner;

import Pages.ChromePage;
import Pages.CommonPageAction;
import Pages.HomePagePage;
import Pages.RegistrationPage;
import io.appium.java_client.android.AndroidDriver;
import runner.CucumberRunner;

public class PageObjectManager extends CucumberRunner {

    public HomePagePage homePagePage;
    public ChromePage chromePage;
    public CommonPageAction commonPageAction;
    public RegistrationPage registrationPage;

    public PageObjectManager(AndroidDriver driver) {
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
