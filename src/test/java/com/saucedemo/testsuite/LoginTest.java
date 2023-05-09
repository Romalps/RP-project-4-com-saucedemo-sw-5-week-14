package com.saucedemo.testsuite;

import com.saucedemo.customListeners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {


    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(productPage.getProductText(), "Products");
    }
}
