package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "input-firstname")
    WebElement firstnameInputBox;

    @FindBy(id = "input-lastname")
    WebElement lastNameInputBox;

    @FindBy(id = "input-email")
    WebElement emailInputBox;

    @FindBy(id = "input-telephone")
    WebElement telephoneInputBox;

    @FindBy(id = "input-password")
    WebElement passwordInputBox;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordInputBox;

    @FindBy(xpath = "//input[@name='newsletter' and @value = '1']")
    WebElement yesToNewLetterRadioButton;

    @FindBy(xpath = "//input[@name='newsletter' and @value = '0']")
    WebElement noToNewLetterRadioButton;

    @FindBy(name = "agree")
    WebElement agreeToTermsAndConditionsCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String name) {
        firstnameInputBox.sendKeys(name);
    }

    public void enterLastName(String name) {
        lastNameInputBox.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInputBox.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneInputBox.sendKeys(telephone);
    }

    public void enterPassword(String pass) {
        passwordInputBox.sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        confirmPasswordInputBox.sendKeys(pass);
    }

    public void selectNewsLetterOption(String option) {
        if (option.equalsIgnoreCase("yes")) yesToNewLetterRadioButton.click();
        else noToNewLetterRadioButton.click();
    }

    public void acceptTermsAndCondition() {
        agreeToTermsAndConditionsCheckbox.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
