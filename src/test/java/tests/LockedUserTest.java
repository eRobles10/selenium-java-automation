package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;
import utils.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals; 

public class LockedUserTest{

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        driver = DriverFactory.createDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);

    }

     @Test 
    public void lockedUserCannotLogin(){

        loginPage.login(TestData.LOCKED_USER, TestData.PASSWORD);
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
        assertEquals("https://www.saucedemo.com/",driver.getCurrentUrl());

    }

   

    @AfterEach
    public void tearDown(){
        if(driver !=null){
            driver.quit();
        }
    }


}