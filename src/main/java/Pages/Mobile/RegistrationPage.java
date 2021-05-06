package Pages.Mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;

public class RegistrationPage extends CommonPageAction {

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'inputUsername')]")
    private AndroidElement username;

    @AndroidFindBy(accessibility = "email of the customer")
    private AndroidElement email;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'inputPassword')]")
    private AndroidElement password;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'inputName')]")
    private AndroidElement name;

    @AndroidFindBy(xpath = "//android.widget.Spinner[contains(@resource-id,'input_preferedProgrammingLanguage')]")
    private AndroidElement programmingLanguageDropDown;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[contains(@resource-id,'input_adds')]")
    private AndroidElement iAcceptCheckbox;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnRegisterUser')]")
    private AndroidElement btnRegisterUser;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'buttonRegisterUser')]")
    private AndroidElement buttonRegisterUser;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'label_name_data')]")
    private AndroidElement getName;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'label_username_data')]")
    private AndroidElement getUserName;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'abel_password_data')]")
    private AndroidElement getPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'abel_email_data')]")
    private AndroidElement getEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'label_preferedProgrammingLanguage_data')]")
    private AndroidElement getProgrammingLanguage;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'label_acceptAdds_data')]")
    private AndroidElement getIAcceptAddValue;


    public RegistrationPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAllElementPresentOnScreen(int wait) {
        errorMessage ="";
        if (!isElementAvailable(username, wait)) {
            errorMessage = "Element for 'username' is not present \n";
        }
        if (!isElementAvailable(email, wait)) {
            errorMessage = errorMessage + "Element for 'email' is not present \n ";
        }
        if (!isElementAvailable(password, wait)) {
            errorMessage = errorMessage + "Element for 'password' is not present \n";
        }
        if (!isElementAvailable(name, wait)) {
            errorMessage = errorMessage + "Element for 'name' is not present \n";
        }
        if (!isElementAvailable(programmingLanguageDropDown, wait)) {
            errorMessage = errorMessage + "Element for 'programming Language' is not present \n";
        }
        if (!isElementAvailable(iAcceptCheckbox, wait)) {
            errorMessage = errorMessage + "Element for 'I accept adds' is not present \n";
        }
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String getSelectedName(int wait) {
        if (isElementAvailable(name, wait)) {
            return name.getText().replace("\"", "").trim();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the user name");
        }
    }

    public String getSelectedProgrammingLanguage(int wait) {
        if (isElementAvailable(selectListPopup.get(0), wait)) {
            return selectListPopup.get(0).getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the user name");
        }
    }

    public void enterName(String name, int wait) {
        if (isElementAvailable(this.name, wait)) {
            this.name.clear();
            this.name.sendKeys(name);
        } else {
            throw new ElementNotVisibleException("Unable to find name input field");
        }
    }

    public void enterUserName(String userName, int wait) {
        if (isElementAvailable(this.username, wait)) {
            this.username.clear();
            this.username.sendKeys(userName);
        } else {
            throw new ElementNotVisibleException("Unable to find username input field");
        }
    }

    public void enterEmail(String email, int wait) {
        if (isElementAvailable(this.email, wait)) {
            this.email.clear();
            this.email.sendKeys(email);
        } else {
            throw new ElementNotVisibleException("Unable to find email input field");
        }
    }

    public void enterPassword(String password, int wait) {
        if (isElementAvailable(this.password, wait)) {
            this.password.clear();
            this.password.sendKeys(password);
        } else {
            throw new ElementNotVisibleException("Unable to find password input field");
        }
    }

    public void selectProgrammingLanguage(String programmingLanguage, int wait) {
        if (isElementAvailable(programmingLanguageDropDown, wait)) {
            programmingLanguageDropDown.click();
            if (isElementsPresent(selectListPopup, 10)) {
                for (AndroidElement car : selectListPopup) {
                    if (car.getText().equals(programmingLanguage)) {
                        car.click();
                        return;
                    }
                }
                Assert.fail(programmingLanguage + " is not present in car list");
            } else {
                throw new ElementNotVisibleException("Element list for programmingLanguage is not appeared");
            }
        } else {
            throw new ElementNotVisibleException("Element for programmingLanguage dropdown is not appeared");
        }
    }

    public void checkIAcceptAdds(int wait) {
        if (isElementAvailable(iAcceptCheckbox, wait)) {
            iAcceptCheckbox.click();
        } else {
            throw new ElementNotVisibleException("Unable to find I Accept Adds input field");
        }
    }

    public void clickRegisterUserVerify(int wait) {
        if (isElementAvailable(btnRegisterUser, wait)) {
            btnRegisterUser.click();
        } else {
            throw new ElementNotVisibleException("Unable to find I Accept Adds input field");
        }
    }

    public void clickRegisterUser(int wait) {
        if (isElementAvailable(buttonRegisterUser, wait)) {
            buttonRegisterUser.click();
        } else {
            throw new ElementNotVisibleException("Unable to find I Accept Adds input field");
        }
    }

    public String getName(int wait) {
        if (isElementAvailable(getName, wait)) {
            return getName.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the added name");
        }
    }

    public String getUserName(int wait) {
        if (isElementAvailable(getUserName, wait)) {
            return getUserName.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the added userName");
        }
    }

    public String getPassword(int wait) {
        if (isElementAvailable(getPassword, wait)) {
            return getPassword.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the added password");
        }
    }

    public String getEmail(int wait) {
        if (isElementAvailable(getEmail, wait)) {
            return getEmail.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the added email");
        }
    }

    public String getProgrammingLanguage(int wait) {
        if (isElementAvailable(getProgrammingLanguage, wait)) {
            return getProgrammingLanguage.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the selected programming Language");
        }
    }

    public String getIAcceptAddValue(int wait) {
        if (isElementAvailable(getIAcceptAddValue, wait)) {
            return getIAcceptAddValue.getText();
        } else {
            throw new ElementNotVisibleException("Unable to find element to fetch the status of I Accept Adds");
        }
    }



}
