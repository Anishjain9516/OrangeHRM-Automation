package Loginpage;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage01Alerts {
    WebDriver driver;
    WebDriverWait _Wait;

    public DashboardPage01Alerts(WebDriver driver){
        this.driver = driver;
        _Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement userdropdoWebElement;

    @FindBy(xpath="//a[contains(text(),'About')]")
    WebElement abouElement;

}