package Init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Init2 {
    public static WebDriver driver;

    @BeforeSuite()
    public void init2(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
    }

    @AfterSuite()
    public void Teardown(){
        driver.quit();
    }
    
}
