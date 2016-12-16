package com.automationpractice.test.pages;


import com.automationpractice.test.common.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ExcelUtils;

import java.io.IOException;

/**
 * Created by Neeraj on 26-11-2016.
 */
public class MyAccountPage extends CommanFunction {

    //WebDriver driver;

        public MyAccountPage(WebDriver driver) throws IOException {
        super(driver);
        //this.driver = driver;
    }

    private static final By authenticateMyAccount = By.cssSelector(".navigation_page");
    private static final By signOutButton = By.linkText("Sign out");
    private static final By customerName = By.xpath(".//*[@class='account']/span");
    private static final By womenLink = By.xpath("//*[contains(text(), 'Women') and @class='sf-with-ul']");
    //private static final By tShirtLink = By.xpath("//*[contains(text(), 'T-shirts') and @class='sf-with-ul']");
    private static final By tShirtLink = By.xpath( ".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a" );
    private static final By homeButton = By.xpath(".//*[@class='icon-chevron-left']");
    private static final By homeIcon = By.xpath(".//*[@class='icon-home']");
    private static final By addressButton = By.xpath(".//*[@title='Addresses']");
    private static final By addressIcon = By.xpath(".//*[@title='Addresses']/span");


    public String userNameValue = getConfigFileData("userNameValue");
    /* Static values not required as we are using excel sheet for test data.
    public String womenToolTip = "WOMEN";
    public String TshirtsToolTip = "T-shirts";*/


    /**
     * This method will check if MyAccountPage is present or not.
     * @return
     */
    public boolean isMyAccountPagePresent(){
       /* boolean isPageExist =  checkPageExistence(signOutButton);
       return isPageExist;*/
       return checkPageExistence(signOutButton);
    }

     /**
     * This function will wait for given elements to be visible. So this would avoid wait timeout.It can be use where ever
     * we have to wait for some items to load.
     */
    public void waitForMyAccountPageToLoad(){

        waitForElementToBeVisible(authenticateMyAccount);
        waitForElementToBeVisible(signOutButton);
    }


    /**
     * This function will test existence for myAccount Page. This will check if Signout button is present , if yes than my account page is present.
     * Multiple locators can be given in this function to check if page is actually available.
     */
    public void checkMyAccountPageExistence(){
        checkPageExistence(signOutButton);
        checkPageExistence(authenticateMyAccount);
    }

    /*
    *This function will sign out user & would return driver reference of next page.
    */
    public LoginPage clickSignOutButton() throws IOException {
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
     * This method will bring user to home page.
     * @return
     */
    public HomePage selectHomeButton(){
        clickOnLocator(homeButton);
        return new HomePage(getDriver());
    }

    /**
     * This method will bring user to home page.
     * @return
     */

    public HomePage selectHomeIcon(){
        clickOnLocator(homeIcon);
        return new HomePage(getDriver());
    }

    /**
     * This function selects address button to check address of user.
     */
    public AddressPage selectAddressButton(){
        clickOnLocator(addressButton);
        return new AddressPage(getDriver());
    }

    /**
     * This function selects address Icon to check address of user.
     */
    public AddressPage selectAddressIcon(){
        clickOnLocator(addressIcon);
        return new AddressPage(getDriver());
    }

    /**
     * This function will hoer over on Women category & get text of Women.
     */
    public String getToolTipOfHeaderElementWomen(){
       String toolTip = clickOnLinkOnMouseHover(womenLink);
       return toolTip ;
    }

    /**
     * This function will hoer over on Women category & get text of T-Shirt.
     */
    public String getToolTipOfHeaderElementTShirt(){
        String toolTip = clickOnLinkOnMouseHover(tShirtLink);
        return toolTip ;
    }

    public String womenToolTip() throws Exception {
        CommanFunction.loadTestDataFile();
        String toolTip= ExcelUtils.getCellData( 1,0 );
        return toolTip;
    }

    public String tShirtsToolTip() throws Exception {
        CommanFunction.loadTestDataFile();
        String toolTip= ExcelUtils.getCellData( 2,0 );
        return toolTip;
    }

}
