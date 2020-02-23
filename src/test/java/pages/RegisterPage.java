package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;


    //Web elements definition

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "reg_email__")
    WebElement email;

    @FindBy(name = "reg_email_confirmation__")
    WebElement emailConfirmation;

    @FindBy(name = "reg_passwd__")
    WebElement password;

    @FindBy(name = "birthday_day")
    WebElement birthdayDay;

    @FindBy(name = "birthday_month")
    WebElement birthdayMonth;

    @FindBy(name = "birthday_year")
    WebElement birthdayYear;

    @FindBy(id = "u_0_a")
    WebElement maleGender;

    @FindBy(id = "u_0_9")
    WebElement femaleGender;

    @FindBy(id = "u_0_b")
    WebElement otherGender;

    @FindBy(name = "preferred_pronoun")
    WebElement preferredPronoun;

    @FindBy(name = "custom_gender")
    WebElement customGender;

    @FindBy(name = "websubmit")
    WebElement submitButton;


    //Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https:/facebook.com");
        PageFactory.initElements(driver, this);
    }

    //Values setters
    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setEmailConfirmation(String emailConfirmation) {
        this.emailConfirmation.sendKeys(emailConfirmation);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setBirthdayDay(String birthdayDay) {
        Select selectBirthDay = new Select(this.birthdayDay);
        selectBirthDay.selectByVisibleText(birthdayDay);
    }

    public void setBirthdayMonth(String birthdayMonth) {
        Select selectBirthMonth = new Select(this.birthdayMonth);
        selectBirthMonth.selectByVisibleText(birthdayMonth);
    }

    public void setBirthdayYear(String birthdayYear) {
        Select selectBirthYear = new Select(this.birthdayYear);
        selectBirthYear.selectByVisibleText(birthdayYear);
    }

    public void setMaleGender() {
        this.maleGender.click();
    }

    public void setFemaleGender() {
        this.femaleGender.click();
    }

    public void setOtherGender() {
        this.otherGender.click();
    }

    public void setPreferredPronoun(int option) {
        Select pronoun = new Select(preferredPronoun);

        switch (option) {
            case 1:
                pronoun.selectByIndex(1);
            case 2:
                pronoun.selectByIndex(2);
            case 3:
                pronoun.selectByIndex(3);
            default:
                pronoun.selectByIndex(1);
        }
    }

    public void setCustomGender(String gender) {
        this.customGender.sendKeys(gender);
    }

    public void clickRegisterButton() {
        this.submitButton.click();
    }

}
