package API;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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

      User users = response.getBody().jsonPath().getObject("data", User.class);
      
      assertEquals(users.getId(),"2");
      assertEquals(users.getEmail(),"janet.weaver@reqres.in");
      assertEquals(users.getFirst_name(),"Janet");
      assertEquals(users.getLast_name(),"Weaver");
      assertEquals(users.getAvatar(),"https://reqres.in/img/faces/2-image.jpg");
  }
  @Test
  public void canDeserializeMany() { 	  
	  RestAssured.baseURI = "https://reqres.in";
      RequestSpecification request = RestAssured.given();
      Response response = request.get("/api/users?page=2");
            
      User[] users = response.getBody().jsonPath().getObject("data", User[].class);
      
      assertNotNull(users);
  }

}
