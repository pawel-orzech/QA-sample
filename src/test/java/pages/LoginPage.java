package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(id = "loginbutton")
    WebElement loginButton;

    @FindBy(id = "header_block")
    WebElement wrongPassHeaderBlock;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement incorrectDataValidator;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https:/facebook.com");
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        email.sendKeys(username);
    }

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void waitForWrongPassPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 1000);
        webDriverWait.until(ExpectedConditions.visibilityOf(wrongPassHeaderBlock));
    }

    public String getIncorrectDataValidatorMessage(){
        return incorrectDataValidator.getText();
    }

}
