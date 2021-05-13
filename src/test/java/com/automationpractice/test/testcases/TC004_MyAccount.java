package com.automationpractice.test.testcases;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.CreateAccountPage;
import com.automationpractice.test.pages.LoginPage;
import com.automationpractice.test.pages.MyAccountPage;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
        myAccountPage = loginPage.successFulLogin();
        DOMConfigurator.configure("src/test/log4j.xml");
    }

    @Test(priority = 2, enabled = true, description = "This test will check tooltip on page.")
    public void verifyToolTip() {
        /* Using static value in MyAccountPage
        assertEquals( myAccountPage.getToolTipOfHeaderElementWomen(), myAccountPage.womenToolTip, "Tool Tip not matching for Women link" );
        assertEquals( myAccountPage.getToolTipTShirtLinkFromMouseHoverOnWomenLink(),myAccountPage.TshirtsToolTip,"Tool Tip is not matching for TShirts link" );*/
        try {
            //assertEquals(myAccountPage.getToolTipOfHeaderElementWomen(),myAccountPage.womenToolTip(), "Tool Tip not matching for Women link");
            assertEquals(myAccountPage.getToolTipTShirtLinkFromMouseHoverOnWomenLink(), myAccountPage.tShirtsToolTip(), "Tool Tip is not matching for TShirts link");
            //assertEquals(myAccountPage.tShirtsToolTip(), myAccountPage.getToolTipTShirtLinkFromMouseHoverOnWomenLink(), "Tool Tip is not matching for TShirts link");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1, enabled = true, description = "This test will verify user name on page. ")
    public void verifyUserName() {
        assertEquals(myAccountPage.getCustomerName(),myAccountPage.userNameValue(), "User name value do not match.Please check test again.");
        //assertTrue( myAccountPage.userNameValue.contains("Nraj"), "User Name values do not match.Please check again."); // This assertion will fail as username values do not match
        // Assert.fail( "verifyUserName test failes , please check screenshot." );
    }

    @AfterClass
    public void tearDown() {
        commanFunction.closeDriver();
        System.out.println("Driver closed");
    }
}
