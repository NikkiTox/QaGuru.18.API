package demowebshop;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemowebShopHW {
String cheapCookie = "ARRAffinity=92eb765899e80d8de4d490df907547e5cb10de899e8b754a4d5fa1a7122fad69; Nop.customer=9301b523-75d5-4c93-b8c8-90515d088f54";
String expensiveCookie = "ARRAffinity=92eb765899e80d8de4d490df907547e5cb10de899e8b754a4d5fa1a7122fad69; Nop.customer=7b3ce392-adfa-4364-8594-8eac14f70494";
String response = "";
    @Test
    void addCheapPCTest(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cheapCookie)
                .body("product_attribute_72_5_18=53" +
                        "&product_attribute_72_6_19=54" +
                        "&product_attribute_72_3_20=57" +
                        "&addtocart_72.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .extract().response().asString();
        System.out.println(response);
    }
    @Test
    void addExpensivePCTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(expensiveCookie)
                .body("product_attribute_72_5_18=65" +
                        "&product_attribute_72_6_19=91" +
                        "&product_attribute_72_3_20=58" +
                        "&addtocart_72.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .extract().response().asString();
        System.out.println(response);
    }
}
