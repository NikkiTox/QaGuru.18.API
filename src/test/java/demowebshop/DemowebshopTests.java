package demowebshop;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemowebshopTests {
    String cookie = "Nop.customer=6d922143-df8d-4b22-96c5-f126959f1922; ARRAffinity=92eb765899e80d8de4d490df907547e5cb10de899e8b754a4d5fa1a7122fad69; __utma=78382081.1924337793.1654281243.1654281243.1654281243.1; __utmc=78382081; __utmz=78382081.1654281243.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmt=1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __atuvc=1%7C22; __atuvs=629a54201505a183000; __utmb=78382081.3.10.1654281243";
    String response = "";
    @Test
    void addToCartTest(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .body("product_attribute_72_5_18=53" +
                        "&product_attribute_72_6_19=54" +
                        "&product_attribute_72_3_20=57" +
                        "&addtocart_72.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .extract().response().asString();
        System.out.println(response);
    }
}
