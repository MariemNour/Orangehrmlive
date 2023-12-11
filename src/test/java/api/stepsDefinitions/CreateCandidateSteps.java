package api.stepsDefinitions;

import helpers.BaseURLs;
import e2e.OrangeLoginPage;
import helpers.TestDataHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateCandidateSteps extends BaseURLs {
    WebDriver webDriver;
    OrangeLoginPage orangeLoginPage;
    TestDataHelper testDataHelper;
    Response response;
    String fname, mname, lname, email, date;
    Cookie orangehrmCookie;

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


    @Given("admin user is logged in")
    public void admin_user_is_logged_in() {
        // Authentication should be through API, but no request was found.
        orangeLoginPage.login(ORANGE_SEEDED_ADMIN_EMAIL, ORANGE_SEEDED_ADMIN_PASSWORD);
        orangehrmCookie = webDriver.manage().getCookieNamed("orangehrm");
    }

    @When("post call api with valid data")
    public void post_call_api_with_valid_data() {
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
    }

    @Then("api response is 200OK")
    public void api_response_is_200OK() {
        Assert.assertEquals( response.getStatusCode() + "", "200");
    }
}