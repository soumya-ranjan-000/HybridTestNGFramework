package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CustomRandom;

public class Register extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }

    @Test
    public void verifyRegisterFunctionalityWithCorrectData() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(CustomRandom.generateFirstName());
        driver.findElement(By.id("input-lastname")).sendKeys(CustomRandom.generateLastName());
        driver.findElement(By.id("input-email")).sendKeys(CustomRandom.generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.id("input-confirm")).sendKeys(pass);
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
    }

    @Test
    public void registerAnAccountWithYesOptionIsSelectedForNewsletterField() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(CustomRandom.generateFirstName());
        driver.findElement(By.id("input-lastname")).sendKeys(CustomRandom.generateLastName());
        driver.findElement(By.id("input-email")).sendKeys(CustomRandom.generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.id("input-confirm")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@name='newsletter' and @value = '1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Yes ']/input")).isSelected());
    }

    @Test
    public void registerAnAccountWithNoOptionIsSelectedForNewsletterField() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys(CustomRandom.generateFirstName());
        driver.findElement(By.id("input-lastname")).sendKeys(CustomRandom.generateLastName());
        driver.findElement(By.id("input-email")).sendKeys(CustomRandom.generateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys(CustomRandom.generatePhoneNumber());
        String pass = CustomRandom.generatePassword();
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.id("input-confirm")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@name='newsletter' and @value = '0']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='No']/input")).isSelected());
    }

    @AfterMethod
    void tearDown() {
        quitDriver();
    }
}
