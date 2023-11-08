import BaseDir.BaseForm;
import BaseDir.LogUtils;
import BaseDir.WaitUtils;
import BaseDir.Elements.*;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BaseForm {
    public LoginPage(WebDriver driver) {
        super(new Label(By.xpath("//button[contains(@class,'start__button')]")), "NoButton",driver);
    }

    private Button hereBtn = new Button(By.xpath("//a[contains(@class,'start__link')]"));

    public void clickHereButton()
    {
        LogUtils.info("Clicking HERE button");
        hereBtn.click();
    }
}


