package org.qa.framework.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.manager.SeleniumManager;

@Slf4j
public class BaseClass {
    WebDriver webdriver;

    public WebDriver getDriver(String browser) {
        log.info("Running on Browser {}",browser);
        switch (browser.toUpperCase()) {
            case "CHROME" -> {
                SeleniumManager.getInstance();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                webdriver = new ChromeDriver(chromeOptions);
                log.info("Chrome Driver Initialized.");
            }
            case "FIREFOX" -> {
                SeleniumManager.getInstance();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                webdriver = new FirefoxDriver(firefoxOptions);
                log.info("Firefox Driver Initialized.");
            }
            case "EDGE" -> {
                SeleniumManager.getInstance();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                webdriver = new EdgeDriver(edgeOptions);
                log.info("Edge Driver Initialized.");
            }
            default -> log.error("Invalid Browser --> Config doesn't exist");
        }
        return webdriver;
    }
}
