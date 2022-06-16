package tests.api;
import com.google.common.collect.Ordering;
import data.colors.DataColors;
import data.colors.ResourseColors;
import data.users.DataUser;
import data.LogIn;
import data.users.Resourse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.Service;

import java.util.List;

import static io.restassured.RestAssured.given;
import static specification.Specification.*;

public class Tests {

    @Test
    public void nameFileofAvatarTest() {
        Resourse resourse = given()
                .spec(requestSpec())
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().headers()
                .extract().body().as(Resourse.class);
        List<DataUser> dataUserList= resourse.getData();
        List<String> listOfNameFile = Service.getListOfNameFile(dataUserList);
        Assert.assertTrue(  Service.isUnique(listOfNameFile));
    }

    @Test()
    public void checkSuccessLogInTest(){
        LogIn logIn = new LogIn("eve.holt@reqres.in", "cityslicka");
        Response response = given()
                .spec(requestSpec())
                .body(logIn)
                .when()
                .post("/api/login")
                .then()
                .log().status()
                .spec(responseSpec200())
                .extract()
                .response();
    Assert.assertEquals(response.getStatusCode(), 200, "Вошли в систему успешно");
    }

    @Test()
    public void checkUnSuccessLogInTest(){
        LogIn logIn = new LogIn("eve.holt@reqres.in", "");
        Response response = given()
                .spec(requestSpec())
                .body(logIn)
                .when()
                .post("/api/login")
                .then()
                .log().body()
                .spec(responseSpec400())
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(), 400, "Не ввели пароль");
    }

    @Test
    public void sortedYearTest() {
        ResourseColors resourse = given()
                .spec(requestSpec())
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().headers()
                .extract().body().as(ResourseColors.class);
            List<DataColors> dataColorsList= resourse.getData();
            List<Integer> listOfYears = Service.getListOfYears(dataColorsList);
            Assert.assertTrue(Ordering.natural().isOrdered(listOfYears));
    }


}
