$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/api/CreateCandidateApi.feature");
formatter.feature({
  "name": "Verify that admin user can Add candidate to candidate API",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "POST to candidate API",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "admin user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "post call api with valid data",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "api response is 200OK",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/api/DeleteCandidateApi.feature");
formatter.feature({
  "name": "Verify that admin user can delete candidate through candidate API",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "admin user is logged in properly",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "new candidate is created",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "DELETE to candidate API",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "delete call api with valid id",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "api response is 200",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/e2e/CreateThanDeleteUser.feature");
formatter.feature({
  "name": "Verify that Admin Can Create then Delete User",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Admin Can Create then Delete User",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "admin user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin navigate to system user page",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_navigate_to_system_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin capture the number of records",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_capture_the_number_of_records()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin clicks on add new user",
  "keyword": "When "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_clicks_on_add_new_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin enter valid user data",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_enter_valid_user_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin clicks on save button",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_clicks_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin number of records increased by one",
  "keyword": "Then "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_number_of_records_increased_by_one()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Number of records is not increased by 1 expected [18] but found [19]\n\tat org.testng.Assert.fail(Assert.java:110)\n\tat org.testng.Assert.failNotEquals(Assert.java:1413)\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:149)\n\tat org.testng.Assert.assertEquals(Assert.java:131)\n\tat org.testng.Assert.assertEquals(Assert.java:1252)\n\tat e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_number_of_records_increased_by_one(CreateAndDeleteUserSteps.java:88)\n\tat ✽.admin number of records increased by one(file:///home/mariam/Projects/OrangehrmliveTask/src/test/resources/e2e/CreateThanDeleteUser.feature:10)\n",
  "status": "failed"
});
formatter.step({
  "name": "admin searches with the username for the new user",
  "keyword": "When "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_searches_with_the_username_for_the_new_user()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "admin delete the new user",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_delete_the_new_user()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "admin reset filter",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.admin_reset_filter()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "number of records should be decreased by one",
  "keyword": "Then "
});
formatter.match({
  "location": "e2e.stepsDefinitions.CreateAndDeleteUserSteps.number_of_records_should_be_decreased_by_one()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});