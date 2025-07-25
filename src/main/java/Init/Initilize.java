package Init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initilize {

    public static WebDriver driver;

    @BeforeSuite
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void Teardown(){
        driver.quit();
    }
    
}
