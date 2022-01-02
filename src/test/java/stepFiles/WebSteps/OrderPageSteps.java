package stepFiles.WebSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import Pages.Web.OrderPage;
import cucumber.api.java.en.When;
import driverFactory.Web.CommonUtils;
import driverFactory.Web.JsonReader;
import helpers.Web.TestContext;
import org.json.simple.JSONArray;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPageSteps {

    TestContext testContext;
    OrderPage orderPage;

    public OrderPageSteps(TestContext context) {
        testContext = context;
        orderPage = testContext.getWebPageObjectManger().getOrderPageScreen();
    }

    @Then("^User should see \"([^\"]*)\" plan selected$")
    public void userShouldSeePlanSelected(String planType) throws Throwable {
        Assert.assertTrue(orderPage.isPlanSelected(planType), planType + "is not selected");
    }

    @Then("^User should see list of plan$")
    public void userShouldSeeListOfPlan() {
        JSONArray planDetails = (JSONArray) JsonReader.Jsonobject.get("plans");
        List<String> plans = CommonUtils.convertJsonArrayToList(planDetails);
        Assert.assertTrue(orderPage.isPlansAvailableOnOrderPage(plans), "List of expected plan details are not available on order page");
    }


    @Then("^User should see details of \"([^\"]*)\" plan$")
    public void userShouldSeeDetailsOfPlan(String planName) {
        String expectedPrice = JsonReader.getJsonDataWithJsonPath("planDescription-"+planName+"-price");
        String expectedTotalBill =  JsonReader.getJsonDataWithJsonPath("planDescription-"+planName+"-totalBill");
        Map<String, String> expectedDetails = new HashMap<>();
        expectedDetails.put("price", expectedPrice);
        expectedDetails.put("totalBill", expectedTotalBill);
        Assert.assertTrue(orderPage.isPlanBoxContains(planName, expectedDetails), planName + " does not have expected details which is \n price: "
                + expectedPrice + "\n Total Bill: " + expectedTotalBill);

    }

    @When("^user select \"([^\"]*)\" plan$")
    public void userSelectPlan(String plan)  {
        orderPage.selectPlan(plan);
    }

    @And("^User should able to see plan best Suggestion dialog$")
    public void userShouldAbleToSeePlanBestSuggestionDialog() {
        Assert.assertTrue(orderPage.isPlanSuggestionDialogAppeared(),"Plan Suggestion dialog not appeared");
    }

    @And("^User should not able to see plan best Suggestion dialog$")
    public void userShouldNotAbleToSeePlanBestSuggestionDialog() {
        Assert.assertFalse(orderPage.isPlanSuggestionDialogAppeared(),"Plan Suggestion dialog appeared");

    }

    @When("^User select \"([^\"]*)\" payment type$")
    public void userSelectPaymentType(String paymentType) throws Throwable {
            orderPage.selectPaymentType(paymentType);
    }

    @Then("^it should open credit card detail fill up form$")
    public void itShouldOpenCreditCardDetailFillUpForm(){
        Assert.assertTrue(orderPage.isCreditCardFormAppeared(),"Credit card form is not appeared on screen");
    }


    @Then("^User should able to see no fill error for email$")
    public void userShouldAbleToSeeNoFillErrorForEmail() {
        Assert.assertTrue(orderPage.isEmailNoFilErrorAppear(),"No fill error for email is not appearing");
    }

    @And("^User should able to see no fill error for credit card form all details$")
    public void userShouldAbleToSeeNoFillErrorForCreditCardFormAllDetails() {
        Assert.assertTrue(orderPage.isCreditCardFormNoFilErrorsAppeared(),"All No fill error for credit card form are not appearing");
    }

    @When("^User click on \"([^\"]*)\" button$")
    public void userClickOnButton(String btnName) {
      orderPage.clickSubmitBtn(btnName);
    }

    @Then("^User should able to see \"([^\"]*)\" button$")
    public void userShouldAbleToSeeButton(String btnName)  {
        Assert.assertTrue(orderPage.isSubmitButtonAvailable(btnName),btnName+" does not appeared");
    }

    @When("^User scroll down the page to \"([^\"]*)\" payment type$")
    public void userScrollDownThePageToPaymentType(String paymentType)  {
        orderPage.scrollDownToPaymentMethod(paymentType);
    }

    @When("^User enter email address as \"([^\"]*)\"$")
    public void userEnterEmailAddressAs(String emailValue)  {
            orderPage.enterEmail(emailValue);
    }

    @Then("^User should able to error for invalid email address$")
    public void userShouldAbleToErrorForInvalidEmailAddress() {
        Assert.assertTrue(orderPage.isInvalidEmailErrorAppear(),"Error for invalid email is not appearing");
    }

    @Then("^User should able to error for invalid cvv$")
    public void userShouldAbleToErrorForInvalidCvv() {
        Assert.assertTrue(orderPage.isInvalidCVVErrorAppear(),"Error for invalid CVV is not appearing");
    }

    @When("^User enter cvv as \"([^\"]*)\"$")
    public void userEnterCvvAs(String cvv)  {
        orderPage.enterCVV(cvv);
    }

    @When("^User enter credit card number as \"([^\"]*)\"$")
    public void userEnterCreditCardNumberAs(String creditCardNumber)  {
        orderPage.enterCreditCardNumber(creditCardNumber);
    }

    @Then("^User should able to error for invalid card number$")
    public void userShouldAbleToErrorForInvalidCardNumber() {
        Assert.assertTrue(orderPage.isInvalidCreditCardNumberErrorAppear(),"Error for invalid card number is not appearing");
    }


}
