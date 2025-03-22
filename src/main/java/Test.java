import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class Test {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.connectm.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement Logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='" +
                "https://motovolt-mv.s3.amazonaws.com/Master_Data/cmd_centre_logos/demo_brand_logo.png']")));
        Assert.assertTrue(Logo.isDisplayed());
        System.out.println("Logo Present");

        String ExpectedName = "COMMND CENTER";
        String ActualName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMMAND CENTER')]"))).getText();
        System.out.println(ActualName);

        try {
            Assert.assertEquals(ActualName,ExpectedName);
        System.out.println("Name Correct");
        }
        catch (AssertionError e) {
            System.out.println("Name Not Correct");
        }

        String ExpectedCopyright = "Copyright ©Motovolt 2025. All rights reserved.";
        String ActualCopyright = driver.findElement(By.xpath("//div[@class='login-footer']/div[contains(text(),'Copyright')]")).getText();
        try {Assert.assertEquals(ActualCopyright,ExpectedCopyright);
            System.out.println("Vesrion Number is Correct");}
        catch (Exception e) {
            System.out.println("Veeeeeeeesrion Number is Incorrect");}








        driver.close();

    }
}
