
package com.automationpractice.test.testcases;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.LoginPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import org.apache.log4j.Logger;

import java.io.IOException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.*;

/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 */
public class TC001_SignInButton {

    private static Logger Log = Logger.getLogger(TC001_SignInButton.class.getName());
   //public static Logger Log = Logger.getLogger(TC001_SignInButton.class);

    WebDriver driver ;
    //HomePage home;
    CommanFunction commanFunction;
    LoginPage loginPage;
    //CreateAccountPage createAccount;

    @BeforeClass
    public void setUp(){
        DOMConfigurator.configure( "src/test/log4j.xml" );
        commanFunction = new CommanFunction(driver);
    }

    // This method will click on Sign in button on login page.
    @Test
    public void clickSignInNavigateHomePage() throws InterruptedException, IOException {
        Log.info( "This is log" );
        //Log.debug( "This is new log" );
        loginPage = commanFunction.clickSignInButton();
        loginPage.waitForLoginPage();
        assertTrue(loginPage.checkCreateAccount(), "Create account button is not visible.");
        //Log.info( assertTrue( loginPage.checkCreateAccount(), "This is new log" ) ); );
    }

     @AfterClass
    public void tearDown(){
         commanFunction.closeDriver();
        }
    }


