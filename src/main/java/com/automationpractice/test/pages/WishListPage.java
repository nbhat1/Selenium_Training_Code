package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ExcelUtils;

/**
 * Created by neeraj.bhatnagar on 12/10/2016.
 */
public class WishListPage extends CommanFunction {


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By myWishListTitle = By.xpath(".//*[@id='mywishlist']/h1");
    private static final By newWishlistName = By.id("name");
    private static final By saveNewWishListButton = By.xpath(".//*[@id='submitWishlist']");


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
    public void createNewWishList() throws Exception {
        CommanFunction.loadTestDataFile();
        String newWishListTitle = ExcelUtils.getCellData(3, 0);
        //log.info("Tooltip for tShirtsToolTip function from test data is :-  " + toolTip);
        fillValuesInTextBox(newWishlistName,newWishListTitle);
        log.info("New WishList created is  :-  " + newWishListTitle);
    }

    /**
     * Click Save Wishlist button.
     */
    public void clickSaveWishListButton(){
        clickOnLocator(saveNewWishListButton);
        log.info("New Wishlist saved.");
    }
}
