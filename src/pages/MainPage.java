package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tal.shachar on 21/02/17.
 */
public class MainPage extends DriverInit {

    @FindBy(className="header-user-toggle")
    private WebElement userSection;

    @FindBy(className="logout-link-container")
    private  WebElement logoutLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String userSectionText(){
        return this.userSection.getText();
    }

    public void logOut() {
        this.userSection.click();
        this.logoutLink.click();
    }

}
