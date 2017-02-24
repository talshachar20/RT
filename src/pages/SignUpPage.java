package pages;

/**
 * Created by tal.shachar on 21/02/17.
 */
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BasePage {

    List<String> list = new ArrayList<String>();
    private final String FIRST_NAME = "firstname";
    private final String LAST_NAME = "lastname";
    private final String USERNAME = "username";
    private final String EMAIL = "email";
    private final String PASSWORD = "password";
    private final String ACCEPT_PRIVACY = "accept_privacy";
    private final String SUBMIT = "register_submit";
    private final String USER_VALIDATION = "validate_email_hint";

    public SignUpPage() {
        super(DriverInit.getDriver());
    }

    public void registerUser(String firstNameInput, String lastNameInput, String userNameInput, String emailInput, String passwordInput ){
        type(By.id(FIRST_NAME), firstNameInput);
        type(By.id(LAST_NAME), lastNameInput);
        type(By.id(USERNAME), userNameInput);
        type(By.id(EMAIL), emailInput);
        type(By.id(PASSWORD), passwordInput);
        click(By.id(ACCEPT_PRIVACY));
        click(By.id(SUBMIT));
    }

    public String confirmationMessage() {
        return getText(By.id(USER_VALIDATION));
    }
}