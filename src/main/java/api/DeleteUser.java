package api;

import data.DataCreation;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteUser {
    String userId = creatingUserForDeleting();

    public String creatingUserForDeleting() {
        JSONObject request = new JSONObject();
        request.put("name", DataCreation.fakeFullName());
        request.put("email", DataCreation.randomEmail());
        request.put("gender", "male");
        request.put("status", "active");

        ExtractableResponse<Response> extract = given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .extract();
        return extract.body().jsonPath().get("id").toString();
    }

    public void deleteUser() {
        when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204);
    }
}
