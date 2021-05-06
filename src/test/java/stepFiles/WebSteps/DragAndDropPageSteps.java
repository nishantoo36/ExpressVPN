package stepFiles.WebSteps;

import Pages.Web.CommonUIActions;
import Pages.Web.DropAblePage;
import cucumber.api.java.en.When;
import helpers.Web.TestContext;

public class DragAndDropPageSteps {

    TestContext testContext;
    DropAblePage dropAblePage;
    CommonUIActions commonUIActions;

    public DragAndDropPageSteps(TestContext context) {
        testContext = context;
        dropAblePage = testContext.getWebPageObjectManger().getDropAblePage();
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }

    @When("^user do drag and drop$")
    public void userDoDragAndDrop() {
        commonUIActions.switchToIframe();
        dropAblePage.doDragAndDrop();
    }

}
