package com.automationPractice.pages;

import com.automationPractice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement newUserSignupHeader;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement nameInput;

    @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[3]")
    public WebElement emailInput;

    @FindBy(xpath = "//button[.='Signup']")
    public WebElement signUpButton;

    @FindBy(xpath = "//b[.='Enter Account Information']")
    public WebElement enterAccountInformationMessage;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsletterCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement specialOffersCheckBox;

    @FindBy(id = "first_name")
    public WebElement firstNameInput;

    @FindBy(id = "last_name")
    public WebElement lastNameInput;

    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement address1Input;

    @FindBy(id = "address2")
    public WebElement address2Input;

    @FindBy(id = "country")
    public WebElement countryDropDown;

    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "zipcode")
    public WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;

    @FindBy(xpath = "//button[.='Create Account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[.='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    public WebElement loggedInAs;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div/div/ul/li[5]/a")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement accountDeletedMessage;

    @FindBy(xpath = "//*[@id='ad_iframe']")
    public WebElement adIframe;

    @FindBy(xpath = "//div[@id='dismiss-button']")
    public WebElement closeAd;

}
