package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory{

    public static WebDriver createDriver(){
        ChromeOptions options = new ChromeOptions();

         //Run only chormium 
        options.setBinary("/usr/bin/chromium");

        // Run Chrome without opening a visible browser window
        options.addArguments("--headless=new");

        // Required for Linux/Codespaces environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Disable GPU since we are running in a cloud environment
        options.addArguments("--disable-gpu");

        return new ChromeDriver(options);
    }


}