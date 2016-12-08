
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
public class SignInButton {

    WebDriver driver ;
    //HomePage home;
    CommanFunction commanFunction;
    LoginPage loginPage;
    //CreateAccountPage createAccount;

    @BeforeClass
    public void setUp(){

        //home = new HomePage(driver);
        commanFunction = new CommanFunction(driver);

    }

    // This method will click on Sign in button on login page.
    @Test
    public void clickSignInNavigateHomePage() throws InterruptedException, IOException {
        loginPage = commanFunction.clickSignInButton();
        //System.out.println("Sign In button clicked.");

        Thread.sleep(10000);
        assertTrue(loginPage.checkCreateAccount());
        }



     @AfterClass
    public void tearDown(){
         commanFunction.closeDriver();
    }

    }


