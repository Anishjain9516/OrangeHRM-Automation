package RunTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Init.Initilize;
import Loginpage.LoginPage00;

public class loginPage00Test extends Initilize {
    LoginPage00 loginPage00;

    @Test(enabled = false)
    public void performvalidlogin() {
        loginPage00 = new LoginPage00(Initilize.driver);
        loginPage00.goToLoginPage("https://opensource-demo.orangehrmlive.com/");
        loginPage00.validLogin("Admin", "admin123");

        String expectedTitle = "Dashboard";
        String actualTitle = loginPage00.getDashboardText();
        Assert.assertEquals(actualTitle, expectedTitle, "Dashboard title ");
    }

    @Test(enabled = false, groups = "invalidLogin")
    public void performinvalidlogin() {
        loginPage00 = new LoginPage00(Initilize.driver);
        loginPage00.goToLoginPage("https://opensource-demo.orangehrmlive.com/");
        loginPage00.invalidLogin("Admi", "admin123");

        String expectedTitle = "Invalid credentials";
        String actualTitle = loginPage00.getInvalidMessage();
        Assert.assertEquals(actualTitle, expectedTitle, "Invalid credentials");
    }
    @Test
    public void performforgortpassword(){
        loginPage00 = new LoginPage00(Initilize.driver);
        loginPage00.goToLoginPage("https://opensource-demo.orangehrmlive.com/");
        loginPage00.clickForgotPassword("jainsid2121@gmail.com");
        String expectedTitle = "Reset Password link sent successfully";
        String actualTitle = loginPage00.getForgotPasswordSuccessMessage();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}