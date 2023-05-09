package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customListeners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement usernameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginLink;


    @CacheLookup
    @FindBy(xpath = "//span[@class='title']")
    WebElement productText;


    public void enterUsername(String username) {
        sendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS, "Enter Username " + username);

    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password" + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginLink);

    }

    public String getProductText() {
        return getTextFromElement(productText);
    }


}
