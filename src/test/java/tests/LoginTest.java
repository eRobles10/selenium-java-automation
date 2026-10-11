package tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;
import org.junit.jupiter.params.ParameterizedTest;
// Optional: Import specific sources like CsvSource or ValueSource
import org.junit.jupiter.params.provider.CsvSource; 
import utils.ScreenshotExtension;
import org.junit.jupiter.api.extension.RegisterExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class LoginTest extends BaseTest{

    private LoginPage loginPage;
   
    @BeforeEach
    public void initPageObjects(){
        loginPage = new LoginPage(this.driver);
    } 


    @RegisterExtension
    ScreenshotExtension watcher = new ScreenshotExtension(() -> driver, "target/screenshots");



    @ParameterizedTest
    @CsvSource({"standard_user, secret_sauce, /inventory.html, ''", "locked_out_user, secret_sauce,  /, 'Epic sadface: Sorry, this user has been locked out.'"})
    public void loginTest(String username, String password,  String expectedUrl, String expectedError){
        loginPage.login(username, password);
        if(!expectedError.isEmpty()){
            assertEquals(expectedError, loginPage.getErrorMessage());
        }
        assertEquals("https://www.saucedemo.com"+expectedUrl,driver.getCurrentUrl());
    }
    
}