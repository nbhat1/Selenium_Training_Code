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

    private static final By authenticateMyAccount = By.cssSelector(".navigation_page");
    private static final By signOutButton = By.linkText("Sign out");
    private static final By customerName = By.xpath(".//*[@class='account']/span");
    private static final By womenLink = By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a");
    private static final By tshirtLink = By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a");
    private static final By homeButton = By.xpath(".//*[@class='icon-chevron-left']");
    private static final By homeIcon = By.xpath(".//*[@class='icon-home']");


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
    *This function will sign out user & would return driver reference of next page.
    */
    public LoginPage clickSignOutButton(){
        clickOnLocator(signOutButton);
        return new LoginPage(getDriver());
    }

    /**
     * This function verified name of loggged in user.
     */
    public String getCustomerName(){
        String s = waitForElementToBeVisible(customerName).getText();
        System.out.println(s);
        return s;
    }

    /**
     * This method will click in Tshirt link on mouse hover.
     * @return
     */
    public WomenPage clickTshirtLink(){
        mouseHover(womenLink);

        return new WomenPage(getDriver());
    }

    /**
     * This method will bring user to home page.
     * @return
     */
    public HomePage clickHomeButton(){
        clickOnLocator(homeButton);
        return new HomePage(getDriver());
    }

    /**
     * This method will bring user to home page.
     * @return
     */

    public HomePage clickonHomeIcon(){
        clickOnLocator(homeIcon);
        return new HomePage(getDriver());
    }

}
