package pages;


import comman.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by neeraj.bhatnagar on 11/23/2016.
 */
public class LoginPage extends CommanFunction{

    //WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        //this.driver = driver;
    }
    /*
    All locator will be defined underneath.
     */
    private static final By selectCreateAccount =By.xpath(".//*[@id='SubmitCreate']");
    private static final By provideEmailToCreateAccount = By.xpath(".//*[@id='email_create']");
    private static final By userName = By.xpath(".//*[@id='email']");
    private static final By password = By.cssSelector("#passwd");
    private static final By signInButton = By.cssSelector("#SubmitLogin");

    /*
    All variables will be defined here.
     */
    private String validUserName = "neeraj2016@gmail.com";
    private String invalidUserName = "neeraj232323@gmail.com";
    private String validPassword = "Password1";
    private String invalidPassword = "Password123";


   /*
    This funtion will check if Craete an Account button is visible on loginPage after clicking signIn button on Home page.
    This is validation to check if user landed on correct page after clicking Signin button.
     */
    public boolean checkCreateAccount() throws InterruptedException {
       // Thread.sleep(10000);
            boolean isLoginPagePresent = true ;
        try {
            WebElement element = driver.findElement(selectCreateAccount);
            element.isDisplayed();
        }
        catch (Exception ex){
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

        fillValuesInTextBox(provideEmailToCreateAccount,emailToCreateAccount);

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
    public MyAccountPage successFulLogin() {
        fillValuesInTextBox(userName,validUserName);
        fillValuesInTextBox(password, validPassword);
        clickOnLocator(signInButton);
        return new MyAccountPage(driver);
    }

    /*
    This function is to test failed login scenarios & check error messages.
     */
    public void failedLoginInvalidUserValidPassword() {
        fillValuesInTextBox(userName,invalidUserName);
        fillValuesInTextBox(password,validPassword);
        clickOnLocator(signInButton);
    }

    /*
   This function is to test failed login scenarios & check error messages.
    */
    public void failedLoginInvalidUserInvalidPassword() {
        fillValuesInTextBox(userName,invalidUserName);
        fillValuesInTextBox(password,invalidPassword);
        clickOnLocator(signInButton);

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
        fillValuesInTextBox(userName,invalidUserName);
        fillValuesInTextBox(password,validPassword);
        clickOnLocator(signInButton);


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

    public CreateAccountPage clickCreateAccountButton(){

        clickOnLocator(selectCreateAccount);
        return new CreateAccountPage(getDriver());

        // Above code can also be written as


    }
    /**
     * This function will wait for given elemenst to be visible.
    */

    public void waitForLoginPage(){
        waitForElementToBeVisible(selectCreateAccount);
        waitForElementToBeVisible(provideEmailToCreateAccount);
        waitForElementToBeVisible(userName);

    }

    /**
     * This method contains failed login scenarios.
     */
    public void failedLoginCases(){
        failedLoginInvalidUserInvalidPassword();
        //assertTrue(loginPage.wrongPasswordErrorVerification());
        failedLoginInvalidUserValidPassword();
        failedLoginValidUserInvalidPassword();
    }

}


