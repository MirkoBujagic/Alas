package api;

import data.DataCreation;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class UserCreator {
    public void creatingUser() {
        JSONObject request = new JSONObject();
        request.put("name", DataCreation.fakeFullName());
        request.put("email", DataCreation.randomEmail());
        request.put("gender", "male");
        request.put("status", "active");

        given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }


}
