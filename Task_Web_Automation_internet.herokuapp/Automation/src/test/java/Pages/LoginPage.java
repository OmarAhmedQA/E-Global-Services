package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    final String validUsername = "tomsmith";
    final String validPassword = "SuperSecretPassword!";

    final String loginFieldXPATH = "//input[@name='username']";
    final String passwordFieldXPATH = "//input[@name='password']";
    final String loginButtonXPATH = "//button[@class='radius']";
    final String successField ="//div[@class='flash success']";





    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.driver.get("https://the-internet.herokuapp.com/login");
    }


    public void enterUsername(){
        driver.findElement(By.xpath(loginFieldXPATH)).sendKeys(validUsername);
    }

    public void enterPassword(){
        driver.findElement(By.xpath((passwordFieldXPATH))).sendKeys(validPassword);
    }

    public void pressSubmit(){
        driver.findElement(By.xpath(loginButtonXPATH)).click();
    }

    public SecurePage loginWithData(){
        this.enterUsername();
        this.enterPassword();
        this.pressSubmit();
        return new SecurePage(this.driver);
    }

    public void assertLogoutSuccess(){
        String message = this.driver.findElement(By.xpath(successField)).getText();
        Assert.assertTrue(message.toLowerCase().contains("logged out"));
        System.out.println(message);
    }

}
