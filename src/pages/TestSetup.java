package pages;

import org.junit.After;
import org.junit.AfterClass;

/**
 * Created by tal.shachar on 21/02/17.
 */
public class TestSetup {

    @After
    public void cleanUp(){
        DriverInit.getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        DriverInit.getDriver().close();
    }
}
