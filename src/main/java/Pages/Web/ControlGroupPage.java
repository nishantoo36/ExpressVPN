package Pages.Web;

import driverFactory.Web.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ControlGroupPage extends DriverFactory {

    @FindBy(id = "car-type-button")
    private WebElement horizontalCarType;

    @FindBy(id = "car-type-menu")
    private WebElement horizontalCarTypeMenu;

    @FindBy(id = "ui-id-8-button")
    private WebElement verticalCarType;

    @FindBy(id = "ui-id-8-menu")
    private WebElement verticalCarTypeMenu;

    @FindBy(id = "horizontal-spinner")
    private WebElement horizontalCountBox;

    @FindBy(id = "vertical-spinner")
    private WebElement verticalCountBox;

    @FindBy(xpath = "//div[contains(@class,'ui-controlgroup-horizontal')]/label[text()='Automatic']/child::span[1]")
    private WebElement horizontalAutomaticTransmissionType;

    @FindBy(xpath = "//div[contains(@class,'ui-controlgroup-horizontal')]/label[text()='Insurance']/child::span[1]")
    private WebElement horizontalInsuranceType;

    @FindBy(xpath = "//div[contains(@class,'ui-controlgroup-vertical')]/label[text()='Standard']/child::span[1]")
    private WebElement verticalStandardTransmissionType;

    @FindBy(xpath = "//div[contains(@class,'ui-controlgroup-vertical')]/label[text()='Insurance']/child::span[1]")
    private WebElement verticalInsuranceType;

    public ControlGroupPage(WebDriver driver) {
        super(driver);
    }

    public void selectHorizontalCarType(String carType){
        horizontalCarType.click();
        selectValueByVisibleText(horizontalCarTypeMenu,"div",carType,10);
    }

    public void selectVerticalCarType(String carType){
        verticalCarType.click();
        getValuesByVisibleText(verticalCarTypeMenu,"div",carType,10).get(1).click();
    }


    public void selectHorizontalAutomaticTransmissionType(){
        horizontalAutomaticTransmissionType.click();
    }

    public void selectVerticalStandardTransmissionType(){
        verticalStandardTransmissionType.click();
    }

    public void selectHorizontalInsurance(){
        horizontalInsuranceType.click();
    }

    public void selectVerticalInsurance(){
        verticalInsuranceType.click();
    }

    public void enterCountInVerticalBox(String value){
        verticalCountBox.clear();
        verticalCountBox.sendKeys(value);
    }

    public void enterCountInHorizontalBox(String value){
        horizontalCountBox.clear();
        horizontalCountBox.sendKeys(value);
    }


}
