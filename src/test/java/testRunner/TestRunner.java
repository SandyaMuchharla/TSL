package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features",
        glue= "stepDefinitions",tags="@SmokeTest1",monochrome=true,strict=true,
        plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json","junit:target/cukes.xml"}
)

public class TestRunner
{
    //plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"}
    //"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber/report.html"

}
