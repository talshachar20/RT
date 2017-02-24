package tests;

import pages.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.UUID;

public class SignUpTest extends TestSetup {

    @Test
    public void SignUpTest(){
        String url = "https://en.dawanda.com/";
        String randomString = UUID.randomUUID().toString();
        String userName = "test" + randomString;
        String email = "frontend-tests+-" + randomString + "@dawandamail.com";
        String password = "testuser";

        DriverInit.getDriver().get(url);
        MainPage mainPage = new MainPage();

        // logout if user is register
        if (!mainPage.userSectionText().contains("Register")) {
            mainPage.logOut();
        }
        mainPage.navigateToRegister();
        SignUpPage signUpPage = new SignUpPage();

        signUpPage.registerUser("test", "user", userName, email, password);
        //assert register successful
        assertTrue(signUpPage.confirmationMessage().contains("We sent a confirmation link to " + email));

        mainPage.logOut();
        mainPage.navigateTologIn();
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        //assert login successful
        mainPage.textChange(userName);
        assertTrue(mainPage.userSectionText().contains(userName));
        mainPage.logOut();
    }
}