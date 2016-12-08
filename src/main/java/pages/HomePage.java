package pages;

import comman.CommanFunction;
import org.openqa.selenium.WebDriver;

/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 * This class will store all locator & methods of home page
 */
public class HomePage extends CommanFunction
{
    //WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //public static final By selectSignIn=By.xpath(".//*[@class='login']");

   /*
    This function will click SignIn button on home page. This funtion returns LoginPage where user can create a new user
    or login with credentials of existing user.This function is
   */

//    public LoginPage clickSignInButton(){
//
//        driver = CommanFunction.invokeApplication();
//        WebElement element = driver.findElement(selectSignIn);
//        element.click();
//        System.out.println("Sign In button clicked on Home Page.");
//        return new LoginPage(driver);
//
//    }
}
