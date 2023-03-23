package org.qa.framework.helper;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class WebHelper {
    private WebDriver driver;
    private JavascriptExecutor js;

    public WebHelper(WebDriver driver){
        this.driver = driver;
    }

    /**
     * element click using js executor
     *
     * @param ele - WebElement
     */
    public void jsClick(WebElement ele) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ele);

    }

    /**
     * set attribute using js executor
     *
     * @param element - WebElement
     * @param attribute - Property Attribute
     * @param value - Attribute Value
     */
    public void jsSetAttribute(WebElement element, String value, String attribute) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attribute, value);
    }

    /**
     * take screenshot
     *
     */
    public void takeScreenshot() {
        File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(scrnFile, new File(currentDir + "/screenshots" + formatTimeSDF() + ".png"));
        } catch (IOException e) {
            log.error("Exception in takeScreenshot method: " + e.getMessage());
        }
    }

    /**
     * take screenshot and name file with test name + time stamp
     *
     * @param testName - Test Name
     */
    public void takeScreenshot(String testName) {
        File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.copyFile(scrnFile,
                    new File(currentDir + "/screenshots/" + testName + "_" + formatTimeSDF() + ".png"));
        } catch (IOException e) {
            log.error("Exception in takeScreenshot method: " + e.getMessage());
        }
    }

    /**
     * format date/time
     *
     * @return - String
     */
    public static String formatTimeSDF() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    /**
     * Mouse Hover Main Menu
     *
     * @param element- WebElement
     */
    public void mouseHover(WebElement element){
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /**
     * Mouse Hover and Click
     *
     * @param element- WebElement
     */
    public void mouseHoverandClick(WebElement element){
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.click().build().perform();
    }
}
