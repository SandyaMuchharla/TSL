$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Login.feature");
formatter.feature({
  "name": "Login to gmail",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "Find Broken links",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@SmokeTest1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on \"https://gmail.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefs.i_am_on(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get href links",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDefs.i_get_href_links()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "status code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefs.status_code_should_be(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});