package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.CustomRandom;

public class Register extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.selectRegisterOptions();
    }

    @Test
    public void verifyRegisterFunctionalityWithCorrectData() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(CustomRandom.generateFirstName());
        registerPage.enterLastName(CustomRandom.generateLastName());
        registerPage.enterEmail(CustomRandom.generateEmail());
        registerPage.enterTelephone(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        registerPage.enterPassword(pass);
        registerPage.enterConfirmPassword(pass);
        registerPage.selectNewsLetterOption("yes");
        registerPage.acceptTermsAndCondition();
        registerPage.clickOnContinueButton();
        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
        Assert.assertTrue(accountSuccessPage.isAccountGotCreatedInfoDisplayed());
    }

    @Test
    public void registerAnAccountWithYesOptionIsSelectedForNewsletterField() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(CustomRandom.generateFirstName());
        registerPage.enterLastName(CustomRandom.generateLastName());
        registerPage.enterEmail(CustomRandom.generateEmail());
        registerPage.enterTelephone(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        registerPage.enterPassword(pass);
        registerPage.enterConfirmPassword(pass);
        registerPage.selectNewsLetterOption("yes");
        registerPage.acceptTermsAndCondition();
        registerPage.clickOnContinueButton();
        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
        Assert.assertTrue(accountSuccessPage.isAccountGotCreatedInfoDisplayed());
        accountSuccessPage.clickOnContinueButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnSubUnsubNewsletterLink();
        NewsLetterSubscriptionPage newsLetterSubscriptionPage = new NewsLetterSubscriptionPage(driver);
        Assert.assertTrue(newsLetterSubscriptionPage.isYesToNewLetterRadioButtonSelected());
    }

    @Test
    public void registerAnAccountWithNoOptionIsSelectedForNewsletterField() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(CustomRandom.generateFirstName());
        registerPage.enterLastName(CustomRandom.generateLastName());
        registerPage.enterEmail(CustomRandom.generateEmail());
        registerPage.enterTelephone(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        registerPage.enterPassword(pass);
        registerPage.enterConfirmPassword(pass);
        registerPage.selectNewsLetterOption("no");
        registerPage.acceptTermsAndCondition();
        registerPage.clickOnContinueButton();
        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
        Assert.assertTrue(accountSuccessPage.isAccountGotCreatedInfoDisplayed());
        accountSuccessPage.clickOnContinueButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnSubUnsubNewsletterLink();
        NewsLetterSubscriptionPage newsLetterSubscriptionPage = new NewsLetterSubscriptionPage(driver);
        Assert.assertTrue(newsLetterSubscriptionPage.isNoToNewLetterRadioButtonSelected());
    }

    @AfterMethod
    void tearDown() {
        quitDriver();
    }
}
