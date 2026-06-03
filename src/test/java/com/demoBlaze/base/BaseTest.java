package com.demoBlaze.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.NavBarPage;


public class BaseTest {
  protected WebDriver driver;
  protected NavBarPage navBar;
  @BeforeMethod
    public void setUp() {
    EdgeOptions options = new EdgeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
      driver = new EdgeDriver(options);
      driver.get("https://www.demoblaze.com/");
      driver.manage().window().maximize();
       navBar = new NavBarPage(driver);
  }
  @AfterMethod
    public void tearDown() {
      driver.quit();
  }

}
