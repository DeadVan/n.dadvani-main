package BaseDir;
import BaseDir.Elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static BaseDir.SettingsReader.waitTime;

public class WaitUtils {
    static WebDriverWait wait;
    public static void waitForElementToBeClickable(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForTextToBePresentInElement(BaseElement element,String expectedString) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), waitTime);
        wait.until(ExpectedConditions.textToBePresentInElement(element.toWebElement(),expectedString));
    }
    public static void waitForInvisibilityOfElementLocated(BaseElement element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), waitTime);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element.getLocator()));
    }


    public static void waitForPresenceOfElement(By element) {
        wait = new WebDriverWait(WebDriverSingleton.getCurrentDriver(), waitTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}

