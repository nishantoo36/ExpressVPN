package ObjectManager;

import Pages.Web.*;
import org.openqa.selenium.WebDriver;
import runner.WebRunner;

public class WebPageObjectManager extends WebRunner {
    public WebDriver driver;
    public CommonUIActions commonUIActions;
    public HomePage homePage;
    public DropAblePage dropAblePage;
    public SelectAblePage selectAblePage;
    public ControlGroupPage controlGroupPage;


    public WebPageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CommonUIActions getCommonActionsScreen() {
        return (commonUIActions == null) ? commonUIActions = new CommonUIActions(driver) : commonUIActions;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public DropAblePage getDropAblePage() {
        return (dropAblePage == null) ? dropAblePage = new DropAblePage(driver) : dropAblePage;
    }

    public SelectAblePage getSelectAblePage() {
        return (selectAblePage == null) ? selectAblePage = new SelectAblePage(driver) : selectAblePage;
    }

    public ControlGroupPage getControlGroupPage() {
        return (controlGroupPage == null) ? controlGroupPage = new ControlGroupPage(driver) : controlGroupPage;
    }
}
