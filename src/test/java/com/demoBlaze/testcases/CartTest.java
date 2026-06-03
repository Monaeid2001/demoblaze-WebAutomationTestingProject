package com.demoBlaze.testcases;

import com.demoBlaze.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class CartTest extends BaseTest {
    @Test
    public void login(){
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("monaeid", "123");
        loginPage.waitUntilLoginModalDisappears();


    }
    @Test
    public void verifyProductAppearsInCart() {
        login();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnProduct("Samsung");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart().acceptAlert();
        CartPage cartPage = navBar.clickCart();
        Assert.assertTrue(cartPage.isProductInCart("Samsung"));
    }
    @Test
    public void deleteProductFromCart(){
        login();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnProduct("Nokia");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart().acceptAlert();
        CartPage cartPage = navBar.clickCart();
        cartPage.deleteProductFromCart("Nokia");
        Assert.assertFalse(cartPage.isProductInCart("Nokia"));
    }

}
