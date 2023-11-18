package locators;

public class HomeLocators {
    public static String homeTab = "//*[@text='Home' or @label='Home']";
    public static String inviteIcon = "//*[@text='Invite' or @label='Invite']";
    public static String nextButton = "//*[@text='Next' or @label='Next']";

    public static String logOutBtn = "//*[@text='Log out' or @label='Log out']";
    public static String yesLeaveBtn = "(//*[contains(@text,'Yes, leave') or contains(@label,'Yes, leave')])[last()]";
    public static String cancelBtn = "(//*[contains(@text,'Cancel') or contains(@label,'Cancel')])[last()]";
    public static String hubButton = "//android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android." +
            "view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]";
    public static String growerHubButton = "//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[5]/android.view.ViewGroup";
    public static String grower3HubButton = "//android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget." +
            "FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]";
    public static String salesRepHubButton = "//android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget." +
            "FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]";
    public static String agronomistHubButton = "//android.view.ViewGroup/android.view.ViewGroup/android.view." +
            "ViewGroup[5]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view." +
            "ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/" +
            "android.view.ViewGroup[2]/android.view.ViewGroup[2]";
    public static String acceptButton = "//*[@text='Accept' or @label='Accept']";
    public static String okButton = "//*[@text='Ok' or @label='Ok']";
    public static String saveButton = "//*[@text='Save' or @label='Save']";
    public static String confirmButton = "//*[@text='Confirm' or @label='Confirm']";
    public static String invalidCredentials = "//*[@text='Incorrect credentials.' or @label='Incorrect credentials.']";
}