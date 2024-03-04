package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;
    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;

    public void loginApplication(String userName, String password) {
        writeIntoField(userNameField, userName);
        writeIntoField(passwordField, password);
        click(loginButton);
    }

    public boolean verifyLogin() {
        click(menuButton);
        waitVisibility(logoutButton);
        return logoutButton.isDisplayed();
    }
}
