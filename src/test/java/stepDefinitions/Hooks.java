package stepDefinitions;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverBase;

import java.io.File;
import java.io.IOException;

public class Hooks extends DriverBase
{
    private static Logger log= LogManager.getLogger(Hooks.class.getName());

    @Before
    public void beforeScenario(Scenario scenario)
    {
        DriverBase.Initialize();
        log.info("========================================================");
        log.info("Browser has initialised");
    }
    @After
    public void afterScenario(cucumber.api.Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                scenario.write("URL at failure  :" + driver.getCurrentUrl());
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber/screenshots/" + screenshotName + ".png");
                Files.copy(sourcePath, destinationPath);

            } catch (IOException e)
            {
                System.err.println(e.getMessage());
                log.info(e.getMessage());
            }
        }
        DriverBase.quit();
        log.info("Quit the browser");
        log.info("========================================================");
    }
}
