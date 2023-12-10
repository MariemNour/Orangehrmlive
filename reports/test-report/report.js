$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/e2e/CreateThanDeleteUser.feature");
formatter.feature({
  "name": "Check that Admin Create then Delete User",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on Orangehrmlive page",
  "keyword": "Given "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.user_is_on_Orangehrmlive_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters username",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.user_enters_username()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters password",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.user_enters_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login button",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.user_clicks_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin navigate to system user page",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_navigate_to_system_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin capture the number of records",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_capture_the_number_of_records()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin enter valid user data",
  "keyword": "When "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_enter_valid_user_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin clicks on save button",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_clicks_on_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin number of records increased by one",
  "keyword": "Then "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_number_of_records_increased_by_one()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin searches with the username for the new user",
  "keyword": "When "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_searches_with_the_username_for_the_new_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin delete the new user",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_delete_the_new_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "admin reset filter",
  "keyword": "And "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.admin_reset_filter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "number of records should be decreased by one",
  "keyword": "Then "
});
formatter.match({
  "location": "e2e.CreateAndDeleteUserSteps.number_of_records_should_be_decreased_by_one()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});