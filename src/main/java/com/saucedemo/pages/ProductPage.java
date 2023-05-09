package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customListeners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
            @FindBy(xpath ="//span[@class='title']" )
            WebElement productText;


    public String getProductText() {
        CustomListeners.test.log(Status.PASS,"Get product text "+ productText);
        return getTextFromElement(productText);
    }

    public String getProductsPerPage() {
        List<WebElement> totalItems = driver.findElements(By.xpath("//div[@class='inventory_item_label']"));
        int size = totalItems.size();
        return String.valueOf(size);
    }

}
