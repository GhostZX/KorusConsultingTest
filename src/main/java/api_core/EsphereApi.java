package api_core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static api_constants.EsphereRestConstants.*;
import static org.hamcrest.Matchers.lessThan;

public class EsphereApi {

    private EsphereApi() {
    }

    private Map<String, String> params = new HashMap<>();

    public static class ApiBuilder {
        EsphereApi esphereApi;

        ApiBuilder(EsphereApi esphere) {
            esphereApi = esphere;
        }

        public ApiBuilder innOgrn(String innOgrn, String innParameter) {
            esphereApi.params.put(INN_OGRN, INN_PARAMETER);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .queryParams(esphereApi.params)
                    .log().all()
                    .get(URL).prettyPeek();
        }
    }

    public static ApiBuilder with() {
        EsphereApi api = new EsphereApi();
        return new ApiBuilder(api);
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader(CONNECTION, KEEP_ALIVE)
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .addQueryParam(INN_PARAMETER)
                .setBaseUri(URI)
                .build();
    }
}
