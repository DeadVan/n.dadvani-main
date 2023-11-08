import BaseDir.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import static BaseDir.SettingsReader.timerValue;

public class UserinyerfaceTest extends BaseTest {

    @Test(testName = "Opening main page,game,herebutton",priority = 1)
    public static void mainPageTest()
    {
        loginPage.clickHereButton();
        Assert.assertTrue(registrationPage.gamePageIsLoaded(),"game was not opened");
        registrationPage.pressHELPbutton();
        Assert.assertTrue(registrationPage.helpResponseIsOpened(),"help response is not displayed");
    }


    @Test(testName = "checkIfTimer starts correctly",priority = 2)
    public static void timerTest()
    {
        loginPage.clickHereButton();

        Assert.assertEquals(registrationPage.checkTimer(), timerValue);
    }

    @Test(testName = "Fill pasword,email and go next page",dataProvider = "passwords",dataProviderClass = RandomUtils.class,priority = 3)
    public static void registrationWithDataProvider(String passwords)
    {
        loginPage.clickHereButton();

        registrationPage.fillPasword(passwords);
        registrationPage.fillEmailFirtsHalf();
        registrationPage.fillEmailSecondsHalf();
        registrationPage.clickTearDown();
        registrationPage.chooseEmail();
        registrationPage.checkTermsAndConditions();
        registrationPage.clickNextBtn();
        Assert.assertTrue(registrationPage.profilePageIsLoaded(),"registration form was filled incorectly");
        registrationPage.navigateBackToRegistrationForm();
    }
    @Test(testName = "Fil registration form with wrong password",priority = 4)
    public static void wrongRegistration(){
        loginPage.clickHereButton();

        registrationPage.fillWrongPasword();
        registrationPage.fillEmailFirtsHalf();
        registrationPage.fillEmailSecondsHalf();
        registrationPage.clickTearDown();
        registrationPage.chooseEmail();
        registrationPage.checkTermsAndConditions();
        registrationPage.clickNextBtn();
        Assert.assertTrue(registrationPage.profilePageIsLoaded(),"registration form was filled incorectly");
    }
}
