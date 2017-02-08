package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ExcelUtils;

import java.util.List;

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
    private static final By deleteWishList = By.xpath(".//*[contains(text(),'MyWishList1')]/../following-sibling::td[contains(@class,\"wishlist_delete\")]/a/i");
    private static final By wishListTable = By.xpath(".//*[@id='block-history']/table");
    //private static final By wishListTableElements = By.xpath(".//*[@id='block-history']");

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

    /**
     * Check if wishlist added after adding a new wishlist.
     */
    /*public boolean checkWishListAfterAddingNew() throws Exception {

        boolean textPresent = false;
        CommanFunction.loadTestDataFile();
        String newWishListTitle = ExcelUtils.getCellData(3, 0);
        WebElement mytable = driver.findElement(By.xpath("./[@id='block-history']"));
        List<WebElement> rows = mytable.findElements(By.tagName("tr"));
      //  int rows_count = rows.size();
        for (int row=0; row<rows.size(); row++){
            List<WebElement> columns_row = rows.get(row).findElements(By.tagName("td"));
            System.out.println(("number of cells in row " + row + columns_row.size() ));
            for(int col=0;col<columns_row.size();col++){
                String celText = columns_row.get(col).getText();
            // log.info(celText);
                if(celText.equals(newWishListTitle)){
                    log.info("New Wishlist item created successfully");
                    textPresent = true;
                    break;
                }
                else{
                    textPresent = false;
                    log.info("Wishlist not found.");
                }
            }
        }
        return textPresent;
    }*/

    /**
     * This function will return string to be used to create Wishlist.
     */
    public String wishListTitle() throws Exception {
        CommanFunction.loadTestDataFile();
        String newWishListTitle = ExcelUtils.getCellData(3, 0);
        System.out.println("wishlist name from excel is " + newWishListTitle);
        return newWishListTitle;
    }

    /**
     * This function will check if wishlist added successfully.
     */
    public String checkWishListAfterAddingNew() throws Exception {

        String wishListTitle = wishListTitle();
        WebElement mytable = driver.findElement(By.xpath("./*//*[@id='block-history']"));
        List<WebElement> rows = mytable.findElements(By.tagName("tr"));
        //  int rows_count = rows.size();
        String celText = null;
        for (int row = 0; row < rows.size(); row++) {
            List<WebElement> columns_row = rows.get(row).findElements(By.tagName("td"));
            System.out.println(("number of cells in row " + row + columns_row.size()));
            for (int col = 0; col < columns_row.size(); col++) {
                celText = columns_row.get(col).getText();
                System.out.println("Text in cell is " + celText);
                if (celText.equals(wishListTitle)) {
                    log.info("New WishList item created successfully");
                    break;
                } else {
                    log.info("WishList not found.");
                }
            }
        }
        return celText;
    }

    /**
     * This function will delete created wishlist.
     */
    public void deleteWishListItem() {

        clickOnLocator(deleteWishList);
        log.info("Delete Icon clicked");
        String alertText1 = null;
        try {
            CommanFunction.loadTestDataFile();
            alertText1 = ExcelUtils.getCellData(7, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (alertText().equals(alertText1)){
            acceptAlert();
            log.info("Alert text matched with actual & expected.");
            log.info("WishList deleted successfully.");
        }else {
            rejectDeleteWishlistPopUp();
            log.info("Wishlist item delete popup rejected.");
        }
    }

    /**
     * This function will reject delete wishlist pop up.
     */
    public void rejectDeleteWishlistPopUp(){
        clickOnLocator(deleteWishList);
        rejectAlert();
        log.info("Wishlist didn't deleted, Pop up dismissed.");
    }

    /**
     * This function will check that wishlist table should be deleted if no wishlist is present.
     */
    public boolean isWishListTablePresent(){
      return isElementPresent(wishListTable);
    }
}
