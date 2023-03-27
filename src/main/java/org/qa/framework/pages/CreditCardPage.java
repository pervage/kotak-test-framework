package org.qa.framework.pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class CreditCardPage {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='zcommercial']")
    private WebElement commercialTab;

    @FindBy(xpath = "//a[@id='travel']")
    private WebElement travelTab;

    @FindBy(xpath = "//a[@id='premium']")
    private WebElement premiumTab;

    public CreditCardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement selectCreditCard(String card){
        return driver.findElement(By.xpath("//div[@data-page-path='/content/kotakcl/en/personal-banking/cards/credit-cards/"+card+"']"));
    }
}
