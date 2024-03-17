package com.soumya.qa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class ChromeLambdaTest extends DriverManager {

    public static String hubURL = "https://hub.lambdatest.com/wd/hub";

    @Override
    protected WebDriver createDriver() {
        System.out.println("Initializing Chrome Driver from lambda test"); // Change to Loggers
        return new RemoteWebDriver(Objects.requireNonNull(getUrl()), getChromeOptions());
    }

    private URL getUrl() {
        URL u;
        try {
            u = new URL(hubURL);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ChromeOptions getChromeOptions() {
        // A few valid Options for Chrome, showcase purpose.
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("122.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ashishbuwade31");
        ltOptions.put("accessKey", "oyEtI6OZkOpK6PkDp0bz8VpTOPOssMDabI2RFaIJjZYQi6keG9");
//        ltOptions.put("headless", true);
        ltOptions.put("seCdp", true);
        ltOptions.put("project", "HybridTestNGFramework");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        browserOptions.addArguments("--disable-notifications");
        browserOptions.addArguments("--start-maximized");
        browserOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
        browserOptions.addArguments("--disable-infobars");
        return browserOptions;
    }
}
