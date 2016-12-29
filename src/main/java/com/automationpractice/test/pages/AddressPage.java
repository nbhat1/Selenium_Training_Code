package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by neeraj.bhatnagar on 12/8/2016.
 */
public class AddressPage extends CommanFunction{


    public AddressPage(WebDriver driver) {
        super( driver );
    }

    private static final By myAddressText = By.xpath(".//*[@class='page-subheading']");
    private static final By womenLink = By.xpath("//*[contains(text(), 'Women') and @class='sf-with-ul']");


    /**
     * This function checks if Address page is present. If given locator is present it means page is present.
     * @return
     */
    public boolean isAddressPagePresent(){
        return checkPageExistence(myAddressText);
    }

    public void waitForAddresPageToLoad()
    {
        waitForElementToBeVisible(womenLink);
        waitForElementToBeVisible( myAddressText );


    }






}
