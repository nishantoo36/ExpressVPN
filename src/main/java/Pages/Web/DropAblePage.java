package Pages.Web;

import driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropAblePage extends DriverFactory {

    @FindBy(id = "draggable")
    private WebElement dragAble;

    @FindBy(id="droppable")
    private WebElement dropAble;

    public DropAblePage(WebDriver driver) {
        super(driver);
    }

    public void doDragAndDrop(){
        dragAndDrop(dragAble,dropAble,20);
    }


}
