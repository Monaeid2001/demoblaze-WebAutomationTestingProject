package com.demoBlaze.testcases;

import com.demoBlaze.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test
    public void shouldBeAbleToRegister(){
        RegisterPage registerPage = navBar.clickSignUp();
        registerPage.register("mona66", "123");
        Assert.assertEquals(registerPage.getAlertText(),"Sign up successful.");
    }
    @Test
    public void shouldNotBeAbleToRegisterWithExistingUsername(){
        RegisterPage registerPage = navBar.clickSignUp();
        registerPage.register("mona66", "123");
        Assert.assertEquals(registerPage.getAlertText(),"This user already exist.");
    }


}
