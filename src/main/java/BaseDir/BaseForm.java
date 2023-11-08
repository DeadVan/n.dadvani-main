package BaseDir;// All Test Pages are inheriting from this class

import BaseDir.Elements.BaseElement;
import org.openqa.selenium.*;

public abstract class BaseForm {
    protected WebDriver driver;
    BaseElement uniqueFormLocator;
    String formName;
    public BaseForm(BaseElement locator, String name,WebDriver driver){
        uniqueFormLocator = locator;
        formName = name;
        this.driver = driver;


    }
    public String getFormLabel() {
        return driver.getTitle() + ".  {{}} unique Locator is -  " + formName;
    }

    public boolean isFormOpen() {
        try {
            WaitUtils.waitForPresenceOfElement(uniqueFormLocator.getLocator());
            return uniqueFormLocator.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
       }
    }
}