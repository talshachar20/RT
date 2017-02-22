package pages;

/**
 * Created by tal.shachar on 21/02/17.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverInit {
    protected WebDriver driver;

    public DriverInit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
