package Loginpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// ...existing code...

public class DashboardPage00 {

    WebDriver driver;
    WebDriverWait _wait;

    public DashboardPage00(WebDriver driver){
        this.driver=driver;
        _wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;
    
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginbtn;

    @FindBy(xpath = "(//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name')])[1]")
    WebElement MyAdminbtn;
    
    @FindBy(xpath = "(//span[contains(@class, 'oxd-topbar-body-nav-tab-item')])[1]")
    WebElement Myusermanagmentbtn;

    @FindBy(xpath="//div/span[contains(.,'(6) Records Selected')]")
    WebElement elementcount;

    @FindBy(xpath = "//span[normalize-space()='(49) Records Selected']")
    public WebElement NumberofRecords;

    public void validloginTodashboard(String username, String password){
        WebElement usernameinputbox=_wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameinputbox.clear();
        usernameinputbox.sendKeys(username);
        
        WebElement passwordInputbox = _wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInputbox.clear();
        passwordInputbox.sendKeys(password);
            
        _wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();

        WebElement Adminbtnbox = _wait.until(ExpectedConditions.elementToBeClickable(MyAdminbtn));
        Adminbtnbox.click();

        WebElement  Usermanagmentbtnbox= _wait.until(ExpectedConditions.elementToBeClickable(Myusermanagmentbtn));
        Usermanagmentbtnbox.click();
        }   

        public int Mymutlipleselectioncheck(){

        List<WebElement> multiplecheckList = _wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//span[contains(@class,'oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input')]/i)")));
        int avgcount=0;
        for(WebElement checkbox:multiplecheckList){
            
            if(!checkbox.isSelected()){
                checkbox.click();
            }  
            if(checkbox.isSelected()){
                avgcount++;
            }   
        }
        return avgcount;    
    }
}