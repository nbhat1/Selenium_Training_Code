package com.automationpractice.test.testcases;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.LoginPage;
import com.automationpractice.test.pages.MyAccountPage;
import com.automationpractice.test.pages.WishListPage;
import com.automationpractice.test.pages.productCategory.DressesCategoryPage;
import com.automationpractice.test.pages.productCategory.TShirtsCategoryPage;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 1/31/2017.
 */
public class TC006_MyShoppingCart {

    WebDriver driver;
    CommanFunction commanFunction;
    MyAccountPage myAccountPage;
    TShirtsCategoryPage tShirtsCategory;
    LoginPage loginPage;
    WishListPage wishList;
    DressesCategoryPage dressPage;

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
        myAccountPage = loginPage.successFulLogin();

        DOMConfigurator.configure("src/test/log4j.xml");
    }

    @Test(priority = 0)
    public void addItemInSCFromTShirtsPageContinueShopping() throws Exception {
        tShirtsCategory = myAccountPage.clickTShirtLinkFromHeader();
        tShirtsCategory.addItemInSoppingCartAndContinueShopping();
      //  tShirtsCategory.isItemAddedInShoppingCart();
    }

    @Test(dataProvider = "itemData",dataProviderClass=TShirtsCategoryPage.class, priority = 1)
    public void addItemInSCFromTShirtPageCheckOut(String itemTitle) throws Exception {
        tShirtsCategory = myAccountPage.clickTShirtLinkFromHeader();
        tShirtsCategory.addItemInSoppingCartAndCheckout();
        dressPage = myAccountPage.clickOnDressesLink();
        dressPage.addSummerDressInShoppingCart();
        Assert.assertTrue(tShirtsCategory.isItemAddedInShoppingCart(itemTitle), "Expected and Actual values are not matching");
    }

    @Test(priority = 2)
    public void addItemInSCFromDressPage() throws Exception {
        dressPage = myAccountPage.clickOnDressesLink();
        dressPage.addSummerDressInShoppingCart();
        Thread.sleep(2000);
        Assert.assertEquals(dressPage.isItemAddedInShoppingCart(), dressPage.titleOfItemAddedInSC(), "This is not right");
    }

    @AfterClass
    public void tearDown(){
        commanFunction.closeDriver();
        System.out.println("Driver closed");
    }
}
