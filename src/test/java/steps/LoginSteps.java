package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.Retry;
import utils.SetUp;

public class LoginSteps
{
    private final LoginPage loginPage1 = new LoginPage(SetUp.getInstance().getDrivers().get(0));
    private final LoginPage loginPage2 = new LoginPage(SetUp.getInstance().getDrivers().get(1));;


    @When("entering email (.*) and password (.*)$")
    public void setUserCredentials(String email, String password)
    {
        loginPage1.writeCredentials(email, password);
        loginPage2.writeCredentials(email, password);
    }

    @And("press login button")
    public void pressLoginButton()
    {
        loginPage1.pressLoginButton();
        loginPage2.pressLoginButton();
    }

    @Then("verify user successfully logged in")
    public void successfulLogin()
    {
        Assert.assertEquals("You are logged in!", loginPage1.getLoginModalText());
        Assert.assertEquals("You are logged in!", loginPage2.getLoginModalText());
    }

/*    public void invalidLogin()
    {
        validateInvalidLogin();
    }*/
}