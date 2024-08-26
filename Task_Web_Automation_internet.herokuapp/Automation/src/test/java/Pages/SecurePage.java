package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SecurePage {
    WebDriver driver;
    final String successField ="//div[@class='flash success']";
    final String logoutButton = "//a[@class='button secondary radius']";

    public SecurePage(WebDriver driver){
        this.driver = driver;
    }
    public void assertLoginSuccess(){
        String message = new WebDriverWait(this.driver, Duration.ofMillis(5000)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(successField))).getText();


        Assert.assertTrue(message.toLowerCase().contains("logged in"));
        System.out.println(message);
    }
    public void pressLogout(){
        this.driver.findElement(By.xpath(logoutButton)).click();
    }


}
