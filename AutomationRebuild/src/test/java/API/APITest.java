package API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.mapper.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;


public class APITest {
  @Test
  public void canCheckId2Email() { 	  
	  given().
	  	get("https://reqres.in/api/users/2").
	  then().
	  	statusCode(200).
	  	body("data.email", equalTo("janet.weaver@reqres.in"));
  }
  
  @Test
  public void canVerifyToken() { 
	  JSONObject request = new JSONObject();
	  request.put("email", "eve.holt@reqres.in");
	  request.put("password", "cityslicka");
	  
	  given().
	  	header("Content-Type","application/json").
	  	body(request.toJSONString()).
	  when().
	  	post("https://reqres.in/api/login").
	  then().
	  	statusCode(200).
	  	body("token", equalTo("QpwL5tke4Pnpja7X4"));
  }
  
  @Test
  public void canDelete() { 
	  given().
	  	delete("https://reqres.in/api/users/2").
	  then().
	  	statusCode(204).
	  	log().status();
  }
  @Test
  public void canPatch() { 
	  JSONObject request = new JSONObject();
	  request.put("name", "morpheus2");
	  request.put("job", "zion resident");
	  
	  given().
	  	header("Content-Type","application/json").
	  	body(request.toJSONString()).
	  when().
	  	patch("https://reqres.in/api/users/2").
	  then().
	  	statusCode(200).
	  	log().body();
  }
  @Test
  public void canPut() { 
	  JSONObject request = new JSONObject();
	  request.put("name", "morpheus2");
	  request.put("job", "zion resident");
	  
	  given().
	  	header("Content-Type","application/json").
	  	body(request.toJSONString()).
	  when().
	  	put("https://reqres.in/api/users/2").
	  then().
	  	statusCode(200).
	  	log().body();
  }
  @Test
  public void canDeserializeOne() { 	  
	  RestAssured.baseURI = "https://reqres.in";
      RequestSpecification request = RestAssured.given();
      Response response = request.get("/api/users/2");

      String jsonString = response.asString();
      Map<String, Object> data = JsonPath.from(jsonString).get("data");
      
      //System.out.println(RestAssured.get("https://reqres.in/api/users/2/data").as(TypeRef<User>));
      
      //User user = RestAssured.get("https://reqres.in/api/users/2").jsonPath().getMap("data");
      //var user =  RestAssured.get("https://reqres.in/api/users/2").as(new TypeRef<User>() {});
      System.out.println(data);
      System.out.println(response.getBody().jsonPath().getMap("data"));
      //System.out.println(user.print()); 
      //User user = (User) response.getBody().jsonPath().getMap("data");
      
      //System.out.println(user.print());
      User users = RestAssured.get("https://reqres.in/api/users/2/data").as(User.class);
      System.out.println();

  }
  @Test
  public void canDeserializeMany() { 	  
	  RestAssured.baseURI = "https://reqres.in";
      RequestSpecification request = RestAssured.given();
      Response response = request.get("/api/users?page=2");

      String jsonString = response.asString();
      //System.out.println(JsonPath.from(jsonString).get("data"));
      List<Map<String, Object>> data = JsonPath.from(jsonString).get("data");
      
      System.out.println(data.toString());
      
      //List<User> users = RestAssured.get("https://reqres.in/api/users?page=2").as(new TypeRef<List<User>>() {});
      User[] users = RestAssured.get("https://reqres.in/api/users?page=2").as(User[].class);
      System.out.println();
  }

}
