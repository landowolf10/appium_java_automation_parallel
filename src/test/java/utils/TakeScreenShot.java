package utils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenShot extends BasePage
{
    public TakeScreenShot(AppiumDriver driver) {
        super(driver);
    }

    public void takeScreenShot(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            TakesScreenshot ts = getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}