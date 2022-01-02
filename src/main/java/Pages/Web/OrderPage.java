package Pages.Web;

import driverFactory.Web.CommonUtils;
import driverFactory.Web.DriverFactory;
import driverFactory.Web.JsonReader;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderPage extends DriverFactory {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".desktop .plan-box .plan-name")
    List<WebElement> planTypes;

    @FindBy(css = ".plan.selected .desktop .plan-name")
    WebElement selectedPlanType;

    @FindBy(css = ".desktop .best-deal-sticker~.plan-name")
    WebElement bestDealer;

    @FindBy(css = ".step.step1 h5")
    WebElement step1Text;

    @FindBy(css = ".step.step2 h5")
    WebElement step2Text;

    @FindBy(css = ".step.step3 h5 .desktop")
    WebElement step3Text;

    @FindBy(css = ".footer-menu-title")
    List<WebElement> footerMenus;

    @FindBy(xpath = "//h4[contains(text(),'ExpressVPN')]/following::ul[@class='checkmark']/li[text()]")
    List<WebElement> expressVPNIncludes;

    @FindBy(css = ".bookmark~h4")
    List<WebElement> paymentTypes;

    @FindBy(id = "signup_email-error")
    WebElement emailError;

    @FindBy(id = "signup_email")
    WebElement emailInput;

    @FindBy(xpath = "//h4[contains(text(),'Credit Card')]//following::p[@class='tos'][1]")
    WebElement creditCardTOS;

    @FindBy(xpath = "//h4[contains(text(),'PayPal')]//following::p[@class='tos'][1]")
    WebElement payPalTOS;

    @FindBy(xpath = "//h4[contains(text(),'Bitcoin')]//following::p[@class='tos'][1]")
    WebElement bitcoinTOS;

    @FindBy(xpath = "//h4[contains(text(),'Other')]//following::p[@class='tos'][1]")
    WebElement otherTOS;

    @FindBy(css = ".desktop .plan-box")
    List<WebElement> planBoxDetails;

    @FindBy(css = ".plan.selected~div")
    WebElement planSuggestionDialog;

    @FindBy(css = ".credit-card-form .form-group label:not(.accessibility-hidden)")
    List<WebElement> creditCardFormDetails;

    @FindBy(css = "input[name='commit']")
    List<WebElement> submitBtn;

    @FindBy(css = ".credit-card-form label.error")
    List<WebElement> creditCardFormErrors;

    @FindBy(css = "input[value='Continue to PayPal']")
    WebElement continueToPayPalBtn;

    @FindBy(css = "input[value='Continue to BitPay']")
    WebElement continueToBitPayBtn;

    @FindBy(css = "input[value='Continue to Paymentwall']")
    WebElement continueToPaymentwallBtn;

    @FindBy(id = "signup_ccv")
    WebElement cvvInput;

    @FindBy(id = "signup_cc_no")
    WebElement creditCardNumberInput;

    public boolean isPlanSelected(String plan) {
        return selectedPlanType.getText().equals(plan);
    }

    public boolean isMostPopularPlan(String plan) {
        return bestDealer.getText().equals(plan);
    }

    public boolean isPlansAvailableOnOrderPage(List<String> expectedPlanTypes) {
        List<String> actualPlanTypes = new ArrayList<>();
        for (WebElement planType : planTypes) {
            actualPlanTypes.add(planType.getText());
        }
        return CommonUtils.compareList(actualPlanTypes, expectedPlanTypes);
    }

    public boolean isPlanBoxContains(String planType, @NotNull Map<String, String> values) {
        String details = getPlanDetails(planType);
        for (Map.Entry<String, String> val : values.entrySet()) {
            if (!details.contains(val.getValue())) {
                return false;
            }
        }
        return true;
    }

    public String getPlanDetails(String planType) {
        int count = 0;
        for (WebElement plan : planTypes) {
            String text = plan.getText().toLowerCase();
            if (text.contains(planType.toLowerCase())) {
                return planBoxDetails.get(count).getText();
            }
            count++;
        }
        throw new NoSuchElementException("Not able to find element which contains planType as " + planType);
    }

    public void selectPlan(String planType) {
        for (WebElement plan : planTypes) {
            if (plan.getText().toLowerCase().contains(planType.toLowerCase())) {
                plan.click();
                break;
            }
        }
    }

    public boolean isPlanSuggestionDialogAppeared() {
        try {
            String expectedDialog = JsonReader.getJsonDataWithJsonPath("plan suggestion dialog");
            String actualDialog = planSuggestionDialog.getText();
            return actualDialog.contains(expectedDialog);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectPaymentType(String paymentType) {
        for (WebElement ele : paymentTypes) {
            if (ele.getText().contains(paymentType)) {
                ele.click();
                break;
            }
        }
    }

    public boolean isCreditCardFormAppeared() {
        JSONArray formDetails = (JSONArray) JsonReader.Jsonobject.get("Credit Card form Details");
        List<String> expectedFormDetails = CommonUtils.convertJsonArrayToList(formDetails);
        List<String> actualFormDetails = new ArrayList<>();
        if (isElementListAvailable(creditCardFormDetails, 5)) {
            actualFormDetails = getValuesByElementList(creditCardFormDetails);
        }
        return CommonUtils.compareList(expectedFormDetails, actualFormDetails);
    }


    public void clickSubmitBtn(String btnName) {
        for (WebElement btn : submitBtn) {
            if (btn.getAttribute("value").equals(btnName)) {
                btn.click();
                break;
            }
        }
    }

    public void scrollDownToPaymentMethod(String paymentType) {
        for (WebElement Type : paymentTypes) {
            if (Type.getText().contains(paymentType)) {
                scrollDownToElement(Type);
            }
        }

    }

    public boolean isEmailNoFilErrorAppear() {
        String expectedError = JsonReader.getJsonDataWithJsonPath("validations-noFillEmail");
        return emailError.getText().equals(expectedError);
    }

    public boolean isInvalidEmailErrorAppear() {
        String expectedError = JsonReader.getJsonDataWithJsonPath("validations-invalidEmail");
        return emailError.getText().equals(expectedError);
    }

    public boolean isCreditCardFormNoFilErrorsAppeared() {
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-FirstName"));
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-LastName"));
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-noFilCardNumber"));
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-expiryMonth"));
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-expiryYear"));
        expectedErrors.add(JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-noFilCVV"));
        List<String> actualErrors = getValuesByElementList(creditCardFormErrors);
        return CommonUtils.compareList(expectedErrors, actualErrors);
    }

    public boolean isInvalidCVVErrorAppear() {
        String expectedError = JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-invalidCVV");
        for (WebElement ele : creditCardFormErrors) {
            if (ele.getText().equals(expectedError)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInvalidCreditCardNumberErrorAppear() {
        String expectedError = JsonReader.getJsonDataWithJsonPath("validations-creditCardForm-invalidCardNumber");
        for (WebElement ele : creditCardFormErrors) {
            if (ele.getText().equals(expectedError)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubmitButtonAvailable(String btnName) {
        for (WebElement btn : submitBtn) {
            if (btn.getAttribute("value").equals(btnName)) {
                return true;
            }
        }
        return false;
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        emailInput.sendKeys(Keys.RETURN);
    }

    public void enterCVV(String value) {
        cvvInput.clear();
        cvvInput.sendKeys(value);
        creditCardNumberInput.sendKeys(Keys.RETURN);
    }

    public void enterCreditCardNumber(String creditCard) {
        creditCardNumberInput.clear();
        creditCardNumberInput.sendKeys(creditCard);
        creditCardNumberInput.sendKeys(Keys.RETURN);
    }

}
