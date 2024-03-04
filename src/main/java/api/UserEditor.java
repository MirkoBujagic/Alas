package api;

import data.DataCreation;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class UserEditor {

    public String creatingUserForEdit() {
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

    public void editUser() {
        JSONObject request = new JSONObject();
        request.put("gender", "female");

        String userId = creatingUserForEdit();
        given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString()).log().all()
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .log().all();
    }
}

