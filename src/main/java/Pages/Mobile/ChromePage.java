package Pages.Mobile;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

public class ChromePage extends CommonPageAction {

    @AndroidFindBy(xpath = "//android.widget.EditText[(@resource-id='name_input')]")
    private AndroidElement nameInput;

    @AndroidFindBy(xpath = "//android.widget.TextView[(@text='Prefered Car:')]/following-sibling::android.view.View[2]")
    private AndroidElement carDropDown;

    @AndroidFindBy(xpath = "//android.widget.Button[(@text='Send me your name!')]")
    private AndroidElement sendMeYourNameButton;

    @AndroidFindBy(xpath = "//android.view.View[(@text='Your name is:')]/following-sibling::android.widget.TextView[1]")
    private AndroidElement getName;

    @AndroidFindBy(xpath = "//android.view.View[(@text='Your prefered car is:')]/following-sibling::android.widget.TextView[1]")
    private AndroidElement getCar;

    @AndroidFindBy(accessibility = "here")
    private AndroidElement startAgainLink;


    public ChromePage(AndroidDriver driver) {
        super(driver);
    }

    public void enterName(String name, int wait) {
        if (isElementAvailable(nameInput, wait)) {
            nameInput.clear();
            nameInput.sendKeys(name);
        } else {
            throw new ElementNotVisibleException("Unable to find name input field");
        }
    }

    public String getCarFromDropDown(int wait){
        if(isElementAvailable(carDropDown,wait)){
            return carDropDown.getText();
        }else {
            throw new ElementNotVisibleException("Unable to find element to fetch the car name in drop down");
        }
    }


    public void selectCar(String carName, int wait) {
        if (isElementAvailable(carDropDown, wait)) {
            carDropDown.click();
            if (isElementsPresent(selectListPopup, 10)) {
                for (AndroidElement car : selectListPopup) {
                    if (car.getText().equals(carName)) {
                        car.click();
                        return;
                    }
                }
                Assert.fail(carName + " is not present in car list");
            } else {
                throw new ElementNotVisibleException("Element list for car is not appeared");
            }
        } else {
            throw new ElementNotVisibleException("Element for car dropdown is not appeared");
        }
    }

    public void clickONSendMeYourNameButton(int wait){
        if(isElementAvailable(sendMeYourNameButton,wait)){
            sendMeYourNameButton.click();
        }else {
            throw new ElementNotVisibleException("Element for send me your name is not appeared");
        }
    }

    public String getName(int wait){
        if(isElementAvailable(getName,wait)){
            return getName.getText().replace("\"","").trim();
        }else {
            throw new ElementNotVisibleException("Unable to find element to fetch the user name");
        }
    }

    public String getCar(int wait){
        if(isElementAvailable(getCar,wait)){
            return getCar.getText().replace("\"","").trim();
        }else {
            throw new ElementNotVisibleException("Unable to find element to fetch the car name");
        }
    }

    public void  clickStartAgainLink(int wait){
        if(isElementAvailable(startAgainLink,wait)){
           startAgainLink.click();
        }else {
            throw new ElementNotVisibleException("Unable to find element for start again link");
        }
    }



}
