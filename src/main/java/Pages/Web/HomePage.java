package Pages.Web;

import driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Droppable']")
    private WebElement dropAble;

    @FindBy(xpath = "//a[text()='Selectable']")
    private WebElement selectAble;

    @FindBy(xpath = "//a[text()='Controlgroup']")
    private WebElement controlGroup;


    public void clickOnSideBarMenu(String menuName) {
        switch (menuName.toLowerCase()) {
            case "dropable":
                dropAble.click();
                break;
            case "selectable":
                selectAble.click();
                break;
            case "controlgroup":
                controlGroup.click();
                break;
        }
    }


}

