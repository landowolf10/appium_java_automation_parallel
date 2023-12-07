package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.LoginPage;
import utils.SetUp;
import utils.TakeScreenShot;

public class CommonSteps
{
    @Given("user opens the app")
    public void validateAppOpen() {
        for (int i = 0; i < SetUp.getInstance().getDrivers().size(); i++) {
            LoginPage loginPage = new LoginPage(SetUp.getInstance().getDrivers().get(i));
            Assert.assertTrue(loginPage.homeButtonDisplayed());
        }
    }

    @AfterStep
    public void screenShot(Scenario scenario) {
        for (int i = 0; i < SetUp.getInstance().getDrivers().size(); i++) {
            TakeScreenShot takeScreenShot = new TakeScreenShot(SetUp.getInstance().getDrivers().get(i));
            takeScreenShot.takeScreenShot(scenario);
        }
    }

    @After
    public void closeDriver() {
        SetUp.quitDrivers();
    }
}
