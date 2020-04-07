package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;

public class WebDriverUtils extends DriverBase
{
    public static WebElement waitUntilVisible(WebDriver webDriver, By by, Duration wait) {
        try {
            new FluentWait<>(webDriver)
                    .withTimeout(wait)
                    .pollingEvery(Duration.ofMillis(2))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                    .until(driver -> driver.findElement(by).isDisplayed());
        } catch (org.openqa.selenium.TimeoutException te) {
            //fail(format("Element %s still not visible after %s", by, wait));
            System.out.println(format("Element %s still not visible after %s", by, wait));
        }
        return webDriver.findElement(by);
    }

    public static WebElement waitUntilClickable(WebDriver driver, By by, long wait) {
        return new WebDriverWait(driver, wait).until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void actionsToMoveToElement(WebDriver driver,WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element);
        action.build().perform();
    }

    public static void actionToClickElement(WebDriver driver, WebElement element) {
        Actions action =new Actions(driver);
        element.click();
    }

    public static void selectDropDownbyText(WebElement element,String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }


    public static void handleFrames(WebElement element){
        driver.switchTo().frame(element);
    }
}
