package privateCRCL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class main {
    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.get("https://dev-business.privatecrcl.com/");

        //Login with valid email and password
        driver.findElement(By.id("email")).sendKeys("business.qa@privatecrcl.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(3000);

        //Tap on profile and logout the app
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement profileBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[.//p[contains(text(),'fatima')]]")
                )
        );
        profileBtn.click();
        Thread.sleep(3000);
        By logoutBtn = By.xpath("//button[contains(.,'Logout')]");
        driver.findElement(logoutBtn).click();

        //Login with invalid email and password

        driver.findElement(By.id("email")).sendKeys("business.qa@privatecrcl.com");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait1.until(
              ExpectedConditions.visibilityOfElementLocated(
                       By.xpath("//div[contains(text(),'Invalid email or password')]")
                )
      );
        System.out.println(error.getText());

        //Commented code for creating the event

/*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement event = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Events & Bookings']")
                )
        );
        event.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement createEventBtn = wait2.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[normalize-space()='Create Event']")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                createEventBtn);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createEventBtn);

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/main[1]/div[3]/section[1]/div[2]/section[1]/div[3]/div[1]/div[1]/input[1]")).sendKeys("Automated Event");
        driver.findElement(By.xpath("//input[@placeholder='Search location (Google)']")).sendKeys("King Abdulaziz International Airport");
        driver.findElement(By.xpath("//textarea[@class='w-full bg-offer-search-main border border-border text-white-off text-sm rounded-lg px-3 py-2 focus:outline-none focus:ring-1 focus:ring-primary ']")).sendKeys("This is a testing event");
/*
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startDate = wait3.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//input[@type='datetime-local'])[1]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].value='2026-06-30T13:24';" +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                startDate);

        WebElement endDate = wait3.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//input[@type='datetime-local'])[2]")));

        js.executeScript(
                "arguments[0].value='2026-06-30T14:24';" +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                endDate);
        startDate.sendKeys("01-07-2026");
        endDate.sendKeys("01-07-2026");

 */
        /*

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

// Start Date & Time
        WebElement startDate = wait3.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//input[@type='datetime-local'])[1]")));

        js.executeScript(
                "arguments[0].value='2026-07-01T13:24';" +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));" +
                        "arguments[0].blur();",
                startDate);

        Thread.sleep(1000);

// End Date & Time
        WebElement endDate = wait3.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//input[@type='datetime-local'])[2]")));

        js.executeScript(
                "arguments[0].value='2026-07-01T14:24';" +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                        "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));" +
                        "arguments[0].blur();",
                endDate);

        Thread.sleep(1000);

// Click anywhere outside
        driver.findElement(By.tagName("body")).click();



        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startDate = wait3.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//input[@type='datetime-local'])[1]")));

        startDate.click();
        startDate.clear();
        startDate.sendKeys("01-07-2026T5055.000Z");

        Thread.sleep(1000);

        WebElement endDate = wait3.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//input[@type='datetime-local'])[2]")));

        endDate.click();
        endDate.clear();
        endDate.sendKeys("01-07-2026T6066.000Z");

         */
    }

}


