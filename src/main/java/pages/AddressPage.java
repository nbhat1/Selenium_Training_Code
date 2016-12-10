package pages;

import comman.CommanFunction;
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

    /**
     * This function checks if Address page is present. If given locator is present it means page is present.
     * @return
     */
    public boolean isAddressPagePresent(){
        return checkPageExistence(myAddressText);
    }




}
