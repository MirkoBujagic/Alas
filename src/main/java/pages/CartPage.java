package pages;

import basePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".shopping_cart_container")
    WebElement cartBadge;
    @FindBy(xpath = "//button[text()='Remove']")
    WebElement removeButton;
    @FindBy(xpath = "//div[@class='cart_item_label']")
    List<WebElement> products;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    int cartNum = Integer.parseInt(cartBadge.getText());

    public void navigateToCart() {
        click(cartBadge);
    }

    public boolean productAmountVerification() {
        return cartNum == products.size();
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }

    public void removeItem() {
        click(removeButton);
    }

    public boolean productConfirming(String name) {
        if (products.size() == 1 && products.get(0).getText().contains(name)) {
            System.out.println("One product is present");
            System.out.println("The right product is in the cart");
        } else {
            return false;
        }
        return true;
    }

    public void navigateToCheckout(){
        click(checkoutButton);
    }
}
