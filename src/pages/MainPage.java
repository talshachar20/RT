package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by tal.shachar on 21/02/17.
 */
public class MainPage extends DriverInit {

    @FindBy(className="header-user-toggle")
    private WebElement userSection;

    @FindBy(className="logout-link-container")
    private  WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"shared_header_user_dropdown\"]/ul/li[1]/a")
    private WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"shared_header_user_dropdown\"]/ul/li[2]/a")
    private WebElement registerLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    public String userSectionText(){
        return this.userSection.getText();
    }

    public void logOut() {
        this.userSection.click();
        this.logoutLink.click();
    }

    public void navigateTologIn() {
        action.moveToElement(this.userSection).build().perform();
        this.loginLink.click();
    }

    public void navigateToRegister() {
        action.moveToElement(this.userSection).build().perform();
        this.registerLink.click();
    }
}
