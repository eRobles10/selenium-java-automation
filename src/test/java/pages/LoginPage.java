package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Config;

public class LoginPage{


    private WebDriver driver;
    private WebDriverWait wait;
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver,
            Config.EXPLICIT_WAIT
        );
    }

    public void enterUsername(String username){
        this.wait.until(
            ExpectedConditions.visibilityOfElementLocated(this.usernameInput)
        );
        driver.findElement(this.usernameInput).sendKeys(username);
    }

    public void enterPassword(String password){
        this.wait.until(
            ExpectedConditions.visibilityOfElementLocated(this.passwordInput)
        );
        driver.findElement(this.passwordInput).sendKeys(password);
    }

    public void clickLogin(){
        this.wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        );
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage(){
        this.wait.until(
            ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );
        return driver.findElement(errorMessage).getText();
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }


}
