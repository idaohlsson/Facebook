package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class search {
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
    email.sendKeys("email");
    password.sendKeys("password");
    driver.findElement(By.id("loginbutton")).click();
    int i = 2;

        // Wait for the Facebook homepage to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/"));

        // Handle the notification popup
        try {
            WebElement notificationPopup = driver.findElement(By.xpath("//div[contains(@class, 'bx') and contains(@class, 'ia') and contains(@class, 'bx')]"));
            WebElement notNowButton = notificationPopup.findElement(By.xpath(".//button[contains(text(), 'Not Now')]"));
            notNowButton.click();
        } catch (Exception e) {
            // Notification popup not found or encountered an error while handling it
        }

        // Find the search bar
        WebElement searchInput = driver.findElement(By.name("q"));

        // Enter the search keyword and press Enter
        CharSequence Zlatan = null;
        searchInput.sendKeys(Zlatan);
        searchInput.sendKeys(Keys.ENTER);

        // Wait for the search results to load
        // You can use an explicit wait here if needed

        // Perform actions with the search results
        // ...

        // Close the WebDriver
        driver.quit();
    }
}

