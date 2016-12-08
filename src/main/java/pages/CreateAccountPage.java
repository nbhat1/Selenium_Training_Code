package pages;

import comman.CommanFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by neeraj.bhatnagar on 11/24/2016.
 */
public class CreateAccountPage extends CommanFunction{
    //WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public static final By checkAuthenticate = By.cssSelector(".navigation_page");
    public static final By titleMr = By.xpath(".//*[@id='id_gender1']");
    public static final By titleMrs = By.xpath(".//*[@id='id_gender2']");
    public static final By firstName = By.xpath(".//*[@id='customer_firstname']");
    public static final By lastName = By.xpath(".//*[@id='customer_lastname']");
    public static final By emailofUser = By.xpath(".//*[@id='email']");
    public static final By password = By.xpath(".//*[@id='passwd']");
    public static final By days_DOB = By.id("days");
    public static final By months_DOB = By.id("months");
    public static final By years_DOB = By.id("years");
    public static final By signUpNewsleterCheckBox = By.xpath(".//*[@id='newsletter']");
    public static final By specialOffersCheckBox = By.xpath(".//*[@id='optin']");
    public static final By signupText = By.xpath(".//*[@for='newsletter']");
    public static final By offerText = By.xpath(".//*[@for='optin']");
    public static final By address_First_Name = By.xpath(".//*[@id='firstname']");
    public static final By address_Last_Name = By.xpath(".//*[@id='lastname']");
    public static final By address_Comapany = By.xpath(".//*[@id='company']");
    public static final By address_Line_1 = By.xpath(".//*[@id='address1']");
    public static final By address_Line_2 = By.xpath(".//*[@id='address2']");
    public static final By address_city = By.xpath(".//*[@id='city']");
    public static final By address_State = By.id("id_state");
    public static final By address_Zip_Code = By.xpath(".//*[@id='postcode']");
    // Pick Country from dropdowm.
    public static final By address_Additional_Info = By.xpath(".//*[@id='other']");
    public static final By address_Home_Phone = By.xpath(".//*[@id='phone']");
    public static final By address_Mobile_Phone = By.xpath(".//*[@id='phone_mobile']");
    public static final By address_alias = By.xpath(".//*[@id='alias']");
    public static final By Register_Button = By.xpath(".//*[@id='submitAccount']");


    String firstNameValue= "Neeraj";
    String lastNameValue = "Bhatnagar";
    String emailToCreateAccount = "neerajunlimited@gmail.com";
    String passwordValue = "12345";
    //String userFirstName = "Neeraj";
    //String userLastName = "Bhatnagar";
    String addressFirstNameValue= "Neeraj";
    String addressLastNameValue = "Bhatnaagar";
    String addressCompanyName = "MyComapany";
    String addressLine1 = "Indirapuram";
    String addressLine2 = "Ghaziabad";
    String addressCity = "Ghaziabad";
    String addressZipCode = "02453";
    String addressAdditionalInfo = "From Filled completely";
    String addressHomePhone = "9876675456";
    String addressMobile = "9867564534";
    String addressAlias = "This is home address";
    String daysDOBValue = "5";
    String monthsDOBValue = "4";
    String yearsDOBValue = "1981";


    public boolean checkRegPage()
    {
        //System.out.println("reference of driver in CreateAccountPgae" + driver);
        boolean isRegPagePresent = true;
        try {
            WebElement element = driver.findElement(checkAuthenticate);
            System.out.println("Authentication checked.");
            //element.isDisplayed();
            element.isDisplayed();
        } catch (Exception ex) {
            isRegPagePresent = false;
        }
        return isRegPagePresent;

    }

   /*
    This function will fill registration form.A String type variable is being used in sendKeys method.
    This variable is defined in class. we can use fillAccountInformation or fillAccountForm to complete account form.
   */

   /* public void fillAccountInformation(){

           waitForElementToBeVisible(firstName).sendKeys(userFirstName);
        waitForElementToBeVisible(lastName).sendKeys(userLastName);
    }*/
    public void fillAccountForm() {
        fillValuesInTextBox(firstName, firstNameValue);
        fillValuesInTextBox(lastName, lastNameValue);
        fillValuesInTextBox(password,passwordValue);
        fillValuesInTextBox(address_First_Name, addressFirstNameValue);
        fillValuesInTextBox(address_Last_Name,addressLastNameValue);
        fillValuesInTextBox(address_Comapany,addressCompanyName);
        fillValuesInTextBox(address_Line_1,addressLine1);
        fillValuesInTextBox(address_Line_2,addressLine2);
        fillValuesInTextBox(address_city,addressCity);
        fillValuesInTextBox(address_Zip_Code,addressZipCode);
        fillValuesInTextBox(address_Additional_Info,addressAdditionalInfo);
        fillValuesInTextBox(address_Home_Phone,addressHomePhone);
        fillValuesInTextBox(address_Mobile_Phone,addressMobile);
        fillValuesInTextBox(address_alias,addressAlias);
   }

    /*
    This function will select radio button Mr.
     */
    public void selectTitleMr() {
        selectRadioButton(titleMr);
    }

    /*
   This function will select radio button Mrs.
    */
    public void selectTitleMrs() {
        selectRadioButton(titleMrs);
    }

    /*
    This function will check if preFilled email is matching with email entered in LoginPage.
     */
    public void checkPreFilledEmail() {
        checkPreFilledTextBoxEntries(emailofUser,emailToCreateAccount);
    }

    /*
    This function will select newsletter checkbox.
     */
    public void selectNewsLetter() {
        selectRadioButton(signUpNewsleterCheckBox);
    }

    /*
   This function will select offers checkbox.
    */
    public void selectOffers() {
        selectRadioButton(specialOffersCheckBox);
    }

    /*
    This function will select Day in DOB field
    */
    public void selectDayDOB() {
        selectValueFromDropDownList(days_DOB,daysDOBValue);
    }

    /*
    This function will select Month in DOB field
    */
    public void selectMonthsDOB() {
        selectValueFromDropDownList(months_DOB,monthsDOBValue);
    }

    /*
    This function will select Year in DOB field
    */
    public void selectYearsDOB() {
        selectValueFromDropDownList(years_DOB,yearsDOBValue);
    }

    /*
    This function will click on Register button after filling new user
    form.
     */
    public MyAccountPage selectRegisterButton() {
        clickOnLocator(Register_Button);
        return new MyAccountPage(getDriver());
    }

    /**
     * This function is waiting for firstName & lastName to be visible. This funtion will wait till the time these elements are not visible so it can be use where ever
     * we have to wait for some items to load.
     */
    public void waitForCreateAccountPageToLoad(){
        waitForElementToBeVisible(firstName);
        waitForElementToBeVisible(lastName);
    }


}

