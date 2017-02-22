package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tal.shachar on 21/02/17.
 */
public class MainPage extends DriverInit {
    @FindBy(id="shared_header_user_nav")
    private WebElement userSection;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String userSectionText(){
        return this.userSection.getText();
    }
}
