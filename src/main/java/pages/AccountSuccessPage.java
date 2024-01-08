package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

    private WebDriver driver;

    public AccountSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement accountGotCreatedInfo;

    @FindBy(linkText = "Continue")
    WebElement continueButton;


    public boolean isAccountGotCreatedInfoDisplayed() {
        try {
            return accountGotCreatedInfo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnContinueButton() {
        this.continueButton.click();
    }
}
