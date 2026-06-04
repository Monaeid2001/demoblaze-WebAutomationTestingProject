package com.demoBlaze.testcases;

import com.demoBlaze.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void shouldBeAbleToLogin() {
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("monaeid", "123");
        String NewnavBarText = navBar.getLoggedInUser();
        Assert.assertTrue(NewnavBarText.contains("monaeid"));
    }

    @Test
    public void shouldNotBeAbleToLoginWithInvalidUserName() {
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("mon1294i4q", "123");
        Assert.assertEquals(loginPage.getAlertText(), "User does not exist.");
    }
    @Test
    public void shouldNotBeAbleToLoginWithInvalidPassword() {
        LoginPage loginPage = navBar.clickLogin();
        loginPage.login("monaeid", "1234");
        Assert.assertEquals(loginPage.getAlertText(), "Wrong password.");
    }

}
