package stepFiles.WebSteps;
import Pages.Web.CommonUIActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.Web.TestContext;

public class PreconditionSteps  {

    TestContext testContext;
    CommonUIActions commonUIActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @Given("User should be on Home Page")
    public void userShouldBeOnLoginPage() {
        commonUIActions.openMainURL();
    }

    @When("^user switch to iframe$")
    public void userSwitchToIframe() {
        commonUIActions.switchToIframe();
    }
}
