package testcases;

import comman.CommanFunction;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import pages.MyAccountPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Neeraj on 26-11-2016.
 */


public class TC002_RegisterNewUser {
    WebDriver driver;
    //HomePage home = new HomePage(driver);
    HomePage homePage;
    LoginPage loginPage;
    CreateAccountPage createAccount;
    MyAccountPage myAccount;
    CommanFunction commanFunction;

    String emailToCreateAccount = "neerajunlimited@gmail.com";

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
    }


    @Test(priority = 0)
    public void enterEmailForUser() throws InterruptedException {
        loginPage.enterEmail(emailToCreateAccount);
        createAccount = loginPage.clickCreateAccountButton();
        createAccount.waitForCreateAccountPageToLoad();
        //Thread.sleep(10000); waitForCreateAccountPageToLoad function is worrking instead of hard coded wait.
        assertTrue(createAccount.isCreateAccountPagePresent(), "Create account page is present" );
    }

    @Test(priority = 1)
    public void createNewUser() throws InterruptedException {
        enterEmailForUser();
        createAccount.selectTitleMr();
        createAccount.fillAccountForm();
        createAccount.checkPreFilledEmail();
        createAccount.selectNewsLetter();
        createAccount.selectOffers();
        createAccount.selectDayDOB();
        createAccount.selectMonthsDOB();
        createAccount.selectYearsDOB();
        createAccount.selectRegisterButton();
        myAccount.isMyAccountPagePresent();
        assertTrue(myAccount.isMyAccountPagePresent(), "My account page returns true");

    }

    @AfterClass
    public void tearDown() {
        commanFunction.closeDriver();
    }

}
