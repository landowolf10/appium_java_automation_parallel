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
    private final LoginPage loginPage1 = new LoginPage(SetUp.getInstance().getDrivers().get(0));
    private final LoginPage loginPage2 = new LoginPage(SetUp.getInstance().getDrivers().get(1));
    TakeScreenShot screenShot1 = new TakeScreenShot(SetUp.getInstance().getDrivers().get(0));
    TakeScreenShot screenShot2 = new TakeScreenShot(SetUp.getInstance().getDrivers().get(1));

    @Given("user opens the app")
    public void validateAppOpen() {
        Assert.assertTrue(loginPage1.homeButtonDisplayed());
        Assert.assertTrue(loginPage2.homeButtonDisplayed());
    }

    @AfterStep
    public void screenShot(Scenario scenario) {
        screenShot1.takeScreenShot(scenario);
        screenShot2.takeScreenShot(scenario);
    }

    @After
    public void closeDriver() {
        SetUp.quitDrivers();
    }
}
