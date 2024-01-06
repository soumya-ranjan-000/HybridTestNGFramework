package com.soumya.qa.base;

import com.soumya.qa.drivers.DriverFactory;
import com.soumya.qa.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {
    WebDriver driver;
    DriverManager manager;
    public Properties prop;
    public Properties dataProp;

    public Base() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\config\\config.properties");

        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\testdata\\testdata.properties");

        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);
        }catch(Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }catch(Throwable e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowser(String browserName) {
        switch (browserName){
            case "chrome":
                manager = DriverFactory.valueOf("CHROME").getDriverManager();
                driver =manager.getDriver();
                break;
            case "firefox":
                manager = DriverFactory.valueOf("FIREFOX").getDriverManager();
                driver = manager.getDriver();
                break;
            case "edge":
                manager = DriverFactory.valueOf("MICROSOFT_EDGE").getDriverManager();
                driver = manager.getDriver();
                break;
            default:
                System.out.println("Given browser not present.");
        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
            return driver;
        }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
        driver = this.initializeBrowser(browserName);
        driver.get(prop.getProperty("url"));
        return driver;
    }

    public void quitDriver() {
        manager.quitDriver();
    }
}
