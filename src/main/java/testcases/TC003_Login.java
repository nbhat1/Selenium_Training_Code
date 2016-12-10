package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import pages.HomePage;
import comman.CommanFunction;
import pages.LoginPage;
import pages.MyAccountPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Neeraj on 27-11-2016.
 */
public class TC003_Login {

    WebDriver driver;
   // HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CommanFunction commanFunction;

    //public static final By signOutButton = By.linkText("Sign out");
    private String customerName = "Neeraj Bhatngar";

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
        //myAccountPage = loginPage.successFulLogin();
    }

    /**
     * Methods which will be used repetedly should be in BeforeMethod annotation.
     */
    /*@BeforeMethod
    public void naviagtionSetUp(){

        myAccountPage = loginPage.successFulLogin();

    }*/

    @Test (priority = 0)
    public void  successFulLogin() {

        try {
            myAccountPage = loginPage.successFulLogin(); //successFulLogin is returning myAccount page so we assign it in myAccountPage so that we can use it in next function.
        } catch (IOException e) {
            e.printStackTrace();
        }
        myAccountPage.checkMyAccountPageExistence();
        assertTrue(myAccountPage.isMyAccountPagePresent(),"Login is successful. My account page is present");

    }

    @Test (priority = 2)
    public void failedLogin() throws IOException {

          // myAccountPage.checkMyAccountPageExistence();
           // myAccountPage.checkMyAccount();
            if (myAccountPage.isMyAccountPagePresent()==false){
     //   if (myAccountPage.checkMyAccountPageExistence()) {
            loginPage.waitForLoginPage();
            loginPage.failedLoginCases();
        } else
            {
                myAccountPage.clickSignOutButton();
                loginPage.failedLoginCases();
        }
    }

    @Test(priority = 1, dependsOnMethods = {"successFulLogin"} )
    public void verifyUserName(){
       // myAccountPage.getCustomerName();
        //assertEquals(customerName, myAccountPage.getCustomerName());
        assertEquals( myAccountPage.userNameValue, myAccountPage.getCustomerName(), "User name value do not match.Please check test again." );
        // Can be writtten as with assertion
        //assertEquals(customerName, myAccountPage.getCustomerName(),"" );

    }
/*
    @Test
    public void clickTshirtlLink(){
        myAccountPage.clickTshirtLink();
        System.out.println("Tshirt link clicked");
    }*/

    @AfterClass
    public void tearDown(){
        commanFunction.closeDriver();
        System.out.println("Driver closed");
    }

}
