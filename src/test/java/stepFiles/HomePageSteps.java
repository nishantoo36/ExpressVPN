package stepFiles;

import Pages.HomePagePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.TestContext;
import org.testng.Assert;

import java.io.IOException;

public class HomePageSteps {
    TestContext testContext;
    HomePagePage homePagePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePagePage = testContext.getPageObjectManger().getFirstPage();
    }

    @When("^user launch the app$")
    public void userLaunchTheApp() throws IOException {
        Assert.assertTrue(testContext.getPageObjectManger().getDriver().getSessionId() != null, "Application is not launched");
    }

    @Then("^Verify that all elements available on Home screen$")
    public void verifyThatAllElementsAvailableOnScreen() {
        Assert.assertTrue(homePagePage.isAllElementAvailableOnFirstPage(20), HomePagePage.errorMessage);
    }


    @When("^user click on ENButton$")
    public void userClickOnENButton() {
        homePagePage.clickOnEnButton(0);
    }

    @Then("^Verify that This will end the activity pop-up is open up$")
    public void thisWillEndTheActivityPopUpIsOpenUp() {
        Assert.assertTrue(homePagePage.isPopUpForEnButtonPresent(2), HomePagePage.errorMessage);
    }

    @When("^user click on No no button$")
    public void userClickOnNoNoButton() {
        homePagePage.clickOnNoNoButton(0);
    }

    @When("^user click on Chrome logo$")
    public void userClickOnChromeLogo() {
        homePagePage.clickOnChromeLogo(0);
    }

    @When("^user click on File logo$")
    public void userClickOnFileLogo() {
        homePagePage.clickOnFileLogo(5);
    }

    @When("^user click on show progress bar$")
    public void userClickOnShowProgressBar() throws InterruptedException {
        homePagePage.clickOnShowProgressBar(10);
    }

    @When("^user click on Display Popup Window button$")
    public void userClickOnDisplayPopupWindowButton() {
        homePagePage.clickOnDisplayPopupWindowButton(10);
    }

    @When("^user dismiss popup button$")
    public void userDismissPopupButton() {
        homePagePage.dismissPopupFromHomePage();
    }

    @When("^user click on Press to throw unhandled action exception$")
    public void userClickOnPressToThrowUnhandledActionException() {
        homePagePage.clickOnExceptionTestButton();
    }

    @When("^user enter \"([^\"]*)\" in type to throw unhandled exception field$")
    public void userEnterInTypeToThrowUnhandledExceptionField(String value) throws Throwable {
       homePagePage.enterCustomiseException(value);
    }

    @When("^user click on Display Toast message$")
    public void userClickOnDisplayToastMessage() {
        homePagePage.clickOnDisplayToastButton(5);
        
    }

    @Then("^Toast message should appear as \"([^\"]*)\"$")
    public void toastMessageShouldAppearAs(String expectedToast) throws Throwable {
        String actualToast = homePagePage.getToastMessageFromHomepage();
        Assert.assertEquals(actualToast,expectedToast,"Verification failed, Actual toast message is "+actualToast+" Expected Toast message is "+actualToast);

    }
}

