package pages;

/**
 * Created by tal.shachar on 21/02/17.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends DriverInit {

    List<String> list = new ArrayList<String>();

    @FindBy(id="firstname")
    private WebElement firstName;

    @FindBy(id="lastname")
    private WebElement lastName;

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="accept_privacy")
    private WebElement acceptPrivacy;

    @FindBy(id="register_submit")
    private WebElement registerSubmit;

    @FindBys({ @FindBy(className="validation-msg invalid") })
    public List<WebElement> validationMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return firstName.isDisplayed();
    }

    @FindBy(id="validate_email_hint")
    private WebElement userValidation;

    public void registerUser(String firstName, String lastName, String userName, String email, String password ){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);

        this.username.clear();
        this.username.sendKeys(userName);

        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.acceptPrivacy.click();
        this.registerSubmit.click();
    }

    public String url() {
       return driver.getCurrentUrl();
    }

    public String confirmationMessage() {
        return this.userValidation.getText();
    }
}