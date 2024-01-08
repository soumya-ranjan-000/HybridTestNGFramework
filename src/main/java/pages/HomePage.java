package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropDownMenu;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void clickOnMyAccount() {
        myAccountDropDownMenu.click();
    }

    public void selectLoginOptions() {
        loginButton.click();
    }

    public void selectRegisterOptions() {
        registerButton.click();
    }
}
