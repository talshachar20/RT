package tests;

import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pages.TestSetup;

public class SignUpTest extends TestSetup {

    @Test
    public void SignUpTest(){

        String url = "https://en.dawanda.com/";
        String userName = "frontend-test-user-1ddxmddc3s503212e980";
        String email = "frontend-tests+-1d4xsx01ds0dddc3280@dawandamail.com";
        String password = "testuser";

        driver.get(url);
        MainPage mainPage = new MainPage(driver);

        // logout if user is register
        if (!mainPage.userSectionText().contains("Register")) {
            mainPage.logOut();
        }
        mainPage.navigateToRegister();
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.registerUser("test", "user", userName, email, password);
        //assert register successful
        assertTrue(signUpPage.confirmationMessage().contains("We sent a confirmation link to " + email));

        mainPage.logOut();
        mainPage.navigateTologIn();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        //assert login successful
        assertTrue(mainPage.userSectionText().contains("Hello"));
    }
}