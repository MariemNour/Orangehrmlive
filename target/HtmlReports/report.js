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
  "location": "api.stepsDefinitions.CreateCandidateSteps.admin_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "post call api with valid data",
  "keyword": "When "
});
formatter.match({
  "location": "api.stepsDefinitions.CreateCandidateSteps.post_call_api_with_valid_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "api response is 200OK",
  "keyword": "Then "
});
formatter.match({
  "location": "api.stepsDefinitions.CreateCandidateSteps.api_response_is_200OK()"
});
formatter.result({
  "status": "passed"
});
});