package BaseDir.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement{
    public TextBox(By locator) {
        super(locator);
    }
    public void setText(String text) {
        findElement().clear();
        findElement().sendKeys(text);
    }
}
