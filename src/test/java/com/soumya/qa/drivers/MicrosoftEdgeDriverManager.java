package com.soumya.qa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class MicrosoftEdgeDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        System.out.println("Initializing edge Driver"); // Change to Loggers
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(getEdgeOptions());
    }

    private EdgeOptions getEdgeOptions() {
        // A few valid Options for Chrome, showcase purpose.
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
        return options;
    }
}
