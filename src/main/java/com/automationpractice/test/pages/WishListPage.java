package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neeraj.bhatnagar on 12/10/2016.
 */
public class WishListPage extends CommanFunction {


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    private static final By myWishListTitle = By.xpath(".//*[@id='mywishlist']/h1");
    private static final By newWishlistName = By.id("name");


    /**
     * This method will check if MyWishList page is present or not.
     *
     * @return
     */
    public boolean isWishListPagePresent() {
        return checkPageExistence(myWishListTitle);
    }

    /**
     * This function will create new wishlist Create new Wishlist.
     */
    public void createNewWishList() {
        //get values from excel sheet to create new wishlist
        //fillValuesInTextBox(newWishlistName);
    }
}
