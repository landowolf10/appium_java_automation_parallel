package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.SetUp;

public class LoginSteps
{
    @When("entering email (.*) and password (.*)$")
    public void setUserCredentials(String email, String password)
    {
        for (int i = 0; i < SetUp.getInstance().getDrivers().size(); i++) {
            LoginPage loginPage = new LoginPage(SetUp.getInstance().getDrivers().get(i));
            loginPage.writeCredentials(email, password);
        }
    }

    @And("press login button")
    public void pressLoginButton()
    {
        for (int i = 0; i < SetUp.getInstance().getDrivers().size(); i++) {
            LoginPage loginPage = new LoginPage(SetUp.getInstance().getDrivers().get(i));
            loginPage.pressLoginButton();
        }
    }

    @Then("verify user successfully logged in")
    public void successfulLogin()
    {
        for (int i = 0; i < SetUp.getInstance().getDrivers().size(); i++) {
            LoginPage loginPage = new LoginPage(SetUp.getInstance().getDrivers().get(i));
            Assert.assertEquals("You are logged in!", loginPage.getLoginModalText());
        }
    }

/*    public void invalidLogin()
    {
        validateInvalidLogin();
    }*/
}