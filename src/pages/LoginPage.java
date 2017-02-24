package pages;

import org.openqa.selenium.By;

/**
 * Created by tal.shachar on 22/02/17.
 */
public class LoginPage extends BasePage {
    private final String USERNAME = "username";
    private final String PASSWORD = "login_credentials_password";
    private final String SUBMIT = "login_submit";

    public LoginPage() {
        super(DriverInit.getDriver());
    }

    public void login(String usernameInput, String passwordInput)  {
        type(By.id(USERNAME), usernameInput);
        type(By.id(PASSWORD), passwordInput);
        click(By.id(SUBMIT));
    }

}
