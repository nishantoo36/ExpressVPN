package ObjectManager;

import Pages.Web.*;
import Pages.Web.OrderPage;
import org.openqa.selenium.WebDriver;
import runner.WebRunner;

public class WebPageObjectManager extends WebRunner {
    public WebDriver driver;
    public CommonUIActions commonUIActions;
    public OrderPage orderPage;



    public WebPageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CommonUIActions getCommonActionsScreen() {
        return (commonUIActions == null) ? commonUIActions = new CommonUIActions(driver) : commonUIActions;
    }

    public OrderPage getOrderPageScreen() {
        return (orderPage == null) ? orderPage = new OrderPage(driver) : orderPage;
    }
}
