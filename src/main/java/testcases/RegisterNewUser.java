package testcases;

import comman.CommanFunction;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Neeraj on 26-11-2016.
 */


public class RegisterNewUser {
    WebDriver driver;
    //HomePage home = new HomePage(driver);
    HomePage homePage;
    LoginPage loginPage;
    CreateAccountPage createAccount;
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
        //Thread.sleep(10000); waitForCreateAccountPageToLoad function is waorking instead of hard coded wait.
        assertTrue(createAccount.checkRegPage(), "check registration page should return true");
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
        //createAccount.checkRegPage();
        assertTrue(createAccount.checkRegPage());
    }

    @AfterClass
    public void tearDown() {
        commanFunction.closeDriver();
    }

}
