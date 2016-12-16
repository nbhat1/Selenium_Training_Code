package com.automationpractice.test.pages;

import com.automationpractice.test.common.CommanFunction;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 11/24/2016.
 */
public class CreateAccountPage extends CommanFunction{
    //WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    static Logger log = Logger.getLogger( CreateAccountPage.class.getName() );
    private static final By checkAuthenticate = By.cssSelector(".navigation_page");
    private static final By titleMr = By.xpath(".//*[@id='id_gender1']");
    private static final By titleMrs = By.xpath(".//*[@id='id_gender2']");
    private static final By firstName = By.xpath(".//*[@id='customer_firstname']");
    private static final By lastName = By.xpath(".//*[@id='customer_lastname']");
    private static final By emailofUser = By.xpath(".//*[@id='email']");
    private static final By password = By.xpath(".//*[@id='passwd']");
    private static final By days_DOB = By.id("days");
    private static final By months_DOB = By.id("months");
    private static final By years_DOB = By.id("years");
    private static final By signUpNewsleterCheckBox = By.xpath(".//*[@id='newsletter']");
    private static final By specialOffersCheckBox = By.xpath(".//*[@id='optin']");
    private static final By signupText = By.xpath(".//*[@for='newsletter']");
    private static final By offerText = By.xpath(".//*[@for='optin']");
    private static final By address_First_Name = By.xpath(".//*[@id='firstname']");
    private static final By address_Last_Name = By.xpath(".//*[@id='lastname']");
    private static final By address_Comapany = By.xpath(".//*[@id='company']");
    private static final By address_Line_1 = By.xpath(".//*[@id='address1']");
    private static final By address_Line_2 = By.xpath(".//*[@id='address2']");
    private static final By address_city = By.xpath(".//*[@id='city']");
    private static final By address_State = By.id("id_state");
    private static final By address_Zip_Code = By.xpath(".//*[@id='postcode']");
    // Pick Country from dropdowm.
    private static final By address_Additional_Info = By.xpath(".//*[@id='other']");
    private static final By address_Home_Phone = By.xpath(".//*[@id='phone']");
    private static final By address_Mobile_Phone = By.xpath(".//*[@id='phone_mobile']");
    private static final By address_alias = By.xpath(".//*[@id='alias']");
    private static final By Register_Button = By.xpath(".//*[@id='submitAccount']");


    private String firstNameValue= "Neeraj";
    private String lastNameValue = "Bhatnagar";
    private String emailToCreateAccount = "neerajunlimited@gmail.com";
    private String passwordValue = "12345";
    //String userFirstName = "Neeraj";
    //String userLastName = "Bhatnagar";
    private String addressFirstNameValue= "Neeraj";
    private String addressLastNameValue = "Bhatnaagar";
    private String addressCompanyName = "MyComapany";
    private String addressLine1 = "Indirapuram";
    private String addressLine2 = "Ghaziabad";
    private String addressCity = "Ghaziabad";
    private String addressZipCode = "02453";
    private String addressAdditionalInfo = "From Filled completely";
    private String addressHomePhone = "9876675456";
    private String addressMobile = "9867564534";
    private String addressAlias = "This is home address";
    private String daysDOBValue = "5";
    private String monthsDOBValue = "4";
    private String yearsDOBValue = "1981";


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
        log.info( "Selecting Mr Radio Button" );
        selectRadioButton(titleMr);

    }

    /*
   This function will select radio button Mrs.
    */
    public void selectTitleMrs() {
        log.info( "Selecting Mrs. Button" );
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
    public MyAccountPage selectRegisterButton() throws IOException{
        clickOnLocator(Register_Button);
        return new MyAccountPage(getDriver());
    }

    /**
     * This function is waiting for firstName & lastName to be visible. This funtion will wait till the time these elements are not visible so it can be use where ever
     * we have to wait for some items to load.
     */
    public void waitForCreateAccountPageToLoad(){
        //assertEquals( waitForElementToBeVisible(firstName).getText(),"Expected" ," Text doesn't match");
        waitForElementToBeVisible(lastName);

    }

    /**
     * This function checks if createAccount page is present. If given locator is present it means page is present.
     * @return
     */
    public boolean isCreateAccountPagePresent(){
        return checkPageExistence(checkAuthenticate);
    }



}

