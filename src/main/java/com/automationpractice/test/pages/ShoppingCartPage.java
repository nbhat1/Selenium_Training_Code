package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.productCategory.TShirtsCategoryPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neeraj.bhatnagar on 12/8/2016.
 */
public class ShoppingCartPage extends CommanFunction{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());


    private static final By tShirtMouseHover = By.xpath(".//*[@id='center_column']/ul/li/div");
    private static final By addToCartButton = By.xpath(".//*[@title='Add to cart']");



    public boolean isShoopingCartPagePresent(){

        return true;
    }





    public void addMultipleItemsInShoppingCart(){
    //
    }

    public void addMultipleItemsCheckTotal(){

    }

    public void checkShippingCargesMultipleItems(){

    }

    public void increaseItemQuantityFromSCPage(){

    }

    public void increaseItemQuantityCheckTotalSKPage(){

    }

    public void decreaseItemQuantityFromSCPage(){

    }

    public void decreaseItemQuantityCheckTotalSKPage(){

    }

    public void deleteItemFromSCPage(){
        // Check total after deleting shopping cart page.
    }







}
