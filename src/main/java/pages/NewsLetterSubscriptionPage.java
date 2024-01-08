package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterSubscriptionPage {
    WebDriver driver;

    @FindBy(xpath = "//label[text()='Yes ']/input")
    WebElement yesToNewLetterRadioButton;

    @FindBy(xpath = "//label[text()='No']/input")
    WebElement noToNewLetterRadioButton;

    public NewsLetterSubscriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isYesToNewLetterRadioButtonSelected() {
        return yesToNewLetterRadioButton.isSelected();
    }

    public boolean isNoToNewLetterRadioButtonSelected() {
        return noToNewLetterRadioButton.isSelected();
    }
}
