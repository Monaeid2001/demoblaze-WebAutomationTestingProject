package com.demoBlaze.testcases;

import com.demoBlaze.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Checkout extends BaseTest {
    @Test
    public void checkoutTest() {
        // Implement checkout test steps here]
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("monaeid", "123");
        loginPage.waitUntilLoginModalDisappears();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnProduct("Nokia");
        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart().acceptAlert();
        CartPage cartPage = navBar.clickCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        cartPage.checkout().fillCheckoutForm("Mona", "Egypt", "Cairo", "123456789012,", "12", "2025");
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your purchase!");
        Assert.assertEquals(checkoutPage.getTotalPrice(),cartPage.getTotalPrice());

    }

}
