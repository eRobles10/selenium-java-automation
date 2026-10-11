package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.Config;




public class BaseTest {

    protected WebDriver driver;
   

    @BeforeEach
    public void setUp(){
        driver = DriverFactory.createDriver();
        driver.get(Config.PROJECT_URL); 

    }

     @AfterEach
    public void tearDown(){
        if(driver !=null){
            driver.quit();
        }
    }

}