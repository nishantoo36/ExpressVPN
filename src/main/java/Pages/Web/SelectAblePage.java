package Pages.Web;

import driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectAblePage extends DriverFactory {

    @FindBy(id = "selectable")
    private WebElement selectable;

    public SelectAblePage(WebDriver driver) {
        super(driver);
    }

    public void selectValuesInGroup(String [] values){
        selectControl();
        for (String value : values){
            selectValueByVisibleText(selectable,"li",value,20);
        }
        deselectControl();
    }
}
