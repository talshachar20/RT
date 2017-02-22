package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tal.shachar on 22/02/17.
 */
public class LoginPage extends DriverInit {

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="login_credentials_password")
    private WebElement password;

    @FindBy(id="login_submit")
    private WebElement loginSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String usernameInput, String passwordInput) throws InterruptedException {

        this.userName.clear();
        this.userName.sendKeys(usernameInput);

        this.password.clear();
        this.password.sendKeys(passwordInput);

        this.loginSubmit.click();
        Thread.sleep(1000);
    }
}
