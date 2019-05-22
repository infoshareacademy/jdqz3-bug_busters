package prerequisites;

import dataModels.User;

import static com.jayway.restassured.RestAssured.given;

public class Preconditions {

    private final static String SHOP = "http://demo.shopizer.com:8080";
    private final static String REGISTER_RESOURCE = "/shop/customer/register.html";
    private final static String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";


    public void createUser(User user) {
        given()
                .formParam("billing.firstName", user.getFirstname())
                .formParam("billing.lastName", user.getLastname())
                .formParam("billing.country", "PL")
                .formParam("billing.stateProvince", user.getAddress().getState())
                .formParam("emailAddress", user.getEmail())
                .formParam("userName", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("checkPassword", user.getPassword())
                .contentType(FORM_CONTENT_TYPE)
        .when()
                .post(url(REGISTER_RESOURCE))
        .then()
                .statusCode(302);
    }

    private String url(String path) {
        return SHOP + path;
    }

}
