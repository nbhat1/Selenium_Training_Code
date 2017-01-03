package com.automationpractice.test.testcases;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.LoginPage;
import com.automationpractice.test.pages.MyAccountPage;
import com.automationpractice.test.pages.productCategory.TShirtsCategoryPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 12/21/2016.
 */
public class TC005_MyWishlist {

    WebDriver driver;
    CommanFunction commanFunction;
    MyAccountPage myAccountPage;
    TShirtsCategoryPage tShirtsCategory;
    LoginPage loginPage;

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
        myAccountPage = loginPage.successFulLogin();

        DOMConfigurator.configure("src/test/log4j.xml");
    }

    @Test
    public void addItemToWishList() throws IOException {
        try {
            tShirtsCategory = myAccountPage.clickTShirtLinkFromHeader(); // This will get driver from myAccount Page.
            tShirtsCategory.isTShirtCategoryPagePresent();
            tShirtsCategory.addItemToWishList();
            tShirtsCategory.closeWishListConfirmationDialog();
            tShirtsCategory.clickMyAccountLink();
            myAccountPage.clickOnWishListButton();
        } catch (NoSuchElementException e) {
        }
    }

    @Test
    public void createNewWishList(){

    }


    /*@AfterClass
    public void tearDown(){
        commanFunction.closeDriver();
        System.out.println("Driver closed");
    }*/

}
