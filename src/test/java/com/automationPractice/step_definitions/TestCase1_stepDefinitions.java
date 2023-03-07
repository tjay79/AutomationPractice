package com.automationPractice.step_definitions;

import com.automationPractice.pages.HomePage;
import com.automationPractice.pages.SignUpPage;
import com.automationPractice.utilities.BrowserUtils;
import com.automationPractice.utilities.ConfigurationReader;
import com.automationPractice.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TestCase1_stepDefinitions {


    Faker faker = new Faker();
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String expectedTitle = "Automation Exercise";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("user clicks on Signup\\/Login button")
    public void user_clicks_on_signup_login_button() {

        homePage.signUpButton.click();
        Assert.assertTrue(signUpPage.newUserSignupHeader.isDisplayed());

    }

    @When("user enters name and email")
    public void user_enters_name_and_email() {
        signUpPage.nameInput.sendKeys("Albert Einstein");
        signUpPage.emailInput.sendKeys("albert.einstein@gmail.com");
    }
    @When("user clicks Signup button")
    public void user_clicks_signup_button() {

        signUpPage.signUpButton.click();
    }
    @When("user verifies that the enter account information message is visible")
    public void user_verifies_that_the_new_user_signup_message_is_visible() {
        Assert.assertTrue(signUpPage.enterAccountInformationMessage.isDisplayed());
    }
    @When("user enters their details")
    public void user_enters_their_details() {
        signUpPage.passwordInput.sendKeys("abc123");
        Select selectDay = new Select(signUpPage.daysDropdown);
        selectDay.selectByVisibleText("1");
        Select selectMonth = new Select(signUpPage.monthsDropdown);
        selectMonth.selectByVisibleText("January");
        Select selectYear = new Select(signUpPage.yearsDropdown);
        selectYear.selectByVisibleText("1999");
    }
    @When("user clicks on the Sign up for our newsletter checkbox")
    public void user_clicks_on_the_sign_up_for_our_newsletter_checkbox() {
        Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(signUpPage.mobileNumberInput).perform();
        signUpPage.newsletterCheckBox.click();
    }
    @When("user clicks on the Receive special offers from our partners checkbox")
    public void user_clicks_on_the_receive_special_offers_from_our_partners_checkbox() {

        signUpPage.specialOffersCheckBox.click();
    }
    @When("user enters the other details")
    public void user_enters_the_other_details() {
       signUpPage.firstNameInput.sendKeys("Albert");
       signUpPage.lastNameInput.sendKeys("Einstein");
       signUpPage.companyInput.sendKeys("Cydeo");
       signUpPage.address1Input.sendKeys("Cydeo School");
       signUpPage.address2Input.sendKeys("1 Cydeo Drive");
       Select select = new Select(signUpPage.countryDropDown);
       select.selectByVisibleText("United States");
       signUpPage.stateInput.sendKeys("New York");
       signUpPage.cityInput.sendKeys("New York");
       signUpPage.zipCodeInput.sendKeys("10010");
       signUpPage.mobileNumberInput.sendKeys("862-123-4567");
    }
    @When("user clicks the Create Account button")
    public void user_clicks_the_create_account_button() {
        signUpPage.createAccountButton.click();
    }
    @When("user verifies that the account was created")
    public void user_verifies_that_the_account_was_created() {
        Assert.assertTrue(signUpPage.accountCreatedMessage.isDisplayed());
    }
    @When("user clicks the continue button")
    public void user_clicks_the_continue_button() {
        signUpPage.continueButton.click();
        //Driver.getDriver().switchTo().frame(signUpPage.adIframe);
        //signUpPage.closeAd.click();
        //Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().navigate().refresh();
        signUpPage.continueButton.click();

    }
    @When("user verifies that the logged in as username is visible")
    public void user_verifies_that_the_logged_in_as_username_is_visible() {
        Assert.assertTrue(signUpPage.loggedInAs.getText().equals("Albert Einstein"));
    }
    @When("user clicks the Delete account button")
    public void user_clicks_the_delete_account_button() {
        signUpPage.deleteAccountButton.click();
    }
    @Then("user sees the Account deleted message and should be able to click the continue button")
    public void user_sees_the_account_deleted_message_and_should_be_able_to_click_the_continue_button() {
        Assert.assertTrue(signUpPage.accountDeletedMessage.isDisplayed());
        signUpPage.continueButton.click();
    }


}
