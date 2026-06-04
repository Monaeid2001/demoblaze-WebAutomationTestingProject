package com.demoBlaze.testcases;

import com.demoBlaze.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    @Test
    public void VerifyProductName() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickOnProduct("Nokia");
        Assert.assertTrue(productPage.getProductName().contains("Nokia"));
    }

    @Test
    public void verifyProductDescription() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForProductsToLoad();
        String expectedDesc = homePage.getProductDesc("Nokia");
        ProductPage productPage = homePage.clickOnProduct("Nokia");
        Assert.assertEquals(productPage.getProductDesc(),expectedDesc);
    }
    @Test
    public void verifyProductPrice() {
        HomePage homePage = new HomePage(driver);
        String expectedPrice = homePage.getProductPrice("Nokia");
        ProductPage productPage = homePage.clickOnProduct("Nokia");
        Assert.assertEquals(productPage.getProductPrice(),expectedPrice);
    }

    @Test
    public void verifyAddToCartButtonIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickOnProduct("Nokia");
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed());
    }

    @Test
    public void verifyAddToCart() {
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("monaeid", "123");
        loginPage.waitUntilLoginModalDisappears();
        HomePage homePage = new HomePage(driver);
        homePage.waitForProductsToLoad();
        ProductPage productPage = homePage.clickOnProduct("Nokia");
        productPage.clickAddToCart();
        Assert.assertEquals(productPage.getAlertText(), "Product added.");
    }

}
