package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "input-email")
    private WebElement emailAddressField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
    private WebElement notFoundAnyEmailAddressOrPasswordWarning;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAddress(String email) {
        emailAddressField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public boolean isNotFoundAnyEmailAddressOrPasswordWarningDisplayed() {
        try {
            return notFoundAnyEmailAddressOrPasswordWarning.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
