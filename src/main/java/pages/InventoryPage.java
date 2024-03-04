package pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".inventory_item")
    List<WebElement> products;
    @FindBy (xpath = ("//*[text()='Add to cart']"))
    WebElement addToCartButton;

    By productName = By.cssSelector(".inventory_item_name ");
    By addToCart = By.cssSelector(".btn");

    public WebElement getProductByName(String name) {
        WebElement prod = products.stream().filter(product -> product.findElement(productName)
                        .getText().contains(name))
                .findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        click(prod.findElement(addToCart));
    }

    public void openProductDetails(String name) {
        WebElement product = getProductByName(name);
        click(product.findElement(productName));
    }

    public void addProductFromDetailsPage(){
        click(addToCartButton);
    }

    public boolean productVerification(String product1, String product2){
                List<WebElement> itemList = driver.findElements(productName);

                for (WebElement item : itemList) {
                    String itemName = item.getText();

                    if (itemName.contains(product1) || itemName.contains(product2)) {
                        System.out.println("Item verification passed for: " + itemName);
                    } else {
                        System.out.println("Item verification failed for: " + itemName);
                        return false;
                    }
                }
                return true;
    }




}
