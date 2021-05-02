package stepFiles;

import Pages.ChromePage;
import Pages.CommonPageAction;
import cucumber.api.java.en.Then;
import helpers.TestContext;
import org.testng.Assert;

public class CommonPageSteps {

    TestContext testContext;
    CommonPageAction commonPageAction;
    ChromePage chromePage;

    public CommonPageSteps(TestContext context) {
        testContext = context;
        commonPageAction = testContext.getPageObjectManger().getCommonPage();
        chromePage = testContext.getPageObjectManger().getChromePage();
    }

    @Then("^Verify page title is \"([^\"]*)\"$")
    public void verifyPageTitleIs(String expectedTitle)  {
        String actualTitle = commonPageAction.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is " + actualTitle + " Expected title is " + expectedTitle);
    }

    @Then("^Verify that text \"([^\"]*)\" is present in text view$")
    public void verifyThatTextIsPresent(String expectedText)  {
        Assert.assertTrue(commonPageAction.isTextPresentInTextView(expectedText,15),CommonPageAction.errorMessage);
    }
}
