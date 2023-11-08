import BaseDir.LogUtils;
import BaseDir.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static BaseDir.SettingsReader.*;

public class BaseTest {
    static LoginPage loginPage;
    static RegistrationPage registrationPage;

    @BeforeMethod
    public void setup() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver(browser);
        driver.get(url);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        LogUtils.startTestCase(loginPage.getFormLabel());
        LogUtils.info("Max wait time if page is not loaded is " + waitTime + " SECONDS");
        if (loginPage.isFormOpen()) {
            LogUtils.info("Initialized " + browser + "Driver and maximized window");
        } else {
            LogUtils.info("Page didn't open");
        }
    }

    @AfterMethod
    public void cleanUp() {
        WebDriverSingleton.getInstance().closeDriver();
        LogUtils.endTestCase();
    }
}

