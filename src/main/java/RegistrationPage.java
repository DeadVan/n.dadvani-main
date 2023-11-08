import BaseDir.BaseForm;
import BaseDir.LogUtils;
import BaseDir.Elements.Button;
import BaseDir.Elements.Checkbox;
import BaseDir.Elements.TextBox;
import BaseDir.Elements.Label;
import BaseDir.RandomUtils;
import org.openqa.selenium.*;

public class RegistrationPage extends BaseForm {

    public RegistrationPage(WebDriver driver) {
        super(new Label(By.xpath("//div[contains(@class,'login-form')]")), "LoginBar", driver);
    }

    private Label loginBar = new Label(By.xpath("//div[contains(@class,'login-form')]"));
    private Button helpButton = new Button(By.xpath("//a[contains(@class,'help-form__help-button')]"));
    private Label helpResponse = new Label(By.xpath("//div[contains(@class,'help-form__response')]"));
    private Label timer = new Label(By.xpath("//div[contains(@class,'timer timer--white timer--center')]"));
    private TextBox password = new TextBox(By.xpath("//input[contains(@placeholder,'Choose Password')]"));
    private TextBox emailFirtsHalf = new TextBox(By.xpath("//input[contains(@placeholder,'Your email')]"));
    private TextBox emailSecondHalf = new TextBox(By.xpath("//input[contains(@placeholder,'Domain')]"));
    private Button tearDownButton = new Button(By.xpath("//span[contains(@class,'icon icon-chevron-down')]"));
    private Button orgButton = new Button(By.xpath("//div[contains(normalize-space(),'.org')]"));
    private Checkbox termsAndCondition = new Checkbox(By.xpath("//span[contains(@class,'checkbox__box')]"));
    private Button nextButton = new Button(By.xpath("//a[contains(@class,'button--secondary')]"));
    private Label avatar = new Label(By.xpath("//div[contains(@class,'avatar-and-interests__avatar-box')]"));
    private Button cancel = new Button(By.xpath("//button[contains(normalize-space(),'Cancel')]"));


    public boolean gamePageIsLoaded()
    {
        LogUtils.info("checking if LoginBar is displayed");
        return loginBar.isDisplayed();
    }

    public void pressHELPbutton()
    {
        LogUtils.info("Clicking HELP button");
        helpButton.click();
    }

    public boolean helpResponseIsOpened()
    {
        LogUtils.info("checking if helpResponse is displayed");
        return helpResponse.isDisplayed();
    }

    public String checkTimer()
    {
        LogUtils.info("checking timer");
        return timer.getText();
    }

    public void fillPasword(String passwords){
        LogUtils.info("password filling");
        password.setText(passwords);
    }


    public void fillEmailFirtsHalf(){
        LogUtils.info("filling Email first half");
        emailFirtsHalf.setText(RandomUtils.generateString(5,0,0)+"G");
    }
    public void fillEmailSecondsHalf(){
        LogUtils.info("filling Email second half ");
        emailSecondHalf.setText(RandomUtils.generateString(7,0,1)+"G");
    }
    public void clickTearDown()
    {
        LogUtils.info("clicking to see list");
        tearDownButton.click();
    }
    public void chooseEmail()
    {
        LogUtils.info("choosing .org");
        orgButton.waitClick();
    }
    public void checkTermsAndConditions(){
        LogUtils.info("checking terms and conditions but fr we unchecked ;)");
        termsAndCondition.check();
    }
    public void clickNextBtn()
    {
        LogUtils.info("Clicking next button");
        nextButton.waitClick();
    }
    public boolean profilePageIsLoaded()
    {
        LogUtils.info("checking if avatar is displayed");
        return avatar.isDisplayed();
    }

    public void navigateBackToRegistrationForm(){
        LogUtils.info("Clicking cancel button for navigate back to registration form");
        cancel.click();

    }
    public void fillWrongPasword(){
        LogUtils.info("wrong password filling");
        password.setText(RandomUtils.generateString(9,0,0)+ "G");
    }
}
