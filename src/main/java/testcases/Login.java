package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;
import pages.HomePage;
import comman.CommanFunction;
import pages.LoginPage;
import pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Neeraj on 27-11-2016.
 */
public class Login {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CommanFunction commanFunction;

    public static final By signOutButton = By.linkText("Sign out");
    private String customerName = "Neeraj Bhatngar";



    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
        myAccountPage = loginPage.successFulLogin();
    }

    /**
     * methods wehich will be used repetedly shodul eb in BeforeMithod nnotation.
     * In this Tets Class we are loggin in both of the methods so we put  myAccountPage = loginPage.successFulLogin(); in before method
     *
     */
    /*@BeforeMethod
    public void naviagtionSetUp(){

        myAccountPage = loginPage.successFulLogin();

    }*/

    @Test (priority = 1)
    public void  successFulLogin() {

        //myAccountPage = loginPage.successFulLogin(); //successFulLogin is returning myAccount page so we assign it in myAccountPage so that we can use it in next function.
        myAccountPage.checkMyAccountPageExistence();
        assertTrue(myAccountPage.checkPageExistence(signOutButton), "Sign Out button is present.");
        assertTrue(myAccountPage.checkMyAccount());

    }

    @Test (priority = 0)
    public void failedLogin() {

           // myAccountPage.checkMyAccountPageExistence();
            myAccountPage.checkMyAccount();
            if (myAccountPage.checkPageExistence(signOutButton)==false){
     //   if (myAccountPage.checkMyAccountPageExistence()) {
            loginPage.waitForLoginPage();
            loginPage.failedLoginCases();
        } else
            {
                myAccountPage.clickSignOutButton();
                loginPage.failedLoginCases();
        }
    }

    @Test
    public void verifyUserName(){
        myAccountPage.getCustomerName();
        assertEquals(customerName, myAccountPage.getCustomerName());

    }

    @Test
    public void clickTshirtlLink(){
        myAccountPage.clickTshirtLink();
        System.out.println("Tshirt link clicked");
    }

    /*@AfterClass
    public void tearDown(){
        commanFunction.closeDriver();
    }
*/
}
