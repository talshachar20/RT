package pages;

/**
 * Created by tal.shachar on 21/02/17.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverInit {
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (isDriverNotInitialized()) {
            setupDriver();
        }
        return driver;
    }

    private static void setupDriver() {
        //Todo: In the future it should work with remote driver where it connects to a selenium grid.
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    private static boolean isDriverNotInitialized() {
        return driver == null || driver.toString().contains("(null)");
    }
}
