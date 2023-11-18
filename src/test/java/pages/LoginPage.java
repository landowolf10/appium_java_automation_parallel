package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.BasePage;
import utils.Retry;

import static locators.LoginLocators.*;

public class LoginPage extends BasePage
{
    Retry retry;

    static String userType;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        retry = new Retry(driver);
    }

    public Boolean homeButtonDisplayed()
    {
        return elementIsDisplayed(By.xpath(homeOption));
    }

    public void writeCredentials(String email, String password)
    {
        clickElement(By.xpath(loginOption));
        writeText(By.xpath(userTextbox), email);
        writeText(By.xpath(passwordTextbox), password);
    }

    public void pressLoginButton()
    {
        clickElement(By.xpath(submitButton));
    }

    public String getLoginModalText() {
        return getElementText(By.xpath(modalWindowLogin));
    }
}