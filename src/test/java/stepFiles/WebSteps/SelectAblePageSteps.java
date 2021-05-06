package stepFiles.WebSteps;


import Pages.Web.CommonUIActions;
import Pages.Web.SelectAblePage;
import cucumber.api.java.en.When;
import helpers.Web.TestContext;

public class SelectAblePageSteps {
    TestContext testContext;
    SelectAblePage selectAblePage;
    CommonUIActions commonUIActions;

    public SelectAblePageSteps(TestContext context) {
        testContext = context;
        selectAblePage = testContext.getWebPageObjectManger().getSelectAblePage();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @When("^user select \\[\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"\\]$")
    public void userSelect(String arg0, String arg1, String arg2)  {
        commonUIActions.switchToIframe();
        selectAblePage.selectValuesInGroup(new String[]{arg0, arg1, arg2});
    }
}
