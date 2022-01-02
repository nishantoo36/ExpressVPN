package Pages.Web;

import driverFactory.Web.DriverFactory;
import driverFactory.Web.JsonReader;
import org.openqa.selenium.WebDriver;



public class CommonUIActions extends DriverFactory {
    public CommonUIActions(WebDriver driver) {
        super(driver);
    }
    public void openMainURL(String lang) {
        new JsonReader(lang);
        String url = (String) JsonReader.Jsonobject.get("URL");
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
