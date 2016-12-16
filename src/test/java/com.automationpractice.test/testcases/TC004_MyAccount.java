package com.automationpractice.test.testcases;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.LoginPage;
import com.automationpractice.test.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by neeraj.bhatnagar on 12/13/2016.
 */
public class TC004_MyAccount {

    WebDriver driver;
    // HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CommanFunction commanFunction;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {

        commanFunction = new CommanFunction(driver);
        loginPage = commanFunction.clickSignInButton();
        //myAccountPage = loginPage.successFulLogin();
        myAccountPage = loginPage.successFulLogin();
    }

    @Test(priority = 1)
    public void verifyToolTip(){
        /* Using static value in MyAccountPage
        assertEquals( myAccountPage.getToolTipOfHeaderElementWomen(), myAccountPage.womenToolTip, "Tool Tip not matching for Women link" );
        assertEquals( myAccountPage.getToolTipOfHeaderElementTShirt(),myAccountPage.TshirtsToolTip,"Tool Tip is not matching for TShirts link" );*/
        try {
            assertEquals( myAccountPage.getToolTipOfHeaderElementWomen(),myAccountPage.womenToolTip() );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 0)
    public void verifyUserName(){
       assertEquals( myAccountPage.userNameValue, myAccountPage.getCustomerName(), "User name value do not match.Please check test again." );
       //assertTrue( myAccountPage.userNameValue.contains("Nraj"), "User Name values do not match.Please check again."); // This assertion will fail as username values do not match

    }

    @AfterClass
    public void tearDown(){
        commanFunction.closeDriver();
        System.out.println("Driver closed");
    }
}
