package testScripts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.framework.base.BaseClass;
import org.qa.framework.helper.Waits;
import org.qa.framework.helper.WebHelper;
import org.qa.framework.pages.CreditCardPage;
import org.qa.framework.pages.HomePage;
import org.qa.framework.utilities.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Listener;
import java.util.List;

@Slf4j
@Listeners({Listener.class})
public class CommercialCardsUITest extends BaseClass {

    public CardsAPITest cardsAPITest = new CardsAPITest();
    public WebDriver driver;

    public WebHelper webHelper;

    @BeforeTest
    public void setUpBrowser() {
        CommonUtils.setEnv("qa");
        driver = getDriver(CommonUtils.getPropValue("browser"));
        log.info("Driver is Initialized !");
        driver.manage().window().maximize();
        driver.navigate().to(CommonUtils.getPropValue("url"));
        webHelper = new WebHelper(driver);
    }

    @Test(priority = 0,description = "Navigating to Commercial Card Page")
    public void navigateToCardsPage(){
        HomePage homePage = new HomePage(driver);
        Waits.explicitWaitByVisiblity(driver,homePage.getHomePageImage(),5000);
        Assert.assertTrue(homePage.getHomePageImage().isDisplayed());
        webHelper.mouseHover(homePage.getExploreProducts());
        Waits.implicitWait(driver,10000);
        webHelper.jsClick(homePage.getCreditCardOption());
    }

    @Test(priority = 1,description = "Validating number of Cards")
    public void selectCommercialCards(){
        CreditCardPage creditCardPage = new CreditCardPage(driver);
        creditCardPage.getCommercialTab().click();
        int totalItems = Integer.parseInt(driver.findElement(By.xpath("(//span[@class='min-item total-size'][text()='3'])[1]")).getText());
        List<WebElement> noOfCards = driver.findElements(By.xpath("//div[@class='cmp-item em form-card']"));
        Response response = cardsAPITest.getResponse();
        Assert.assertEquals(totalItems,Integer.parseInt(response.jsonPath().getString("originalSize")));
        Assert.assertEquals(Integer.parseInt(response.jsonPath().getString("currentSize")), noOfCards.size());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
