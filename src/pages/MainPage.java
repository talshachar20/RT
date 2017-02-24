package pages;

import org.openqa.selenium.By;

/**
 * Created by tal.shachar on 21/02/17.
 */
public class MainPage extends BasePage {
    private final String USER_SECTION = "header-user-toggle";
    private final String LOGOUT_LINK = "logout-link-container";
    private final String LOGIN = "//*[@id=\"shared_header_user_dropdown\"]/ul/li[1]/a";
    private final String REGISTER = "//*[@id=\"shared_header_user_dropdown\"]/ul/li[2]/a";

    public MainPage() {
        super(DriverInit.getDriver());
    }

    public String userSectionText(){
        return getText(By.className(USER_SECTION));
    }

    public void logOut() {
        click(By.className(USER_SECTION));
        click(By.className(LOGOUT_LINK));
    }

    public void navigateTologIn() {
        moveToElement(By.className(USER_SECTION));
        click(By.xpath(LOGIN));
    }

    public void navigateToRegister() {
        moveToElement(By.className(USER_SECTION));
        click(By.xpath(REGISTER));
    }

    public void textChange(String userName) {
        waitUntilTextPresented(By.className("logged-in-state"));
    }
}
