package basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import pages.CartPage;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Wait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new FluentWait(driver);
        PageFactory.initElements(driver,this);
    }

    public void waitVisibility(WebElement element) {
        wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void writeIntoField(WebElement element, String text) {
        waitVisibility(element);
        element.sendKeys(text);
    }

    public void click(WebElement element) {
        waitVisibility(element);
        element.click();
    }

    public void dropDownOptions(WebElement element, String text){
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }
}
