package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 * This class will store all locator & methods of home page
 */
public class HomePage extends CommanFunction
{
    //WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    //public static final By selectSignIn=By.xpath(".//*[@class='login']");
    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());

}
