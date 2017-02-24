package pages;

/**
 * Created by tal.shachar on 24/02/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
         this.wait = new WebDriverWait(driver, 30);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(By locator, String text) {
        WebElement element = find(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = find(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void moveToElement(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(find(locator)).build().perform();
    }

    public void waitUntilTextPresented(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        WebElement element = find(locator);
        return element.getText();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}