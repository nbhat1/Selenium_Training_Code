package pages;


import comman.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Neeraj on 26-11-2016.
 */
public class MyAccountPage extends CommanFunction{

    //WebDriver driver;

        public MyAccountPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public static final By authenticateMyAccount = By.cssSelector(".navigation_page");
    public static final By signOutButton = By.linkText("Sign out");

    /**
     * This funtion will check if MyAccountPagePresent. It can be used in Assertion.
     * @return
     */
    public boolean checkMyAccount()
    {
        boolean isMyAccountPagePresent = true;
        try
        {
            WebElement element = waitForElementToBeVisible(authenticateMyAccount);
            System.out.println("MyAccount checked.");
            //element.isDisplayed();
            element.isDisplayed();
        } catch (Exception ex)
        {
            isMyAccountPagePresent = false;
        }
        return isMyAccountPagePresent;
    }

    /**
     * This function will wait for given elements to be visible. So this would avoid wait timeout.It can be use where ever
     * we have to wait for some items to load.
     */

    public void waitForMyAccountPageToLoad(){

        waitForElementToBeVisible(authenticateMyAccount);
        waitForElementToBeVisible(signOutButton);
    }


     public boolean checkPageExistence(By locator){

        boolean isPresent = waitForElementToBeVisible(locator).isDisplayed();
        return isPresent;
     }

    /**
     * This function will test existence for myAccount Page. This will check if Signout button is present , if yes than my account page is present.
     */

    public void checkMyAccountPageExistence(){
        checkPageExistence(signOutButton);
    }

    /*
    This function will sign out user & would return driver reference of next page.
     */
    public LoginPage clickSignOutButton(){
        clickOnLocator(signOutButton);
        return new LoginPage(getDriver());
    }


}
