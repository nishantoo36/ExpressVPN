package stepFiles.MobileSteps;

import Pages.Mobile.ChromePage;
import Pages.Mobile.CommonPageAction;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Mobile.TestContext;
import org.testng.Assert;

public class ChromePageSteps {

    TestContext testContext;
    CommonPageAction commonPageAction;
    ChromePage chromePage;

    public ChromePageSteps(TestContext context) {
        testContext = context;
        commonPageAction = testContext.getMobilePageObjectManger().getCommonPage();
        chromePage = testContext.getMobilePageObjectManger().getChromePage();
    }

    @When("^user select car as \"([^\"]*)\"$")
    public void userSelectCarAs(String carName) {
        chromePage.selectCar(carName,15);
    }

    @When("^user select send me your name button$")
    public void userSelectSendMeYourNameButton() {
        chromePage.clickONSendMeYourNameButton(5);
    }

    @When("^user enter name as \"([^\"]*)\"$")
    public void userEnterNameAs(String name) throws Throwable {
        chromePage.enterName(name,10);
    }


    @Then("^Verify the entered name as \"([^\"]*)\"$")
    public void verifyTheEnteredNameAs(String expectedName) throws Throwable {
        String actualName = chromePage.getName(4);
        Assert.assertEquals(actualName,expectedName,"Verification failed, Actual name is "+actualName+" and expected name is "+expectedName);
    }

    @Then("^Verify car name as \"([^\"]*)\"$")
    public void verifyCarNameAs(String expectedCarName) throws Throwable {
        String actualCarName = chromePage.getCar(4);
        Assert.assertEquals(actualCarName,expectedCarName,"Verification failed, Actual car name is "+actualCarName+" and expected car name is "+expectedCarName);
    }

    @When("^user click on start again link$")
    public void userClickOnStartAgainLink() {
        chromePage.clickStartAgainLink(4);
    }

    @Then("^Verify that car in drop down selected as \"([^\"]*)\"$")
    public void verifyThatCarInDropDownSelectedAs(String expectedCarName) throws Throwable {
        String actualCarName = chromePage.getCarFromDropDown(10);
        Assert.assertEquals(actualCarName,expectedCarName,"Verification failed, Actual car name in dropdown is "+actualCarName+" and expected car name in dropdown is "+expectedCarName);
    }


}
