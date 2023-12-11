package api.stepsDefinitions;

import e2e.OrangeLoginPage;
import helpers.BaseURLs;
import helpers.TestDataHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class DeleteCandidateSteps extends BaseURLs {
    Response response;
    Cookie orangehrmCookie;
    int id;
    WebDriver webDriver;
    TestDataHelper testDataHelper;
    String fname, mname, lname, email, date;
    OrangeLoginPage orangeLoginPage;

    // NOTE: This class does not adhere to best practices and requires refactoring
    // TODO 1- Share browserSetup among all tests
    // TODO 2- Create candidate in a Background job and use TestContext and ScenarioContext
    // TODO 3- Share apiResonances assertion among all tests
    @Before(order = 0)
    public void browserSetup() {
        // no driver setup should be done for api testing, but its necessary here to be able to get the orangehrm cookie
        WebDriverManager.chromedriver().driverVersion("117.0.5938.88").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
    }

    @Before(order = 1)
    public void setUpData() {
        orangeLoginPage = new OrangeLoginPage(webDriver);
        testDataHelper = new TestDataHelper();
        prepareData();
    }

    private void prepareData() {
        fname = testDataHelper.generateRandomText(8);;
        mname = testDataHelper.generateRandomText(8);
        lname = testDataHelper.generateRandomText(8);
        email = testDataHelper.generateRandomEmail();
        date = "2023-12-11"; // TODO randomize the data with yyyy-mm-dd format
    }

    @Given("admin user is logged in properly")
    public void admin_user_is_logged_in_properly() {
        orangeLoginPage.login(ORANGE_SEEDED_ADMIN_EMAIL, ORANGE_SEEDED_ADMIN_PASSWORD);
        orangehrmCookie = webDriver.manage().getCookieNamed("orangehrm");
    }

    @Given("new candidate is created")
    public void new_candidate_is_created() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", fname);
        jsonObject.put("middleName", mname);
        jsonObject.put("lastName", lname);
        jsonObject.put("email", email);
        jsonObject.put("dateOfApplication", date);

        response =
                RestAssured.
                        given().
                        cookie("orangehrm",orangehrmCookie.getValue()).
                        header("Content-Type", "application/json").
                        body(jsonObject).post(CANDIDATE_BASE_URL);

        // Get candidate id
        JsonPath jsonPath = response.jsonPath();
        id = jsonPath.get("data.id");
    }

    @When("delete call api with valid id")
    public void delete_call_api_with_valid_id() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(id);

        jsonObject.put("ids", jsonArray);

        response =
                RestAssured.
                        given().
                        cookie("orangehrm",orangehrmCookie.getValue()).
                                header("Content-Type", "application/json").
                        body(jsonObject).delete(CANDIDATE_BASE_URL);
    }

    @Then("api response is 200") // TODO this step should be shared among all api tests
    public void api_response_is_200() {
        Assert.assertEquals( response.getStatusCode() + "" , "200");
    }
}
