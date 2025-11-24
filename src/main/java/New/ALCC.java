package New;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ALCC {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("https://alcc.connectm.com/");

        //Verify the Logo
        String ExpectedLogo = "https://www.connectm.com/wp-content/themes/connectm/assets/img/logo-ConnectM.svg";
        WebElement ActualLogo = driver.findElement(By.xpath("//img[@alt='ContM']"));
        String actualLogoUrl = ActualLogo.getAttribute("src");

        try{
            Assert.assertEquals(actualLogoUrl,ExpectedLogo);
            System.out.println("Logo is presented");
        }catch(AssertionError e){
            System.out.println("Logo not presented");
        }

        //Verify Buttons
      // Get and sort all buttons in the main menu
        List<WebElement> menuButtons = driver.findElements(By.xpath("//div[@id='main-menu']//button"));

        if (menuButtons.isEmpty()) {
            System.out.println("❌ No buttons found.");
            return;
        }

        menuButtons.sort(Comparator.comparing(e -> e.getText().trim().toLowerCase()));

        for (WebElement button : menuButtons) {
            String buttonText = button.getText().trim();
            System.out.println("🔘 Clicking: " + buttonText);

            try {
                button.click();
                Thread.sleep(1500); // Allow time for content to update

                // Check if any visible element contains the button text
                List<WebElement> matchingElements = driver.findElements(By.xpath("//*[contains(text(), '" + buttonText + "')]"));
                boolean isVisible = matchingElements.stream().anyMatch(WebElement::isDisplayed);

                if (isVisible) {
                    System.out.println("✅ Verified: " + buttonText + " section is visible.");
                } else {
                    System.out.println("❌ Verification failed: " + buttonText + " section not visible.");
                }

            } catch (Exception e) {
                System.out.println("⚠️ Error during verification for: " + buttonText + " - " + e.getMessage());
            }
        }
        //Login
        driver.findElement(By.xpath("//button[@class='bg-[#215985] text-white font-bold px-4 py-1 rounded hover:bg-blue-600 text-sm']")).click();
        driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys("ExideOemAdmin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Connectm@2025");
        driver.findElement(By.xpath("//button[@type='submit']")).click();



        }
}
