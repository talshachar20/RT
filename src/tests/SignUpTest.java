package tests;

import pages.MainPage;
import pages.SignUpPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import pages.TestSetup;
import sun.applet.Main;

public class SignUpTest extends TestSetup {

    @Test
    public void SignUpTest(){
        String registerUrl = "https://en.dawanda.com/account/register";
        String userName = "frontend-test-user-1032030980";
        String email = "frontend-tests+-1042090980@dawandamail.com";
        driver.get(registerUrl);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInitialized());
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.userSectionText().contains("Register")) {
            System.out.print("Login");
        }

        signUpPage.registerUser("test", "user", userName, email, "testuser");
        assertEquals("We sent a confirmation link to " + email, signUpPage.confirmationMessage());
    }
}