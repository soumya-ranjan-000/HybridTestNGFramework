package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utilities;

import java.util.Date;

@Test
public class Login extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.selectLoginOptions();
    }

    @Test(dataProvider = "supplyTestData")
    public void verifyLoginWithValidCredentials(String email, String password) {

        /* get valid email and password from properties file */
        //  driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        //  driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        /**/

        /* get valid email and password from data provider */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.isEditYourAccountInformationLinkDisplayed());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {
        long currentTime = new Date().getTime();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress("xyzabc" + currentTime + "@gmail.com");
        loginPage.enterPassword("xyzabc123");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isNotFoundAnyEmailAddressOrPasswordWarningDisplayed(), "Expected Warning msg not displayed");
    }

    @Test
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        long currentTime = new Date().getTime();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress("xyzabc" + currentTime + "@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isNotFoundAnyEmailAddressOrPasswordWarningDisplayed(), "Expected Warning msg not displayed");
    }

    @Test
    public void verifyLoginWithValidEmailIdAndInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress("amotoori3@gmail.com");
        loginPage.enterPassword("xyzabc123");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.isNotFoundAnyEmailAddressOrPasswordWarningDisplayed(), "Expected Warning msg not displayed");
    }

    @AfterMethod
    void tearDown() {
        quitDriver();
    }

    @DataProvider
    public Object[][] supplyTestData() {
        Object[][] data = Utilities.getTestDataFromExcel("Login");
        return data;
    }
}
