package stepFiles.MobileSteps;

import Pages.Mobile.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Mobile.TestContext;
import org.testng.Assert;

public class RegistrationPageSteps {

    TestContext testContext;
    RegistrationPage registrationPage;

    public RegistrationPageSteps(TestContext context) {
        testContext = context;
        registrationPage = testContext.getMobilePageObjectManger().getRegistrationPage();
    }

    @Then("^Verify that all elements available on registration screen$")
    public void verifyThatAllElementsAvailableOnRegistrationScreen() {
        Assert.assertTrue(registrationPage.isAllElementPresentOnScreen(20), RegistrationPage.errorMessage);
    }

    @Then("^Verify that \"([^\"]*)\" is prePopulated in name field$")
    public void verifyThatIsPrePopulatedInNameField(String expectedName) throws Throwable {
      String  actualName = registrationPage.getSelectedName(2);
      Assert.assertEquals(actualName,expectedName,"Actual name is " + actualName + " Expected name is " + expectedName);
    }

    @Then("^Verify that \"([^\"]*)\" is selected as programming language by default$")
    public void verifyThatIsSelectedAsProgrammingLanguageByDefault(String expectedProgrammingLanguage) throws Throwable {
        String  actualProgrammingLanguage = registrationPage.getSelectedProgrammingLanguage(2);
        Assert.assertEquals(actualProgrammingLanguage,expectedProgrammingLanguage,"Actual name is " + actualProgrammingLanguage + " Expected name is " + expectedProgrammingLanguage);
    }

    @When("^user select username as \"([^\"]*)\"$")
    public void userSelectUsernameAs(String username) throws Throwable {
        registrationPage.enterUserName(username,4);
    }

    @When("^user select email as \"([^\"]*)\"$")
    public void userSelectEmailAs(String email) throws Throwable {
        registrationPage.enterEmail(email,4);
    }

    @When("^user select password as \"([^\"]*)\"$")
    public void userSelectPasswordAs(String password) throws Throwable {
       registrationPage.enterPassword(password,4);
    }

    @When("^user select name as \"([^\"]*)\"$")
    public void userSelectNameAs(String name) throws Throwable {
        registrationPage.enterName(name,4);
    }

    @When("^user select programming language as \"([^\"]*)\"$")
    public void userSelectProgrammingLanguageAs(String programmingLanguage) throws Throwable {
        registrationPage.selectProgrammingLanguage(programmingLanguage,4);
    }

    @When("^user select I accept adds checkbox$")
    public void userSelectIAcceptAddsCheckbox() {
        registrationPage.checkIAcceptAdds(4);
    }
    @When("^user click Register user \\(verify\\)$")
    public void userClickRegisterUserVerify() {
        registrationPage.clickRegisterUserVerify(4);
    }

    @When("^user click Register use$")
    public void userClickRegisterUse() {
        registrationPage.clickRegisterUser(4);
    }

    @Then("^Verify that value of name is \"([^\"]*)\"$")
    public void verifyThatValueOfNameIs(String expectedName) throws Throwable {
       String actualName = registrationPage.getName(10);
       Assert.assertEquals(actualName,expectedName,"Verification failed, Actual name added is " + actualName + " Expected name added is " + expectedName);
    }

    @Then("^Verify that value of username is \"([^\"]*)\"$")
    public void verifyThatValueOfUsernameIs(String expectedUserName) throws Throwable {
        String actualUserName = registrationPage.getUserName(10);
        Assert.assertEquals(actualUserName,expectedUserName,"Verification failed, Actual user name added is " + actualUserName + " Expected user name added is " + expectedUserName);
    }

    @Then("^Verify that value of password is \"([^\"]*)\"$")
    public void verifyThatValueOfPasswordIs(String expectedPassword) throws Throwable {
        String actualPassword= registrationPage.getPassword(10);
        Assert.assertEquals(actualPassword,expectedPassword,"Verification failed, Actual password added is " + actualPassword + " Expected password added is " + expectedPassword);
    }

    @Then("^Verify that value of email is \"([^\"]*)\"$")
    public void verifyThatValueOfEmailIs(String expectedEmail) throws Throwable {
        String actualEmail= registrationPage.getEmail(10);
        Assert.assertEquals(actualEmail,expectedEmail,"Verification failed, Actual email added is " + actualEmail + " Expected email added is " + expectedEmail);
    }

    @Then("^Verify that value of programming language is \"([^\"]*)\"$")
    public void verifyThatValueOfProgrammingLanguageIs(String expectedProgrammingLanguage) throws Throwable {
        String actualProgrammingLanguage= registrationPage.getProgrammingLanguage(10);
        Assert.assertEquals(actualProgrammingLanguage,expectedProgrammingLanguage,"Verification failed, Actual programming language added is " + actualProgrammingLanguage + " Expected programming language added is " + expectedProgrammingLanguage);

    }

    @Then("^Verify that bool status of I accepted adds is \"([^\"]*)\"$")
    public void verifyThatBoolStatusOfIAcceptedAddsIs(String expectedIAcceptedAdds) throws Throwable {
        String actualIAcceptedAdds= registrationPage.getIAcceptAddValue(10);
        Assert.assertEquals(actualIAcceptedAdds,expectedIAcceptedAdds,"Verification failed, Actual I accepted adds added is " + actualIAcceptedAdds + " Expected I accepted adds added is " + expectedIAcceptedAdds);

    }
}
