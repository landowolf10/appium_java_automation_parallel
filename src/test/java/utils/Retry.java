package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static locators.LoginLocators.*;

public class Retry extends BasePage
{
    public Retry(AppiumDriver driver) {
        super(driver);
    }

    public void retry()
    {
        if (elementExists(By.xpath(accessDashboardButton), 60))
        {
            clickElement(By.xpath(accessDashboardButton));
            return;
        }

        System.out.println("Access dashboard button not displayed");

        if (elementExists(By.xpath(retryButton), 30))
        {
            int counter = 0;

            for (int i = 0; i < 3; i++)
            {
                if (elementExists(By.xpath(retryButton), 30))
                {
                    System.out.println("Retry button displayed");

                    counter++;

                    clickElement(By.xpath(retryButton));

                    if (counter == 3 && waitUntilElementLocated(By.xpath(exitButton), 15).isDisplayed())
                    {
                        clickElement(By.xpath(exitButton));
                        System.out.println("Exit button pressed");
                        //killDriver();
                    }
                }

                if (elementExists(By.xpath(accessDashboardButton), 50))
                {
                    clickElement(By.xpath(accessDashboardButton));
                    break;
                }
            }
        }
    }
}