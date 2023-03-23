package org.qa.framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waits {

    public static void implicitWait(WebDriver driver, long duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(duration));
    }

    public static void explicitWaitByVisiblity(WebDriver driver, WebElement element, long duration){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(duration));
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void explicitWaitByVisiblityLocated(WebDriver driver, By locator, long duration){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(duration));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
