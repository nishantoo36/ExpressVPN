package Pages.Mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotVisibleException;

public class HomePagePage extends CommonPageAction {

    @AndroidFindBy(accessibility = "buttonTestCD")
    private AndroidElement enButton;

    @AndroidFindBy(accessibility = "buttonStartWebviewCD")
    private AndroidElement chromeLogo;

    @AndroidFindBy(accessibility = "startUserRegistrationCD")
    private AndroidElement fileLogo;

    @AndroidFindBy(accessibility = "my_text_fieldCD")
    private AndroidElement textBox;

    @AndroidFindBy(accessibility = "waitingButtonTestCD")
    private AndroidElement showProgressBarButton;

    @AndroidFindBy(accessibility = "visibleButtonTestCD")
    private AndroidElement displayTextViewButton;

    @AndroidFindBy(accessibility = "showToastButtonCD")
    private AndroidElement displayToastButton;

    @AndroidFindBy(accessibility = "showPopupWindowButtonCD")
    private AndroidElement displayPopUpButton;

    @AndroidFindBy(accessibility = "exceptionTestButtonCD")
    private AndroidElement exceptionTestButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'exceptionTestField')]")
    private AndroidElement exceptionTestField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'topLevelElementTest')]")
    private AndroidElement displayAndFocusOnLayoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='This will end the activity']")
    private AndroidElement popUpForEnButton;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement button2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Waiting Dialog']")
    private AndroidElement progressBar;

    @AndroidFindBy(accessibility = "showPopupWindowButtonCD")
    private AndroidElement showPopupWindowButtonCD;



    public HomePagePage(AndroidDriver driver) {
        super(driver);
    }



    public boolean isENButtonPresent(int wait) {
        return isElementAvailable(enButton, wait);
    }

    public boolean isChromeLogoPresent(int wait) {
        return isElementAvailable(chromeLogo, wait);
    }

    public boolean isFileLogoPresent(int wait) {
        return isElementAvailable(fileLogo, wait);
    }

    public boolean isTextBoxPresent(int wait) {
        return isElementAvailable(textBox, wait);
    }

    public boolean isShowProgressBarButtonPresent(int wait) {
        return isElementAvailable(showProgressBarButton, wait);
    }

    public boolean isDisplayTextViewButtonPresent(int wait) {
        return isElementAvailable(displayTextViewButton, wait);
    }

    public boolean isDisplayToastButtonPresent(int wait) {
        return isElementAvailable(displayToastButton, wait);
    }

    public boolean isDisplayPopUpButtonPresent(int wait) {
        return isElementAvailable(displayPopUpButton, wait);
    }

    public boolean isExceptionTestButtonPresent(int wait) {
        return isElementAvailable(exceptionTestButton, wait);
    }

    public boolean isExceptionTestFieldPresent(int wait) {
        return isElementAvailable(exceptionTestField, wait);
    }

    public boolean isDisplayAndFocusOnLayoutButtonPresent(int wait) {
        return isElementAvailable(displayAndFocusOnLayoutButton, wait);
    }

    public boolean isAllElementAvailableOnFirstPage(int wait) {
        errorMessage ="";
        if (!isENButtonPresent(wait)) {
            errorMessage = " 'EnButton' is not present on screen \n";
        }

        if (!isFileLogoPresent(wait)) {
            errorMessage = errorMessage + "'File button' is not present on screen \n";
        }
        if (!isChromeLogoPresent(wait)) {
            errorMessage = errorMessage + "'Chrome button' is not present on screen \n";
        }

        if (!isTextBoxPresent(wait)) {
            errorMessage = errorMessage + "'Text box' is not present on screen \n";
        }
        if (!isShowProgressBarButtonPresent(wait)) {
            errorMessage = errorMessage + "'Show progress bar button' not present on screen \n";
        }
        if (!isDisplayTextViewButtonPresent(wait)) {
            errorMessage = errorMessage + "'Display text view button' not present on screen \n";
        }
        if (!isDisplayToastButtonPresent(wait)) {
            errorMessage = errorMessage + "'Display toast button' not present on screen \n";
        }
        if (!isDisplayPopUpButtonPresent(wait)) {
            errorMessage = errorMessage + "'Display popup button' not present on screen \n";
        }
        if (!isExceptionTestButtonPresent(wait)) {
            errorMessage = errorMessage + "'Exception test button' not present on screen \n";
        }
        if (!isExceptionTestFieldPresent(wait)) {
            errorMessage = errorMessage + "'Exception test field' present not present on screen \n";
        }
        if (!isDisplayAndFocusOnLayoutButtonPresent(wait)) {
            errorMessage = errorMessage + "'Display and focus on layout' button not present on screen \n";
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public void clickOnEnButton(int wait){
        if(isENButtonPresent(wait)){
            enButton.click();
        }else {
            throw new ElementNotVisibleException("En button is not visible");
        }
    }

    public boolean isPopUpForEnButtonPresent(int wait){
       errorMessage = "Pop up for en button is not present" ;
       return isElementAvailable(popUpForEnButton,wait);
    }

    public boolean isNoNoAvailable(int wait){
        errorMessage = "No no button is not available" ;
        return isElementAvailable(button2,wait);
    }

    public void clickOnNoNoButton(int wait){
        if(isNoNoAvailable(wait)){
            button2.click();
        }else {
            throw new ElementNotVisibleException(errorMessage);
        }
    }

    public void clickOnChromeLogo(int wait){
        if(isChromeLogoPresent(wait)){
            chromeLogo.click();
        }else {
            throw new ElementNotVisibleException(errorMessage);
        }
    }

    public void clickOnFileLogo(int wait){
        if(isFileLogoPresent(wait)){
            fileLogo.click();
        }else {
            throw new ElementNotVisibleException(fileLogo+" element not present");
        }
    }

    public void clickOnShowProgressBar(int wait) throws InterruptedException {
        if(isShowProgressBarButtonPresent(wait)){
            showProgressBarButton.click();
            if(isElementAvailable(progressBar,wait)) {
                waitForElementToDisAppear(progressBar, 20);
            }else {
                throw new ElementNotVisibleException(progressBar+ "element for progress bar not present");
            }
        }else {
            throw new ElementNotVisibleException(showProgressBarButton+ "element for Show progress button not present");
        }
    }

    public void clickOnDisplayPopupWindowButton(int wait) {
        if (isDisplayPopUpButtonPresent(wait)) {
            displayPopUpButton.click();
        } else {
            throw new ElementNotVisibleException(displayPopUpButton + " element not present");
        }
    }

    public void dismissPopupFromHomePage(){
        if (isElementAvailable(showPopupWindowButtonCD,5)) {

        } else {
            throw new ElementNotVisibleException(displayPopUpButton + " element not present");
        }
    }

    public void clickOnExceptionTestButton(){
        if (isElementAvailable(exceptionTestButton,5)) {
                exceptionTestButton.click();
        } else {
            throw new ElementNotVisibleException(exceptionTestButton + " element not present");
        }
    }

    public void enterCustomiseException(String value){
        if (isElementAvailable(exceptionTestField,5)) {
            exceptionTestField.clear();
            exceptionTestField.sendKeys(value);
        } else {
            throw new ElementNotVisibleException(exceptionTestField + " element not present");
        }
    }

    public void clickOnDisplayToastButton(int wait) {
        if (isDisplayToastButtonPresent(wait)) {
            displayToastButton.click();
        } else {
            throw new ElementNotVisibleException(displayToastButton + " element not present");
        }
    }

    public String getToastMessageFromHomepage() {
       String val = getToastMessage();
       return val;
    }
}
