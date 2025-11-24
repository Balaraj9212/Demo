package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OutlookUtility {
    WebDriver driver;

    public OutlookUtility(WebDriver driver) {
        this.driver = driver;
    }


    public void Outlook() throws InterruptedException {

        //WebDriver driver = new ChromeDriver();
        //String mainWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://outlook.office365.com/mail/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

        WebElement UserNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("i0116")));
        UserNameField.sendKeys("balaraj@connectm.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();
        driver.findElement(By.id("i0118")).sendKeys("Connect@321");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Sign in']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Yes']"))).click();

        // Wait for the email list to load
        Thread.sleep(5000);
        List<WebElement> emails = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

        // Find the latest email from "no-reply@verificationemail.com"
        WebElement latestEmail = null;
        for (WebElement email : emails) {
            if (email.getText().contains("no-reply@verificationemail.com")) { // Check sender
                latestEmail = email;
                break;
            }
        }

        // Click the latest email if found
        Thread.sleep(1000);
        if (latestEmail != null) {
            latestEmail.click();
        } else {
            System.out.println("No emails from no-reply@verificationemail.com found.");
            driver.quit();
            return;
        }

        // Wait and click "Reset Password" link
        Thread.sleep(1000);
        WebElement resetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Reset my password')]")));
        resetLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);

        if (windowList.size() >= 3) {
            // Switch to the third window
            driver.switchTo().window(windowList.get(2));
            System.out.println("Switched to third page: " + driver.getTitle());
        } else {
            System.out.println("Third window is not opened.");
        }
    }


    public void Outlook1() throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

        // Wait for the email list to load
        Thread.sleep(5000);
        List<WebElement> emails = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

        // Find the latest email from "no-reply@verificationemail.com"
        WebElement latestEmail = null;
        for (WebElement email : emails) {
            if (email.getText().contains("no-reply@verificationemail.com")) { // Check sender
                latestEmail = email;
                break;
            }
        }

        // Click the latest email if found
        Thread.sleep(1000);
        if (latestEmail != null) {
            latestEmail.click();
        } else {
            System.out.println("No emails from no-reply@verificationemail.com found.");
            driver.quit();
            return;
        }

        // Wait and click "Reset Password" link
        WebElement resetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Reset my password')]")));
        resetLink.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(4));

        if((windowList.size() >= 4)){
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(3));
        }else {
            System.out.println("Fourth window is not opened.");


//        if (windowList.size() >= 4) {
//            // Switch to the third window
//            driver.switchTo().window(windowList.get(3));
//            System.out.println("Switched to fourth page: " + driver.getTitle());
//        } else {
//            System.out.println("Fourth window is not opened.");
//
//
//        }
        }}

}


