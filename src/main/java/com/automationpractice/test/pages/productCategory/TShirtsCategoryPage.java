package com.automationpractice.test.pages.productCategory;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.CreateAccountPage;
import com.automationpractice.test.pages.MyAccountPage;
import com.sun.deploy.security.DeployURLClassPathCallback;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 12/12/2016.
 */
public class TShirtsCategoryPage extends CommanFunction {

    /*public TShirtsCategoryPage() {

    }*/

    public TShirtsCategoryPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }


    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By tShirtMouseHover = By.xpath(".//*[@id='center_column']/ul/li/div");
    private static final By addToWishList = By.xpath(".//*[@class='addToWishlist wishlistProd_1']");
    private static final By wishListConformation = By.cssSelector(".fancybox-error");
    private static final By closeWishListConfirmation = By.xpath(".//*[@class='fancybox-item fancybox-close']");
    private static final By quickViewLink = By.xpath(".//*[@class='quick-view']");
    private static final By tShirtPrice = By.xpath(".//*[@class='price product-price']");
    private static final By addToCartButton = By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span");
    private static final By moreButton = By.linkText("More");
    private static final By tshirtTitle = By.xpath(".//*[@class='product_img_link']");
    private static final By myAccountLink = By.xpath(".//*[@class='account']/span");
    private static final By tShirtsCategoryName = By.xpath(".//*[@class='cat-name']");

    /**
     * This function will mouse hover on a Tshirt item on page & select add to wishlist link.
     */
    public void addItemToWishList() {
        //clickOnLinkAfterMouseHover(addToWishList);

        mouseHover(tShirtMouseHover);
        clickOnLocator(addToWishList);
        log.info("Item successfully added to Wishlist");
    }

    /**
     * This method will check if TshirtCategory page is present or not.
     *
     * @return
     */
    public boolean isTShirtCategoryPagePresent() {
        log.info("Verify if isTShirtCategory page present.");
        return checkPageExistence(tShirtsCategoryName);
    }

    /**
     * Verify Item added to wishlist confirmation diaglog after adding an item in wishlist.
     */
    public void wishListConfirmationDiaglog() {

    }


    /***
     * This function will close Item added to Wishlist confirmation modal.
     */
    public void closeWishListConfirmationDialog() {
        waitForElementToBeVisible(closeWishListConfirmation);
        clickOnLocator(closeWishListConfirmation);
        log.info("Wishlist confirmation diaglog closed.");

    }

    /*public void titleOfTshirt(){
        //String title = tshirtTit

        WebElement elemment = driver.findElement(By.xpath("./*//*[@class='product_img_link']"))
                String title = element.getAttribute("title");
    }*/


    /**
     * This function will click on MyAccount.
     */
    public MyAccountPage clickMyAccountLink() throws IOException {
        try {
            waitForElementToBeVisible(myAccountLink);
            clickOnLocator(myAccountLink);
            log.info("User clicked " + myAccountLink + "successfully");
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            log.info(myAccountLink + " is not visible on page");
        }
        return new MyAccountPage(getDriver());
    }
}
