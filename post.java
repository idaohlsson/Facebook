import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class post {public static void main(String[] args) {
    loginToFacebook();
    createPost();
}
    public static void loginToFacebook() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook login page
        driver.get("https://www.facebook.com");

        // Find the email and password input fields
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));

        // Enter your Facebook email and password
        emailInput.sendKeys("email");
        passwordInput.sendKeys("password");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
    }
}
    public static void createPost() {
        // Find the post input field
        WebElement postInput = driver.findElement(By.cssSelector("textarea[aria-label='What's on your mind?']"));

        // Type your post text
        postInput.sendKeys("Hello, Facebook!");

        // Find the post button and click it
        WebElement postButton = driver.findElement(By.cssSelector("button[data-testid='react-composer-post-button']"));
        postButton.click();
    }
}
public static void main(String[] args) {
        loginToFacebook();
        createPost();

        // Add a delay (optional) to allow time for the post to be created
        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }

        // Close the WebDriver and exit the program
        driver.quit();
