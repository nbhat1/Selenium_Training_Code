
package testcases;

import comman.CommanFunction;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.*;

/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 */
public class TC001_SignInButton {

    WebDriver driver ;
    //HomePage home;
    CommanFunction commanFunction;
    LoginPage loginPage;
    //CreateAccountPage createAccount;

    @BeforeClass
    public void setUp(){
        commanFunction = new CommanFunction(driver);
   }

    // This method will click on Sign in button on login page.
    @Test
    public void clickSignInNavigateHomePage() throws InterruptedException, IOException {
        loginPage = commanFunction.clickSignInButton();
        //Thread.sleep(10000);
        loginPage.waitForLoginPage();
        assertTrue(loginPage.checkCreateAccount(), "Create account button is not visible.");
        }

     @AfterClass
    public void tearDown(){
         commanFunction.closeDriver();
    }

    }


