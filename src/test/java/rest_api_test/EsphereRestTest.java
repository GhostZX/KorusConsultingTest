package rest_api_test;

import api_core.EsphereApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;

import static api_constants.EsphereRestConstants.*;

@Features({"REST Test Suite"})
@Stories({"\"Esphere REST\" tests"})
public class EsphereRestTest {

    @Step("Check Request of INN and meeting request configuration and specification")
    @Test
    public void makeRequestInn() {
        EsphereApi.with()
                .inn(INN_OGRN, INN_PARAMETER)
                .callApi();
        RestAssured
                .given(EsphereApi.baseRequestConfiguration())
                .param(INN_OGRN, INN_PARAMETER)
                .get().prettyPeek()
                .then().specification(EsphereApi.successResponse());
    }

    @Step("Check Request of OGRN and meeting request configuration and specification")
    @Test
    public void makeRequestOgrn() {
        EsphereApi.with()
                .ogrn(INN_OGRN, OGRN_PARAMETER)
                .callApi();
        RestAssured
                .given(EsphereApi.baseRequestConfiguration())
                .param(INN_OGRN, OGRN_PARAMETER)
                .get().prettyPeek()
                .then().specification(EsphereApi.successResponse());
    }
}
