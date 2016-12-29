package com.automationpractice.test.pages;


import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 11/23/2016.
 */
public class LoginPage extends CommanFunction {

    //WebDriver driver;

    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        //this.driver = driver;
    }

    /*
    All locator will be defined underneath.
     */
    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By selectCreateAccount = By.xpath(".//*[@id='SubmitCreate']");
    private static final By provideEmailToCreateAccount = By.xpath(".//*[@id='email_create']");
    private static final By userName = By.xpath(".//*[@id='email']");
    private static final By password = By.cssSelector("#passwd");
    private static final By signInButton = By.cssSelector("#SubmitLogin");


    /*
    All variables will be defined here. These variables are defined in config.properties file & called by getConfigFileData method from CommanFunction page.
     */
    private String validUserName = getConfigFileData("validUserName");
    private String invalidUserName = getConfigFileData("invalidUserName");
    private String validPassword = getConfigFileData("validPassword");
    private String invalidPassword = getConfigFileData("invalidPassword");


    /*
     This funtion will check if Create an Account button is visible on loginPage after clicking signIn button on Home page.
     This is validation to check if user landed on correct page after clicking Signin button.
      */
    public boolean checkCreateAccount() throws InterruptedException {
        // Thread.sleep(10000);
        boolean isLoginPagePresent = true;
        try {
            WebElement element = driver.findElement(selectCreateAccount);
            element.isDisplayed();
        } catch (Exception ex) {
            isLoginPagePresent = false;
        }
        return isLoginPagePresent;
    }


    /*
    This function will enter email in Email Address field to crete a new user.This email address is testData to create
    a new user with this email id.
    fillValuesInTextBox is in CommanFunction folder & CommanFunction is extended with this page.
     */
    public void enterEmail(String emailToCreateAccount) {

        log.info("provide Email address to create account");
        fillValuesInTextBox(provideEmailToCreateAccount, emailToCreateAccount);

        // Above code cam also be written as

        /*try {
            WebElement element = driver.findElement(provideEmailToCreateAccount);
            element.sendKeys(UserEmail);
        } catch (Exception ex) {
            System.out.println(" Exception ");
        }*/
    }

    /*
    This function will enter correct user name & password & logs into application successfully.
     */
    public MyAccountPage successFulLogin() throws IOException {
        fillValuesInTextBox(userName, validUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with valid username & password.");
        return new MyAccountPage(driver);
    }

    /*
    This function is to test failed login scenarios & check error messages.
     */
    public void failedLoginInvalidUserValidPassword() {

        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & valid password");
    }

    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginInvalidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, invalidPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & invalid password");

    }

//    public boolean wrongPasswordErrorVerification(){
//
//        boolean errorMessage= false;
//
//        try {
//            waitForElementToBeVisible();
//            errorMessage = true;
//        }
//        catch (ElementNotVisibleException e){
//
//        }
//        return errorMessage;
//
//    }

    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginValidUserInvalidPassword() {
        fillValuesInTextBox(userName, invalidUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        log.info("Verify login functionality with invalid username & valid password");


    }

    /*
    This function (clickCreateAccountButton) will click on Create an account button on loginPage after enetring email. This function returns refernce
     of CreateAccountPage where user can fill registration form & create new user.
     **********************************************
     This code can also be written as.

     WebElement element = driver.findElement(selectCreateAccount);
        element.click();
        return new CreateAccountPage(getDriver());

       ***********************************************************
     */

    public CreateAccountPage clickCreateAccountButton() {

        clickOnLocator(selectCreateAccount);
        log.info("Select Create Account button to create new user.");
        return new CreateAccountPage(getDriver());

        // Above code can also be written as


    }

    /**
     * This function will wait for given element to be visible.
     */
    public void waitForLoginPage() {
        log.info("Waiting for login page to load.");
        waitForElementToBeVisible(selectCreateAccount);
        waitForElementToBeVisible(provideEmailToCreateAccount);
        waitForElementToBeVisible(userName);


    }

    /**
     * This method contains failed login scenarios.
     */
    public boolean failedLoginCases() {

        boolean isSuccess = true;

        try {
            log.info("Test Cases for failed login scenarios started.");
            failedLoginInvalidUserInvalidPassword();
            //assertTrue(loginPage.wrongPasswordErrorVerification());
            failedLoginInvalidUserValidPassword();
            failedLoginValidUserInvalidPassword();

        } catch (Exception e) {

            isSuccess = false;
        }
        return isSuccess;
    }


}


