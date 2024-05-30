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
     * @param driver
     * @param element
     * @param timeOutInSeconds
     * @author Vivek Ranjan
     */

    public static WebElement waitForElement(WebDriver driver,WebElement element, int timeOutInSeconds) {
        WebElement ele;
        try {
            WaitUtils WaitUtils=new WaitUtils();
            // To use WebDriverWait(), we would have to nullify
            // implicitlyWait().
            // Because implicitlyWait time also set "driver.findElement()" wait
            // time.
            // info from:
            // https://groups.google.com/forum/?fromgroups=#!topic/selenium-users/6VO_7IXylgY
            //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // nullify
            // implicitlyWait()
            ele = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.elementToBeClickable(element));
            ///  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            // ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.(WaitUtils.eleLocator)(WaitUtils.toByVal(element))));

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
    // return ByType of WebElement
    public By toByVal(WebElement we) {
        // By format = "[foundFrom] -> locator: term"
        // see RemoteWebElement toString() implementation
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }

    // Return type of WebElement Locator
    public String eleLocator(WebElement we) {
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        return data[0];
    }
}
