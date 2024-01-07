package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Date;

@Test
public class Login extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = initializeBrowserAndOpenApplicationURL("chrome");
    }

    @Test
    public void verifyLoginWithValidCredentials(){
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("rakiraja7751841655@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("soumya@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @Test
    public void verifyLoginWithInvalidCredentials(){
        long currentTime = new Date().getTime();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("xyzabc"+currentTime+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(),"Expected Warning msg not displayed" );
    }

    @Test
    public void verifyLoginWithInvalidEmailAndPassword(){
        long currentTime = new Date().getTime();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("xyzabc"+currentTime+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(),"Expected Warning msg not displayed" );
    }

    @Test
    public void verifyLoginWithValidEmailIdAndInvalidPassword(){
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("amotoori3@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).
                isDisplayed(),"Expected Warning msg not displayed" );
    }

    @AfterMethod
    void tearDown(){
        quitDriver();
    }
}
