package Pages.Web;

import driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommonUIActions extends DriverFactory {
    public CommonUIActions(WebDriver driver) {
        super(driver);
    }

    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(className="demo-frame")
    private WebElement dropIFrame;

    public void openMainURL() {
        openUrl(configFileReader.getUrl());
    }

    public void switchToIframe(){
        switchToIframeByWebElement(dropIFrame,20);
    }


}
