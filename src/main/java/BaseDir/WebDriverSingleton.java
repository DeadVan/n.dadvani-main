package BaseDir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static BaseDir.SettingsReader.waitTime;

public class WebDriverSingleton {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static WebDriverSingleton instance;
    private static  WebDriver driver1;

    private WebDriverSingleton() {
    }

    public static WebDriverSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }
    public WebDriver getDriver(String browserName) {
        if (driver.get() == null) {
            driver.set(BrowserFactory.createDriver(browserName));
        }
        return driver.get();
    }
    public static WebDriver getDriverifNull() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver1 = new ChromeDriver();
            driver1.manage().window().maximize();
            driver1.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        }
        return driver.get();
    }

    public static WebDriver getCurrentDriver() {
        return driver.get();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}


