package com.soumya.qa.testcases;

import com.soumya.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Login extends Base {

    WebDriver driver;

    @Test
    public  void verifyLoginWithValidCredentialsWithChrome() throws InterruptedException {
        driver = initializeBrowser("chrome");
        Thread.sleep(3000L);
        driver.get("http://tutorialsninja.com/demo/");
        Thread.sleep(3000L);
    }

    @Test
    public  void verifyLoginWithValidCredentialsWithFireFox() throws InterruptedException {
        driver = initializeBrowser("firefox");
        Thread.sleep(3000L);
        driver.get("http://tutorialsninja.com/demo/");
        Thread.sleep(3000L);
    }

    @Test
    public  void verifyLoginWithValidCredentialsWithEdge() throws InterruptedException {
        driver = initializeBrowser("edge");
        Thread.sleep(3000L);
        driver.get("http://tutorialsninja.com/demo/");
        Thread.sleep(3000L);
    }

    @AfterTest
    void tearDown(){
        quitDriver();
    }

}
