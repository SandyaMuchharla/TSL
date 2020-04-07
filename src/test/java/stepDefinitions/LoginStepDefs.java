package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.*;

import java.io.IOException;
import java.util.List;

public class LoginStepDefs extends DriverBase
{
    private static Logger log= LogManager.getLogger(LoginStepDefs.class.getName());

    @Given("I am on {string}")
    public void i_am_on(String url) {
        driver.get(url);
        log.info("Navigated to the url: " + url);
    }

    @When("I get href links")
    public void i_get_href_links() throws IOException {
        List<WebElement> links = driver.findElements(By.cssSelector(".Bgzgmd>li a"));
        System.out.println("Total Amenities "  + links.size());
        Common_Utilities.BrokenLinks(links);
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {

    }


}
