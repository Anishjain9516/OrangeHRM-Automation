package Loginpage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage00 {
    WebDriver driver;
    WebDriverWait _wait;

    @FindBy(xpath = "//input[@name='username']") WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password']") WebElement passwordInput;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']") WebElement loginBtn;
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']") WebElement dashboardBtn;
    //@FindBy(xpath = "//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module')]")
   // WebElement dashboardBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]") WebElement invalidMessage;
    @FindBy(xpath="//div[@class=\"orangehrm-login-forgot\"]") WebElement forgotPasswordbtn;
    @FindBy(xpath="//input[@name='username']") WebElement forgotpassusernameInputBox;
    @FindBy(xpath="//button[normalize-space()='Reset Password']") WebElement resetPasswordBtn;
    @FindBy(xpath="//h6[normalize-space()='Reset Password link sent successfully']") WebElement ForgotPasswordSuccessMessage;

    public LoginPage00(WebDriver driver){
        this.driver = driver;
        _wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    public void goToLoginPage(String url) {
    driver.get(url);
    _wait.until(ExpectedConditions.visibilityOf(usernameInput));
}
    
    public void validLogin(String username, String password){
        WebElement usernameInputBox = _wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInputBox.clear();
        usernameInputBox.sendKeys(username);

        WebElement passwordInputBox = _wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInputBox.clear();
        passwordInputBox.sendKeys(password);

        _wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    /**
     * Get dashboard header text after login.
     */
    public String getDashboardText() {
        return _wait.until(ExpectedConditions.visibilityOf(dashboardBtn)).getText();
    }


    public void invalidLogin(String username, String password){
        WebElement usernameInputBox = _wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInputBox.clear();
        usernameInputBox.sendKeys(username);

        WebElement passwordInputBox = _wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInputBox.clear();
        passwordInputBox.sendKeys(password);

        _wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
    public String getInvalidMessage(){
        return _wait.until(ExpectedConditions.visibilityOf(invalidMessage)).getText();
    }
    public void clickForgotPassword(String forusernameString){
        _wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordbtn)).click();
        _wait.until(ExpectedConditions.elementToBeClickable(this.forgotpassusernameInputBox)).sendKeys(forusernameString);
        _wait.until(ExpectedConditions.elementToBeClickable(resetPasswordBtn)).click();
    }
    public String getForgotPasswordSuccessMessage() {
        return _wait.until(ExpectedConditions.visibilityOf(ForgotPasswordSuccessMessage)).getText();
    }
    

}