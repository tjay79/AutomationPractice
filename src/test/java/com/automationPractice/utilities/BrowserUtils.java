package com.automationPractice.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    //In this class there are only general utility methods that are not related to a specific page

    //This method will accept int (in seconds) and will execute Thread.sleep for the given duration
    public static void sleep(int seconds){

        seconds*=1000;

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    /*This method accepts 3 arguments:
    Arg1: WebDriver
    Arg2: expectedInUrl: to verify that url contains the given String
        -if url contains the String it will break the loop
    Arg3: expectedTitle to be compared with the actual title
     */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current url: "+Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }

        }
        String actualPageTitle =Driver.getDriver().getTitle();


        Assert.assertTrue(actualPageTitle.contains(expectedInTitle));
    }

    //This window accepts a String expectedTitle and Asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    /**
     * This method will accept a String as expected value and verify that it is contained in the url
     * @param expectedInUrl
     */
    public static void verifyTitleContains(String expectedInUrl){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));

    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     * @param dropdownElement
     * @return
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> actualOptions = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptions) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group of radio buttons as a list of WebElements.
     * It will loop through the list, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

    /**
     * Switches to new window by the exact title. Returns to the origin window if target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle){
        String origin = Driver.getDriver().getWindowHandle();
        for(String handle : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(handle);
            if(Driver.getDriver().getTitle().equals(targetTitle)){
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
}
