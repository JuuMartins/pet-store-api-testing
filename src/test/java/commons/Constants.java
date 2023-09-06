package commons;

import io.restassured.http.ContentType;

public interface Constants {

    String APP_BASE_URL = "https://petstore.swagger.io/v2";
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
}