package stepFiles.WebSteps;


import Pages.Web.CommonUIActions;
import Pages.Web.ControlGroupPage;
import cucumber.api.java.en.When;
import helpers.Web.TestContext;


public class ControlAbleGroupPageSteps {
    TestContext testContext;
    ControlGroupPage controlGroupPage;
    CommonUIActions commonUIActions;

    public ControlAbleGroupPageSteps(TestContext context) {
        testContext = context;
        controlGroupPage = testContext.getWebPageObjectManger().getControlGroupPage();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @When("^user select \"([^\"]*)\" in horizontal car-type selection$")
    public void userSelectInHorizontalCarTypeSelection(String carType) throws Throwable {
        controlGroupPage.selectHorizontalCarType(carType);
    }


    @When("^user select Automatic transmission in horizontal car-type selection$")
    public void userSelectAutomaticTransmissionInHorizontalCarTypeSelection() {
        controlGroupPage.selectHorizontalAutomaticTransmissionType();
    }

    @When("^user select Insurance checkbox in horizontal car-type selection$")
    public void userSelectInsuranceCheckboxInHorizontalCarTypeSelection() {
        controlGroupPage.selectHorizontalInsurance();
    }

    @When("^user enter \"([^\"]*)\" value in number of car input box$")
    public void userEnterValueInNumberOfCarInputBox(String count) {
       controlGroupPage.enterCountInHorizontalBox(count);
    }

    @When("^user select \"([^\"]*)\" in vertical car-type selection$")
    public void userSelectInVerticalCarTypeSelection(String carType) {
       controlGroupPage.selectVerticalCarType(carType);
    }

    @When("^user select Standard transmission in vertical car-type selection$")
    public void userSelectStandardTransmissionInVerticalCarTypeSelection() {
        controlGroupPage.selectVerticalStandardTransmissionType();
    }

    @When("^user select Insurance checkbox in vertical car-type selection$")
    public void userSelectInsuranceCheckboxInVerticalCarTypeSelection() {
        controlGroupPage.selectVerticalInsurance();
    }

    @When("^user enter \"([^\"]*)\" value in number of car vertical box$")
    public void userEnterValueInNumberOfCarVerticalBox(String count) {
        controlGroupPage.enterCountInVerticalBox(count);
    }
}
