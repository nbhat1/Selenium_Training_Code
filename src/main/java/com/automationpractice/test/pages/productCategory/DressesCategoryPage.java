package com.automationpractice.test.pages.productCategory;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.CreateAccountPage;
import com.automationpractice.test.pages.ShoppingCartPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import utilities.ExcelUtils;
import utilities.Excel_Reader;

import java.io.IOException;
import java.util.List;

/**
 * Created by neeraj.bhatnagar on 12/12/2016.
 */
public class DressesCategoryPage extends CommanFunction{

    public DressesCategoryPage(WebDriver driver){
        super(driver);
    }

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By hoverOnChiffonDress = By.xpath(".//*[@id='center_column']/ul/li[5]/div");
    private static final By addToCartButton = By.xpath(".//*[@id='center_column']/ul/li[5]/div/div[2]/div[2]/a[1]/span");
    private static final By continueShoppingButton = By.xpath(".//*[@title='Continue shopping']");
    private static final By shoppingCartTable = By.xpath(".//*[@id='cart_summary']");
    private static final By proceedToCheckOutButton = By.xpath(".//*[@title='Proceed to checkout']");

    /**
     * Add summer dress in shopping cart.
     */
    public ShoppingCartPage addSummerDressInShoppingCart(){
        mouseHover(hoverOnChiffonDress);
        clickOnLocator(addToCartButton);
        log.info("Summer dress added in cart.");
        clickOnLocator(proceedToCheckOutButton);
        return new ShoppingCartPage(getDriver());
    }

    /**
     * Title of dress Item added in shopping cart.
     */
    public String titleOfItemAddedInSC() throws Exception {
        CommanFunction.loadTestDataFile();
        String newItemTitle = ExcelUtils.getCellData(9, 0);
        log.info("Item title added in Shopping cart from excel is " + newItemTitle);
        return newItemTitle;
    }

    /**
     * This function will check if item from dress page added in Shopping Cart successfully.
     */
    public String isItemAddedInShoppingCart() throws Exception {
        String itemTitle = titleOfItemAddedInSC();
        WebElement cartTable = driver.findElement(shoppingCartTable);
        List<WebElement> rows = cartTable.findElements(By.tagName("tr"));
        String celText = null;
        String mytext = null;
        for (int row = 0; row < rows.size(); row++) {
            boolean success = false;
            List<WebElement> columns_row = rows.get(row).findElements(By.tagName("td"));
            for (int col = 0; col < columns_row.size(); col++) {
                if (success) {
                    break;
                }
                celText = columns_row.get(col).getText();
                String text[] = celText.split("\n");
                for (int i = 0; i < text.length; i++) {
                    mytext = text[i];
                    System.out.println(mytext);
                    if (mytext.equals(itemTitle)) {
                        log.info("Item found in shopping cart");
                        success = true;
                        break;
                    } else {
                        log.info("Item does not found in shopping cart.");
                    }
                }
            }
        }
        return mytext;
    }

}

