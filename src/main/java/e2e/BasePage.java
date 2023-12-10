package e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    private static final Duration WAIT = Duration.ofSeconds(60, 1);
    protected final String ORANGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php";
    protected WebDriver driver;
    private WebElement element;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    protected void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void clickElement(By locator) {
        waitUntilElementIsPresent(locator);
        element = driver.findElement(locator);
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void fillInElement(By locator, String value) {
        waitUntilElementIsPresent(locator);
        element = driver.findElement(locator);
        waitForElementVisibility(element);
        element.sendKeys(value);
    }

    protected String getElementText(By locator) {
        waitUntilElementIsPresent(locator);
        element = driver.findElement(locator);
        waitForElementVisibility(element);
        return element.getText();
    }

    public void visitPageURL(String url) {
        driver.get(url);
    }

}
