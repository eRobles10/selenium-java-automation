
package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    public void verifyGoogleTitle() {

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

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");

            String title = driver.getTitle();

            assertEquals("Google", title);

        } finally {
            driver.quit();
        }
    }
}
