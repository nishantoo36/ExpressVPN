package stepFiles.MobileSteps;

import Pages.Mobile.ChromePage;
import Pages.Mobile.CommonPageAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.Mobile.TestContext;
import org.testng.Assert;

public class CommonPageSteps {

    TestContext testContext;
    CommonPageAction commonPageAction;
    ChromePage chromePage;

    public CommonPageSteps(TestContext context) {
        testContext = context;
        commonPageAction = testContext.getMobilePageObjectManger().getCommonPage();
        chromePage = testContext.getMobilePageObjectManger().getChromePage();
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

    @Given("^Test app should open$")
    public void testAppShouldOpen() {

    }
}
