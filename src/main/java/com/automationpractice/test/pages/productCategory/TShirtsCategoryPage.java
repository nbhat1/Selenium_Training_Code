package com.automationpractice.test.pages.productCategory;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.CreateAccountPage;
import com.automationpractice.test.pages.MyAccountPage;
import com.automationpractice.test.pages.ShoppingCartPage;
import com.sun.deploy.security.DeployURLClassPathCallback;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
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
public class TShirtsCategoryPage extends CommanFunction {

    public TShirtsCategoryPage() {

    }

    public TShirtsCategoryPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());
    private static final By tShirtMouseHover = By.xpath(".//*[@id='center_column']/ul/li/div");
    private static final By addToWishList = By.xpath(".//*[@class='addToWishlist wishlistProd_1']");
    private static final By wishListConformation = By.cssSelector(".fancybox-error");
    private static final By closeWishListConfirmation = By.xpath(".//*[@class='fancybox-item fancybox-close']");
    private static final By quickViewLink = By.xpath(".//*[@class='quick-view']");
    private static final By tShirtPrice = By.xpath(".//*[@class='price product-price']");
    private static final By addToCartButton = By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default>span");
    private static final By moreButton = By.linkText("More");
    private static final By tshirtTitle = By.xpath(".//*[@class='product_img_link']");
    private static final By myAccountLink = By.xpath(".//*[@class='account']/span");
    private static final By tShirtsCategoryName = By.xpath(".//*[@class='cat-name']");
    private static final By TShirtsLink = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
    private static final By proceedToCheckOutButton = By.xpath(".//*[@title='Proceed to checkout']");
    private static final By continueShoppingButton = By.xpath(".//*[@title='Continue shopping']");
    private static final By shoppingCartTable = By.xpath(".//*[@id='cart_summary']/tbody");

    /**
     * This function will mouse hover on a Tshirt item on page & select add to wishlist link.
     */
    public void addItemToWishList() {
        //clickOnLinkAfterMouseHover(addToWishList);
        mouseHover(tShirtMouseHover);
        clickOnLocator(addToWishList);
        log.info("Item successfully added to Wishlist");
    }

    /**
     * This method will check if TshirtCategory page is present or not.
     *
     * @return
     */
    public boolean isTShirtCategoryPagePresent() {
        log.info("Verify if isTShirtCategory page present.");
        return checkPageExistence(tShirtsCategoryName);
    }

    /**
     * Verify Item added to wishlist confirmation diaglog after adding an item in wishlist.
     */
    public void wishListConfirmationDiaglog() {

    }

    /***
     * This function will close Item added to Wishlist confirmation modal.
     */
    public void closeWishListConfirmationDialog() {
        waitForElementToBeVisible(closeWishListConfirmation);
        clickOnLocator(closeWishListConfirmation);
        log.info("Wishlist confirmation diaglog closed.");

    }

    /**
     * This function will click on MyAccount.
     */
    public MyAccountPage clickMyAccountLink() throws IOException {
        try {
            waitForElementToBeVisible(myAccountLink);
            clickOnLocator(myAccountLink);
            log.info("User clicked " + myAccountLink + "successfully");
        } catch (ElementNotVisibleException e) {
            e.getMessage();
            log.info(myAccountLink + " is not visible on page");
        }
        return new MyAccountPage(getDriver());
    }

    /**
     * Add item inm shopping cart & checkout.
     * @return
     */
    public ShoppingCartPage addItemInSoppingCartAndCheckout(){
    //    clickOnLocator(TShirtsLink);
        mouseHover(tShirtMouseHover);
        clickOnLocator(addToCartButton);
        log.info("Faded Short Sleeve Tshirt added in cart");
        waitForElementToBeVisible(proceedToCheckOutButton);
        clickOnLocator(proceedToCheckOutButton);
        return new ShoppingCartPage(getDriver());
    }

    /**
     * Add item in shopping cart & continue shopping.
     */
    public void addItemInSoppingCartAndContinueShopping() throws InterruptedException {
        clickOnLocator(TShirtsLink);
        //Thread.sleep(5000);
        mouseHover(tShirtMouseHover);
        //Thread.sleep(5000);
        //waitForElementToBeVisible(addToCartButton);
        clickOnLocator(addToCartButton);
        log.info("Tshirt added in cart");
        waitForElementToBeVisible(continueShoppingButton);
        clickOnLocator(continueShoppingButton);
    }

    /**
     * Title of Item added in shopping cart.
     */
    public String titleOfItemAddedInSC() throws Exception {
        CommanFunction.loadTestDataFile();
        String newItemTitle = ExcelUtils.getCellData(8, 0);
        log.info("Item title added in Shopping cart from excel is " + newItemTitle);
        return newItemTitle;
        }

    /**
     * This function will check if items added in Shopping Cart successfully.
     */
    public boolean isItemAddedInShoppingCart(String itemTitle) throws Exception {
        //String itemTitle = titleOfItemAddedInSC();
        WebElement cartTable = driver.findElement(shoppingCartTable);
        List<WebElement> rows = cartTable.findElements(By.tagName("tr"));
        String celText = null;
        String mytext = null;
        boolean success = false;
        for (int row = 0; row < rows.size(); row++) {
            //success = false;
            if (success) {
                break;
            }
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
                        //log.info("Item does not found in shopping cart.");
                    }
                }
            }
        }
        return success;
    }

    /**
     * Data provider
     * @return
     * @throws IOException
     */
    @DataProvider
    public Object[][] itemData() throws IOException {
        Object[][] data = getData("testData.xlsx","itemTitleSheet");
        return data;
    }

    /**
     * Function for data provider.
     * @param workBookName
     * @param SheetName
     * @return
     * @throws IOException
     */
    public Object[][] getData(String workBookName, String SheetName) throws IOException {
        Excel_Reader data = new Excel_Reader(System.getProperty("user.dir")+"\\testdata\\"+workBookName);
        int rowNum = data.getRowCount(SheetName);
        System.out.println("Row number is "+rowNum);
        int colNum = data.getColumnCount(SheetName);
        System.out.println("Columan Number is "+colNum);
        Object sampleData[][] = new Object[rowNum-1][colNum];
        for(int i =2; i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                sampleData[i-2][j]=data.getCellData(SheetName,j,i);
            }
        }
        return sampleData;
    }
}
