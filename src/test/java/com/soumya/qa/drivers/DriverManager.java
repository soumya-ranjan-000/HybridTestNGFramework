package com.soumya.qa.drivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }
        return drivers.get();
    }

    public void quitDriver() {
        if (null != drivers.get()) {
            try {
                drivers.get().quit(); // First quit WebDriver session gracefully
                drivers.remove(); // Remove WebDriver reference from the ThreadLocal variable.
            } catch (Exception e) {
                System.err.println("Unable to gracefully quit WebDriver."+ e); // We'll replace this with actual Loggers later - don't worry !
            }
        }
    }
}
