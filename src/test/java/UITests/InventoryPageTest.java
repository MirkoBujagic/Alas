package UITests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LandingPage;
import pages.InventoryPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class InventoryPageTest extends BaseTest {
    LandingPage landingPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test(dataProvider = "getData")
    public void verifyCartBadgeUpdate(HashMap<String, String> input) {
        landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userName"), input.get("password"));

        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(input.get("product1"));

        cartPage = new CartPage(driver);
        cartPage.navigateToCart();
        Assert.assertTrue(cartPage.productAmountVerification());
    }

    @Test(dataProvider = "getData")
    public void verifyAddedItems(HashMap<String, String> input) {
        landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userName"), input.get("password"));

        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(input.get("product1"));
        inventoryPage.openProductDetails(input.get("product2"));
        inventoryPage.addProductFromDetailsPage();

        cartPage = new CartPage(driver);
        cartPage.navigateToCart();
        Assert.assertTrue(inventoryPage.productVerification(input.get("product1"), input.get("product2")));
    }

    @Test(dataProvider = "getData")
    public void verifyItemPresent(HashMap<String,String> input){
        landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userName"), input.get("password"));

        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(input.get("product1"));
        inventoryPage.openProductDetails(input.get("product2"));
        inventoryPage.addProductFromDetailsPage();

        cartPage = new CartPage(driver);
        cartPage.navigateToCart();
        cartPage.removeItem();
        Assert.assertTrue(cartPage.productConfirming(input.get("product2")));
    }

    @Test(dataProvider = "getData")
    public void verifyCompletedOrder(HashMap<String,String> input){
        landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userName"), input.get("password"));

        inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(input.get("product1"));
        inventoryPage.openProductDetails(input.get("product2"));
        inventoryPage.addProductFromDetailsPage();

        cartPage = new CartPage(driver);
        cartPage.navigateToCart();
        cartPage.navigateToCheckout();

        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillFormFields(input.get("firstName"), input.get("lastName"), input.get("postalCode"));
        checkoutPage.continueWithForm();
        checkoutPage.finishingOrder();
        Assert.assertTrue(checkoutPage.verifyMessageText());
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//main//java//data//data.json");

        return new Object[][]{{data.get(0)}};
    }
}
