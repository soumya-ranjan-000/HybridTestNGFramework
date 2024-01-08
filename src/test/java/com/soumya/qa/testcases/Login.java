package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Utilities;

import java.util.Date;

@Test
public class Login extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }

    @Test(dataProvider = "supplyTestData")
    public void verifyLoginWithValidCredentials(String email, String password) {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        /* get valid email and password from properties file */
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));

        /* get valid email and password from data provider */
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @Test
    public void verifyLoginWithInvalidCredentials() {
        long currentTime = new Date().getTime();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("xyzabc" + currentTime + "@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(), "Expected Warning msg not displayed");
    }

    @Test
    public void verifyLoginWithInvalidEmailAndPassword() {
        long currentTime = new Date().getTime();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("xyzabc" + currentTime + "@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(), "Expected Warning msg not displayed");
    }

    @Test
    public void verifyLoginWithValidEmailIdAndInvalidPassword() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("amotoori3@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(), "Expected Warning msg not displayed");
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
