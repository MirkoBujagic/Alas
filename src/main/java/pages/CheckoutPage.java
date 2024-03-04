package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(css = ".complete-header")
    WebElement orderMessage;

    public void fillFormFields(String firstName,String lastName,String postalCode){
        writeIntoField(firstNameField, firstName);
        writeIntoField(lastNameField, lastName);
        writeIntoField(postalCodeField, postalCode);
    }
    public void continueWithForm(){
        click(continueButton);
    }

    public void finishingOrder(){
        click(finishButton);
    }

    public boolean verifyMessageText(){
     return orderMessage.getText().equals("Thank you for your order!");
    }
}
