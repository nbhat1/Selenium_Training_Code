package com.automationpractice.test.pages;


import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.productCategory.DressesCategoryPage;
import com.automationpractice.test.pages.productCategory.TShirtsCategoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
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

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By authenticateMyAccount = By.cssSelector(".navigation_page");
    private static final By signOutButton = By.linkText("Sign out");
    private static final By customerName = By.xpath(".//*[@class='account']/span");
    private static final By womenLink = By.xpath("//*[contains(text(), 'Women') and @class='sf-with-ul']");
    //private static final By tShirtLink = By.xpath("//*[contains(text(), 'T-shirts') and @class='sf-with-ul']");
    private static final By tShirtLink = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    private static final By homeButton = By.xpath(".//*[@class='icon-chevron-left']");
    private static final By homeIcon = By.xpath(".//*[@class='icon-home']");
    private static final By addressButton = By.xpath(".//*[@title='Addresses']");
    private static final By addressIcon = By.xpath(".//*[@title='Addresses']/span");
    private static final By wishlistIcon = By.xpath(".//*[@class='lnk_wishlist']/a/i");
    private static final By wishListButton = By.xpath(".//*[@class='lnk_wishlist']/a/span");
    private static final By tShirtFromHeader = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    private static final By dressesLink = By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a");


    //public String userNameValue = getConfigFileData("userNameValue");


    /* Static values not required as we are using excel sheet for test data.
    public String womenToolTip = "WOMEN";
    public String TshirtsToolTip = "T-shirts";*/


    /**
     * This method will check if MyAccountPage is present or not.
     *
     * @return
     */
    public boolean isMyAccountPagePresent() {
       /* boolean isPageExist =  checkPageExistence(signOutButton);
       return isPageExist;*/
        return checkPageExistence(signOutButton);
    }

    /**
     * This function will wait for given elements to be visible. So this would avoid wait timeout.It can be use where ever
     * we have to wait for some items to load.
     */
    public void waitForMyAccountPageToLoad() {
        waitForElementToBeVisible(authenticateMyAccount);
        waitForElementToBeVisible(signOutButton);
        log.info("Waiting for MyAccount page to load.");
    }


    /**
     * This function will test existence for myAccount Page. This will check if Signout button is present , if yes than my account page is present.
     * Multiple locators can be given in this function to check if page is actually available.
     */
    public void checkMyAccountPageExistence() {
        checkPageExistence(signOutButton);
        checkPageExistence(authenticateMyAccount);
        log.info("Checking if myAccount page is present after login.");
    }

    public boolean checkMyAccountPageExistence1() {
        //checkPageExistence(signOutButton);
        checkPageExistence(authenticateMyAccount);
        log.info("Checking if myAccount page is present after login.");
        return checkPageExistence(signOutButton);
    }

    /*
    *This function will sign out user & would return driver reference of next page.
    */
    public LoginPage clickSignOutButton() throws IOException {
        clickOnLocator(signOutButton);
        log.info("Signout button clicked.");
        return new LoginPage(getDriver());
    }

    /**
     * This function verified name of loggged in user.
     */
    public String getCustomerName() {
        String s = waitForElementToBeVisible(customerName).getText();
        System.out.println(s);
        log.info("Customer Name is " + s);
        return s;
    }

    /**
     * This functionw ill read userName value from excel sheet.
     */
    public String userNameValue() {

        String userName = null;
        try {
            CommanFunction.loadTestDataFile();
            userName = ExcelUtils.getCellData(6, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("User Name value of user is " + userName);
        return userName;
    }

    /**
     * This method will bring user to home page.
     *
     * @return
     */
    public HomePage selectHomeButton() {
        clickOnLocator(homeButton);
        log.info("Home button selected.");
        return new HomePage(getDriver());
    }

    /**
     * This method will bring user to home page.
     *
     * @return
     */

    public HomePage selectHomeIcon() {
        clickOnLocator(homeIcon);
        log.info("Home Icon clicked.");
        return new HomePage(getDriver());
    }

    /**
     * This function selects address button to check address of user.
     */
    public AddressPage selectAddressButton() {
        clickOnLocator(addressButton);
        log.info("Address button clicked.");
        return new AddressPage(getDriver());
    }

    /**
     * This function selects address Icon to check address of user.
     */
    public AddressPage selectAddressIcon() {
        clickOnLocator(addressIcon);
        log.info("Address Icon clicked.");
        return new AddressPage(getDriver());
    }

    /**
     * This function will hoer over on Women category & get text of Women.
     */
    public String getToolTipOfHeaderElementWomen() {
        String toolTip = getTextOfLinkOnMouseHover(womenLink);
        log.info("Tool tip from getToolTipOfHeaderElementWomen functon is " + toolTip);
        return toolTip;
    }

    /**
     * This function will hoer over on Women category & get text of T-Shirt.
     */
    public String getToolTipTShirtLinkFromMouseHoverOnWomenLink() {
        String toolTip = getTextOfLinkOnMouseHover(tShirtLink);
        log.info("Tooltip for getToolTipTShirtLinkFromMouseHoverOnWomenLink function is :-  " + toolTip);
        return toolTip;
    }

    /**
     * This function will check tootltip of Women Link from test data file.
     *
     * @return
     * @throws Exception
     */
    public String womenToolTip() throws Exception {
        CommanFunction.loadTestDataFile();
        String toolTip = ExcelUtils.getCellData(1, 0);
        log.info("Tooltip for womenToolTip function is :-  " + toolTip);
        return toolTip;
    }

    /**
     * This function will return tooltip of tShirts link from test data file.
     *
     * @return
     * @throws Exception
     */
    public String tShirtsToolTip() throws Exception {
        CommanFunction.loadTestDataFile();
        String toolTip = ExcelUtils.getCellData(2, 0);
        log.info("Tooltip for tShirtsToolTip function from test data is :-  " + toolTip);
        return toolTip;
    }

    /**
     * This function will click on TShirts link on mouse hover from women link.
     */
    public TShirtsCategoryPage clickTShirtsLink() {
        clickOnLinkAfterMouseHover(tShirtLink);
        log.info("User clicked" + tShirtLink + "On TShirtsCategoryPage");
        return new TShirtsCategoryPage(getDriver());
    }

    /**
     * This function will click on TShirts link from header
     */
    public TShirtsCategoryPage clickTShirtLinkFromHeader() {
        waitForElementToBeVisible(tShirtFromHeader);
        clickOnLocator(tShirtFromHeader);
        log.info("User clicked" + tShirtFromHeader + "from header");
        return new TShirtsCategoryPage(getDriver());
    }

    /**
     * This function will return Dresses page.
     */
    public DressesCategoryPage clickOnDressesLink(){
        waitForElementToBeVisible(dressesLink);
        clickOnLocator(dressesLink);
        log.info("User Clicked Dresses Link from header");
        return new DressesCategoryPage(getDriver());
    }

    /**
     * This method will click on My Wishlist Page.
     */
    public WishListPage clickOnWishListButton() throws NoSuchElementException {
        try {
            waitForElementToBeVisible(wishListButton);
            clickOnLocator(wishListButton);
            log.info("User clicked " + wishListButton + " button");
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            log.info("Element" + " " + wishListButton + " " + "is not visible.");
        }
        return new WishListPage(getDriver());
    }
}
