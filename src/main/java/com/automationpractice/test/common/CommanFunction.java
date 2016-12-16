package com.automationpractice.test.common;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.interactions.Actions;
import com.automationpractice.test.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelUtils;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Properties;


/**
 * Created by neeraj.bhatnagar on 11/22/2016.
 */
public class CommanFunction {
    //public static WebDriver driver=null;

    protected static WebDriver driver;
    protected static int waitForElementPresentTimeout = 40;
    //private static String appURL = "http://automationpractice.com/index.php";
    private static final By selectSignIn = By.xpath(".//*[@class='login']");
    //public static final By signOutButton = By.linkText("Sign out");
    static Properties properties;


    public CommanFunction(WebDriver driver) {
        this.driver = driver;
    }


    /*
    Load config file.
     */

    public static void LoadConfigFile() throws IOException {

        properties = new Properties();
        File file = new File(System.getProperty("user.dir") + "\\config.properties");
        //System.out.println("file path is "+ " " + file);
        FileReader obj = new FileReader(file);
        properties.load(obj);

    }

    /**
     * This fnunction will load test data file.Test data file is in .xlsx format.
     */

    public static void loadTestDataFile() throws Exception {
        //ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        ExcelUtils.setExcelFile(System.getProperty("user.dir")+"\\testdata\\testData.xlsx","Sheet1");

    }

    /**
     * Get data from config file.
     */

    /*public static String getConfigFileData(String Data) throws IOException {

        LoadConfigFile();
        String data = properties.getProperty(Data);
        // System.out.println(data);
        return data;
    }*/

    public static String getConfigFileData(String Data) throws IOException {
        String data=null;
        try {
            LoadConfigFile();
            data = properties.getProperty(Data);
        } catch(FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();

        }
        // System.out.println(data);
        return data;
    }

    /**
     * This function will invoke application & initialize driver.
     */
    public static WebDriver invokeApplication() throws IOException, InterruptedException {
        String browser = getConfigFileData("browserType"); // Since getConfigFileData is returning String so we use String type variable browser
        driver = selectBrowserToTest(browser); // selectBrowserToTest method is returning driver so we use that driver here.
        driver.get(getConfigFileData("applicationURL")); // driver will invoke application.
        return driver;
    }

     /*
    This simple function will pass values in text boxes. using locator & text. Usage of this locator can be found in
     Login Page & CreateAccount Page.
     */
     public void fillValuesInTextBox(By locator, String textBoxData) {
        waitForElementToBeVisible(locator).clear();
        waitForElementToBeVisible(locator).sendKeys(textBoxData);
    }


    /**
     * Function to select browser from config file.
     */

    public static WebDriver selectBrowserToTest(String browserType) throws IOException {
        WebDriver driver = null;
        switch (browserType) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\GecoDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;

                /*case "IE":
                    System.setProperty("webdriver.ie.driver", System.getProperty("user.dir"));
                    driver = new InternetExplorerDriver();
                    */
            default:
        }
        return driver;
    }

    /*
    This function wait for the element to be visible.
     */

    protected WebElement waitForElementToBeVisible(final By locator) {
        WebElement element = null;
        try {
            element = getWebElement(locator);
        } catch (Exception ex) {
            //CustomReporter.debug("waitForElementToBePresent locator (" + locator.toString() + ")");
            try {
                WebDriverWait webDriverWait = new WebDriverWait(getDriver(), waitForElementPresentTimeout);
                element = webDriverWait.ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.presenceOfElementLocated(locator));
            } catch (Exception e) {

                element = getWebElement(locator);
            }
        }
        return element;
    }

    /**
     * This is to get the web element
     *
     * @param locator
     * @return
     */
    private WebElement getWebElement(By locator) {
        WebElement element;
        //CustomReporter.debug("waitForElementToBeVisible locator (" + locator.toString() + ")");
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), waitForElementPresentTimeout);
        element = webDriverWait.ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

   /*
  This simple function will click on a locator
  */
    public void clickOnLocator(By locator) {
        waitForElementToBeVisible(locator).click();
    }

    /**
     * This fucntoin will click on child element on a menu which presents on mouse hover
     * MouseHover handling.
     * Check it with Aditya
     */

    public void mouseHover(By locator){
        Actions action = new Actions(getDriver());
        WebElement element =  waitForElementToBeVisible(locator);
        action.moveToElement(element).build().perform();
    }


    /**
     * This simple function will select a radio button.
     */
    public void selectRadioButton(By locator) {
        //public boolean checkRadioButtonSelected();
        boolean radioButtonState = waitForElementToBeVisible(locator).isSelected();
        if (radioButtonState = false) {
            waitForElementToBeVisible(locator).click();
        } else {
            System.out.println("Radio button / Checkbox is already selected.");
        }
    }

    /*
    This function will check value of pre-filled text.
    Get it reviewed by Aditya.
     */

    public void checkPreFilledTextBoxEntries(By locator, String preFilledEmail) {
        String textValue = waitForElementToBeVisible(locator).getAttribute("value");
        if (textValue.equals(preFilledEmail)) {
            System.out.println("PreFilled Email is matching");
        } else {
            //Find out how we can use reusable function fillValuesInTextBox to fill email if it ss not matching.
            System.out.println("values are not Matching");
        }
    }

    /*
    This function will select value from dropdown list.
    Get it reviewed by Aditya.
     */
    public void selectValueFromDropDownList(By locator, String dropDownValue) {
        WebElement element = waitForElementToBeVisible(locator);
        Select select = new Select(element);
        select.selectByValue(dropDownValue);
    }

    /*
    This function will return reference of driver to other pages.
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     *This method is used to invoke application & click SignIn button on home page.
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public LoginPage clickSignInButton() throws IOException, InterruptedException {

        //WebDriver driver;
        driver = invokeApplication();
        WebElement element = driver.findElement(selectSignIn);
        element.click();
        //System.out.println("Sign In button clicked on Home Page.");
        return new LoginPage(driver);

    }

    public void closeDriver() {
        //driver.close();
        //getDriver().close();
        driver.quit();
    }

    /**
     * This method will check if page exists. If given locator is present it means page is present.
     * @param locator
     * @return
     */
    public boolean checkPageExistence(By locator)
    {
        boolean isPagePresent = false;
        try
        {
            isPagePresent = waitForElementToBeVisible(locator).isDisplayed();

        } catch (NoSuchElementException e)
        {
            isPagePresent = false;
        }
        return isPagePresent;
    }

    /**
     * This function will check if logo is present or not. This function should be used to logo on each page.
     * Precondition to this is that logo should be present in header.
     */

    public boolean checkLogo(By locator){

        boolean isLogoPresent = false;
        try {
            waitForElementToBeVisible( locator );
        } catch (NoSuchElementException e) {
            isLogoPresent = false;
        }
        return isLogoPresent;

    }

    /**
     * This function will use Action class to mouse hover an element.
     */
    public String clickOnLinkOnMouseHover(By locator){
        String text = null;
        try {
            Actions actions = new Actions(getDriver());
            WebElement headerHoverLink = waitForElementToBeVisible(locator);
            actions.moveToElement(headerHoverLink).perform();
            text = waitForElementToBeVisible(locator).getText();
            System.out.println( "Tool tip is :" + " " + text );
        } catch (ElementNotVisibleException e) {
            System.out.println( "Element not present on page" );

        }
        return text;
    }


    /**
     * This function will getText of a locator.
     */
    public String textOfLocator(By locator) {
        String text = null;
        try {
            text = waitForElementToBeVisible( locator ).getText();
            System.out.println("Tool tip is :"+ " " + text);

        } catch (ElementNotVisibleException e) {
            System.out.println( "Element not present on page" );

        }
        return text;
    }

}

