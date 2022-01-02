package stepFiles.WebSteps;
import Pages.Web.CommonUIActions;
import cucumber.api.java.en.When;
import driverFactory.Web.JsonReader;
import cucumber.api.java.en.Given;
import helpers.Web.TestContext;
import org.testng.Assert;

public class PreconditionSteps  {

    TestContext testContext;
    CommonUIActions commonUIActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonUIActions = testContext.getWebPageObjectManger().getCommonActionsScreen();
    }


    @Given("User open order page with \"([^\"]*)\" Language$")
    public void userShouldBeOnHomePageWithLanguage(String lan) throws Throwable {
        commonUIActions.openMainURL(lan);
        String expTitle = (String) JsonReader.Jsonobject.get("title");
        String actTitle= commonUIActions.getTitle();
        Assert.assertEquals(actTitle, expTitle,"Expected title is "+expTitle+" actual title is "+actTitle );
    }


}
