package org.qa.framework.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class HomePage {

    public WebDriver driver;

    @FindBy(xpath = "//img[@title='Kotak Mahindra Bank']")
    private WebElement homePageImage;

    @FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Explore Products']")
    private WebElement exploreProducts;

    @FindBy(xpath = "//li[@class='menu-sublinks-track active']//a[@class='header-overlay-id'][normalize-space()='Cards']")
    private WebElement cardMainMenu;

    @FindBy(xpath = "//li[@class='menu-link-track']//a[@class='header-overlay'][normalize-space()='Credit Cards']")
    private WebElement creditCardOption;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
