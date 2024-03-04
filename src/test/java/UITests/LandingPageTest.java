package UITests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LandingPageTest extends BaseTest {
    LandingPage landingPage;

    @Test(dataProvider = "getData")
    public void verifyUserLogin(HashMap<String,String> input){
        landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userName"),input.get("password"));
        Assert.assertTrue(landingPage.verifyLogin());
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//main//java//data//data.json");

        return new Object[][]{{data.get(0)}};
    }
}
