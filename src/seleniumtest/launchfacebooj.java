package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class launchfacebooj {

    public static void main(String args[]) throws InterruptedException {

        //Browser driver exe
        System.setProperty("webdriver.chrome.driver","/Users/idaohlsson/Documents/SeleniumFacebooj/chromedriver");

        //Create chrome instance
        WebDriver driver=new ChromeDriver();

        //open application
        driver.get("https://www.facebook.com/login");

        // Accept cookies
        driver.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click();

        //maximize browser
        driver.manage().window().maximize();

        // Enter login credentials and click on the "Log In" button
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        email.sendKeys("ida.ohlsson@live.se");
        password.sendKeys("99edithminhund99");
        driver.findElement(By.id("loginbutton")).click(); 2


        // Verify that the user is successfully logged in and redirected to their profile page
        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test passed! User is logged in and redirected to their profile page.");
        } else {
            System.out.println("Test failed! User is not logged in and redirected to their profile page.");
        }

        // Click on the "Log Out" button
        driver.findElement(By.id("userNavigationLabel")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();

        // Verify that the user is logged out and redirected to the Facebook login page
        expectedUrl = "https://www.facebook.com/login/";
        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test passed! User is logged out and redirected to the Facebook login page.");
        } else {
            System.out.println("Test failed! User is not logged out and redirected to the Facebook login page.");
        }

        //wait 3 min
        Thread.sleep(180000);

        //close browser
        // driver.close(); // close the current tab
        driver.quit(); // close all the tab
    }
}
