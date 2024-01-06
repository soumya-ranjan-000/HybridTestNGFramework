package com.soumya.qa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FireFoxDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        System.out.println("Initializing FireFox Driver"); // Change to Loggers
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(getFireFoxOptions());
    }

    private FirefoxOptions getFireFoxOptions() {
        // A few valid Options for Chrome, showcase purpose.
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
        return options;
    }
}
