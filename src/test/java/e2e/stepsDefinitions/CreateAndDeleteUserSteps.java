package e2e.stepsDefinitions;

import e2e.BaseTest;
import e2e.OrangeLoginPage;
import e2e.OrangeUserManagementPage;
import helpers.TestDataHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class CreateAndDeleteUserSteps extends BaseTest {
    WebDriver webDriver;
    OrangeLoginPage orangeLoginPage;
    OrangeUserManagementPage orangeUserManagementPage;
    TestDataHelper testDataHelper;
    String username, password;
    Integer initialRecords;

    @Before(order = 0)
    public void browserSetup()
    {
        //System.setProperty("webdriver.chrome.driver", "driver/chrome-driver-81.0.4044.69.exe");
        WebDriverManager.chromedriver().driverVersion("117.0.5938.88").setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }
    @Before(order = 1)
    public void setUpData() {
        orangeLoginPage = new OrangeLoginPage(webDriver);
        orangeUserManagementPage = new OrangeUserManagementPage(webDriver);
        testDataHelper = new TestDataHelper();
        prepareData();
    }

    private void prepareData() {
        username = testDataHelper.generateRandomText(10);
        password = testDataHelper.generateRandomPassword();
    }

    @Given("admin user is logged in")
    public void admin_user_is_logged_in() {
        orangeLoginPage.login(ORANGE_SEEDED_ADMIN_EMAIL, ORANGE_SEEDED_ADMIN_PASSWORD);
    }

    @And("admin navigate to system user page")
    public void admin_navigate_to_system_user_page() {
        orangeUserManagementPage.clickAdminMenuItem();
    }

    @And("admin capture the number of records")
    public void admin_capture_the_number_of_records() {
        initialRecords = orangeUserManagementPage.getTotalRecordsValue();
    }

    @When("admin clicks on add new user")
    public void admin_clicks_on_add_new_user(){
        orangeUserManagementPage.clickAddButton();
    }

    @And("admin enter valid user data")
    public void admin_enter_valid_user_data() {
        orangeUserManagementPage.selectUserRoleDDL(OrangeUserManagementPage.UserRoleEnum.Admin.name());
        orangeUserManagementPage.selectStatusDDL(OrangeUserManagementPage.StatusEnum.Enabled.name());
        orangeUserManagementPage.fillInEmployeeNameField("a"); // TODO should be randomized within the list of employees
        orangeUserManagementPage.fillInUsernameField(username);
        orangeUserManagementPage.fillInPasswordField(password);
        orangeUserManagementPage.fillInConfirmPasswordField(password);
    }

    @And("admin clicks on save button")
    public void admin_clicks_on_save_button() {
        orangeUserManagementPage.clickSaveButton();
    }

    @Then("admin number of records increased by one")
    public void admin_number_of_records_increased_by_one() {
        Assert.assertEquals(orangeUserManagementPage.getTotalRecordsValue(), initialRecords + 1 , "Number of records is not increased by 1" );
    }

    @When("admin searches with the username for the new user")
    public void admin_searches_with_the_username_for_the_new_user() {
        orangeUserManagementPage.findUserByUsername(username);
    }

    @And("admin delete the new user")
    public void admin_delete_the_new_user() {
        orangeUserManagementPage.deleteFirstUserRecord();
    }

    @And("admin reset filter")
    public void admin_reset_filter() {
        orangeUserManagementPage.resetFilter();
    }

    @Then("number of records should be decreased by one")
    public void number_of_records_should_be_decreased_by_one() {
        Assert.assertEquals(orangeUserManagementPage.getTotalRecordsValue(), initialRecords , "Number of records is not decreased by 1" );
    }

    @After
    public void tearDown()
    {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
