package utilityPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils extends BaseClass{
    public static FluentWait<WebDriver> wait;
    /**
     * Description of waitForElement
     * Explicit wait for web element
     *
     * @param element
     * @param timeOutInSeconds
     * @author Vivek Ranjan
     */
    public static WebElement waitForElement(WebElement element, int timeOutInSeconds) {
        WebElement ele;
        try {
            // To use WebDriverWait(), we would have to nullify
            // implicitlyWait().
            // Because implicitlyWait time also set "driver.findElement()" wait
            // time.
            // info from:
            // https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
            //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // nullify
            // implicitlyWait()

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            ele = wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

            return ele; // return the element
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    /**
     * Checks if the elment is in the DOM and displayed.
     *
     * @param driver
     *            - The driver object to use to perform this element search
     * @param by
     *            - selector to find the element
     * @return boolean
     */
    private static boolean isElementPresentAndDisplay(WebDriver driver, By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void sleepTime(int seconds) {
       // Log.info("-------  sleep for ------" + seconds + "     ----seconds---");

        int sleepTime = seconds * 1000;
        try {
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {

          //  Log.error("Exception : " + e);
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForElement(String element, String locType) {

      //  Log.info("Waiting for Element " + element + " initiated");
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1000)).withMessage("Timeout occured!")
                .ignoring(java.util.NoSuchElementException.class);
        if (locType.equalsIgnoreCase("id")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } else if (locType.equalsIgnoreCase("xpath")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
       // Log.info("Waiting for Element " + element + " exited");

    }
}
