package stepFiles.WebSteps;

import Pages.Web.HomePage;
import cucumber.api.java.en.When;
import helpers.Web.TestContext;

public class HomePageSteps  {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getWebPageObjectManger().getHomePage();
    }

    @When("^user click on \"([^\"]*)\" link$")
    public void userClickOnLink(String menuName){
       homePage.clickOnSideBarMenu(menuName);
    }


}
