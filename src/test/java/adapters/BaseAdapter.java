package adapters;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseAdapter {
    String BASE_URL = "https://api.qase.io/";

    public void post(String body, String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "e1edd1c70b24bb7b075c1c2ac5ab4007678fe4af").
                body(body).
        when().
                post(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public Response post(String body, String uri, int expectedStatusCode) {
        return given().
                header("Content-Type", "application/json").
                header("Token", "e1edd1c70b24bb7b075c1c2ac5ab4007678fe4af").
                body(body).
        when().
                post(BASE_URL + uri).
        then().
                log().all().
                statusCode(expectedStatusCode).extract().response();
    }

    public void del(String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "e1edd1c70b24bb7b075c1c2ac5ab4007678fe4af").
        when().
                delete(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public String g(String uri) {
        String body =
                given().
                        header("Content-Type", "application/json").
                        header("Token", "e1edd1c70b24bb7b075c1c2ac5ab4007678fe4af").
                when().
                        get(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(200).
                        extract().body().asString();
        return body;
    }
}