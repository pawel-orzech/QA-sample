package test;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginTest {


    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver",Configuration.CHROME_LOCATION);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void positiveRegister(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName("John");
        registerPage.setLastName("Snow");
        registerPage.setEmail("john.snow@0011.pl");
        registerPage.setEmailConfirmation("john.snow@0011.pl");
        registerPage.setPassword("Westeros123");
        registerPage.setBirthdayDay("10");
        registerPage.setBirthdayMonth("lip");
        registerPage.setBirthdayYear("1950");
        registerPage.setOtherGender();
        registerPage.setPreferredPronoun(2);
        registerPage.setCustomGender("Night's Watch");
        registerPage.clickRegisterButton();

    }


    @Test
    public void negativeLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(Configuration.WRONG_EMAIL);
        loginPage.setPassword(Configuration.WRONG_PASSWORD);
        loginPage.clickLoginButton();
        loginPage.waitForWrongPassPage();
        Assert.assertEquals(loginPage.getIncorrectDataValidatorMessage(),"Wprowadzony adres e-mail nie pasuje do żadnego konta.");
    }
}
