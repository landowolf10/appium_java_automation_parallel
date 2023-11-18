package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SetUp {
    private static SetUp instance;
    private final List<AppiumDriver> driverInstances;

    public SetUp() {
        this.driverInstances = new ArrayList<>();
        createDrivers();
    }

    public static SetUp getInstance() {
        if (instance == null)
            instance = new SetUp();

        return instance;
    }

    public List<AppiumDriver> getDrivers() {
        return driverInstances;
    }

    private void createDrivers() {
        String userName = "orlandoavila_SaKnUC";
        String accessKey = "wpUp3j8EbKrHdvrweUxk";
        HashMap<String, Object> browserStackOptions = new HashMap<>();

        browserStackOptions.put("appiumVersion", "2.0.1");
        browserStackOptions.put("gpsLocation", "41.8755616, -87.6244212");

        for (int i = 0; i < 2; i++) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("bstack:options", browserStackOptions);
            capabilities.setCapability("buildName", "Login user");
            capabilities.setCapability("projectName", "Mobile Tests");
            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("app", ConstantData.app);

            switch (i) {
                case 0:
                    capabilities.setCapability("deviceName", "Samsung Galaxy S23 Ultra");
                    capabilities.setCapability("platformVersion", "13.0");
                    break;
                case 1:
                    capabilities.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
                    capabilities.setCapability("platformVersion", "12.0");
                    break;
            }

            try {
                AppiumDriver driver = new AppiumDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub",
                        userName, accessKey)), capabilities);
                driverInstances.add(driver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void quitDrivers() {
        if (instance != null && instance.driverInstances != null) {
            for (AppiumDriver driver : instance.driverInstances)
                driver.quit();
        }
    }
}