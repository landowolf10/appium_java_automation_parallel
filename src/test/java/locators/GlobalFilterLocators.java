package locators;

public class GlobalFilterLocators {
    public static String selectAllFields = "//android.view.ViewGroup[3]/android.widget.ScrollView/android.view." +
            "ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup";
    public static String selectAllFieldsIOS = "select-all";
    public static String applySelectionButton = "//*[@text='Apply selection' or @label='Apply selection']";
    public static String searchTextBox = "(//*[contains(@text, 'Search') or contains(@label, 'Search')])[last()]";
    public static String parentElementIOS = "//XCUIElementTypeScrollView";
    public static String parentElementInviteIOS = "(//XCUIElementTypeScrollView)[2]";
    public static String parentElementAndroid = "//android.view.ViewGroup/android.view.ViewGroup/android.widget." +
            "ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView";
}