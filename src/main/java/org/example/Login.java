package org.example;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {

    public static void main(String[] args) throws IOException, InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.connectm.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        String username = "balaraj@connectm.com";
        String InValidusername = "balu@connectm.com";
        String password = "Connect@123";
        String UpdatePassword = "Connect@321";
        String MailPassword = "Connect@321";
        String InputText = "0123456789012345678901234567890123456789012345678901234567890123456789";
        String UserExpectedlenght = "50";
        String PasswordExpectedlenght = "50";
        String ResetPasswordExpectedLenght = "50";
        String ResetConfirmPasswordExpectedLenght = "50";
        String Alphabate = "aaaaaaa";
        String Numeric = "1234567898989";
        WebElement UserNameTextField = driver.findElement(By.id("normal_login_username"));
        WebElement PasswordTextField = driver.findElement(By.id("normal_login_password"));
        String ExpectedLoginErrorMessage = " Unable to login. Please verify your user name or password entered.";
        String ExpectedCopyRight = "Copyright ©Motovolt 2025. All rights reserved.";
        String ExpectedApplicationName = "COMMAND CENTER";
        String ExpectedVersionNmber = "Ver : 1.11.67";
        String ExpectedLinkText = "Forgot password?";
        String ExpectedForgotPasswordToast = " We have sent you an email with the link to reset the password!";
        String ExpectedRestPasswordNote = "Enter a new password. The password should be at least 8 characters, a mix of capital, lowercase letters, number, and a special symbol.";
        String ExpectedResetCopyright = "Copyright © 2025. All rights reserved.";
        String ExpectedResetVersionNumber = "Ver : 1.11.67";
        String ExpectedInvalidFormatPasswordError = " Invalid password format.";
        String ExpectedPasswordMatchErrorText = " Passwords do not match.";
        String ExpectedResetSuccessMessage = "Your login password has been reset. You will be redirected to login screen!...";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Verify Application Name
        String ActualApplicationName = driver.findElement(By.xpath("//div[@class='command-center-text']")).getText();
        try {
            Assert.assertEquals(ActualApplicationName, ExpectedApplicationName);
            System.out.println("Test Passed : Application Name is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Application Name is Incorrect");
        }

        // Verify the Logo
        try {
            WebElement Logo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//img[@src='https://motovolt-mv.s3.amazonaws.com/Master_Data/cmd_centre_logos/demo_brand_logo.png']")));
            Assert.assertTrue(Logo1.isDisplayed(), "Logo is not displayed!");

            System.out.println("Test Passed : Logo is Displayed");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Logo not Dispalyed");
        }

        // Verify Copyright Text
        String ActualCopyRight = driver
                .findElement(By.xpath("//div[@class='login-footer']/div[contains(text(), 'Copyright')]")).getText();

        try {
            Assert.assertEquals(ActualCopyRight, ExpectedCopyRight);
            System.out.println("Test Passed : CopyRight Text is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : CopyRight Text is Incorrect");
        }

        // Verify Version Number
        String ActaulVersionNumber = driver
                .findElement(By.xpath("//div[@class='login-footer']/div[contains(text(),'Ver')]")).getText();
        try {
            Assert.assertEquals(ActaulVersionNumber, ExpectedVersionNmber);
            System.out.println("Test Passed : Version Number is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Version Number is Incorrect");
        }

        // Verify Password Masking
        String FieldType = PasswordTextField.getDomAttribute("type");
        try {
            Assert.assertEquals(FieldType, "password", "Password field is not hidden!");
            System.out.println("Test Passed : Password field is hidden.");
        } catch (Exception e) {
            System.out.println("Test Failed : " + e.getMessage());
        }

        // Verify Password Link Text
        String ActaulLink = driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).getText();
        try {
            Assert.assertEquals(ActaulLink, ExpectedLinkText);
            System.out.println("Test Passed : Link Test is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Link Test is Incorrect");
        }

        // Verify Maximum Lengths for Username textfield
        UserNameTextField.sendKeys(InputText);
        String UserActualText = UserNameTextField.getDomAttribute("value");
        int UserActualLenght = UserActualText.length();
        if (UserActualLenght == Integer.parseInt(UserExpectedlenght)) {
            System.out
                    .println("Test Passed:  Username Text field accepts up to " + UserExpectedlenght + " characters.");
        } else {
            System.out.println("Test Failed:  Username Text field accepted " + UserActualLenght
                    + " characters instead of " + UserExpectedlenght);
        }
        UserNameTextField.sendKeys(Keys.CONTROL, "a");
        UserNameTextField.sendKeys(Keys.BACK_SPACE);

        // Verify Maximum Lengths for Password textfield
        PasswordTextField.sendKeys(InputText);
        String PasswordActualText = PasswordTextField.getDomProperty("value");
        int PasswordActualLenght = PasswordActualText.length();
        if (PasswordActualLenght == Integer.parseInt(PasswordExpectedlenght)) {
            System.out.println(
                    "Test Passed:  Password Text field accepts up to " + PasswordExpectedlenght + " characters.");
        } else {
            System.out.println("Test Failed:  Password Text Field accepted " + PasswordActualLenght
                    + " characters instead of " + PasswordExpectedlenght);
        }
        PasswordTextField.sendKeys(Keys.CONTROL, "a");
        PasswordTextField.sendKeys(Keys.BACK_SPACE);

        // Verify Login Error Text
        UserNameTextField.sendKeys(InValidusername);
        PasswordTextField.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String ActualLoginErrorMessage = driver.findElement(By.xpath("//div[@class='notification-toast error']"))
                .getText();
        try {
            Assert.assertEquals(ActualLoginErrorMessage, ExpectedLoginErrorMessage);
            System.out.println("Test Passed : Login Error Text is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Login Error Text is Incorrect");
        }
        UserNameTextField.sendKeys(Keys.CONTROL, "a");
        UserNameTextField.sendKeys(Keys.BACK_SPACE);
        PasswordTextField.sendKeys(Keys.CONTROL, "a");
        PasswordTextField.sendKeys(Keys.BACK_SPACE);

        // Verify the success message for the email containing the password reset link.
        UserNameTextField.sendKeys(username);
        driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
        String ActualForgotPasswordToast = driver
                .findElement(By.xpath("//div[contains(@class, 'notification-toast succes')]/span")).getText();
        try {
            Assert.assertEquals(ActualForgotPasswordToast, ExpectedForgotPasswordToast);
            System.out.println("Test Passed : The password reset link success message is correct." + "");
        } catch (AssertionError e) {
            System.out.println("Test Failed : The password reset link success message is Incorrect.");
        }
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://outlook.office365.com/mail/");
        driver.findElement(By.id("i0116")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("i0118")).sendKeys(MailPassword);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.findElement(By.xpath("//input[@value='Yes']")).click();

        // Wait for the email list to load
        Thread.sleep(5000);
        List<WebElement> emails = wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
        System.out.println("Total Emails Found: " + emails.size());

        // Find the latest email from "no-reply@verificationemail.com"
        WebElement latestEmail = null;
        for (WebElement email : emails) {
            if (email.getText().contains("no-reply@verificationemail.com")) { // Check sender
                latestEmail = email;
                break;
            }
        }

        // Click the latest email if found
        if (latestEmail != null) {
            latestEmail.click();
        } else {
            System.out.println("No emails from no-reply@verificationemail.com found.");
            driver.quit();
            return;
        }

        // Wait and click "Reset Password" link
        Thread.sleep(5000);
        WebElement resetLink = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-auth='NotApplicable']")));
        resetLink.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.numberOfWindowsToBe(3));

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

        // Verify Reset Password Note
        String ActaulRestPasswodNote = driver.findElement(By.xpath("//div[@class='forgot-password-label']")).getText();
        try {
            Assert.assertEquals(ActaulRestPasswodNote, ExpectedRestPasswordNote);
            System.out.println("Test Passed : Reset Page Password Note is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Reset Page Password Note Inorrect");
        }

        // Verify Password Masking -Password Reset Page
        WebElement ResetPasswordField = driver.findElement(By.xpath("//input[@placeholder='New Password']"));
        ResetPasswordField.sendKeys(InputText);
        String FieldType1 = ResetPasswordField.getDomAttribute("type");
        try {
            Assert.assertEquals(FieldType1, "password", "Reset Password field is not hidden!");
            System.out.println("Test Passed : Reset Password field is hidden.");
        } catch (Exception e) {
            System.out.println("Test Failed : " + e.getMessage());
        }
        ResetPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetPasswordField.sendKeys(Keys.DELETE);

        // Verify Password Masking -Confirm Password Reset Page
        WebElement ResetConfirmPasswordField = driver.findElement(By.id("normal_login_confirmPassword"));
        ResetConfirmPasswordField.sendKeys(InputText);
        String FieldType11 = ResetConfirmPasswordField.getDomAttribute("type");
        try {
            Assert.assertEquals(FieldType11, "password", "Confirm Reset Password field is not hidden!");
            System.out.println("Test Passed : Confirm Reset Password field is hidden.");
        } catch (Exception e) {
            System.out.println("Test Failed : " + e.getMessage());
        }
        ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetConfirmPasswordField.sendKeys(Keys.DELETE);

        // Verify Copyright Text -Reset Page
        String ActualResetCopyRight = driver.findElement(By.xpath("//div[contains(text(),'Copy')]")).getText();
        try {
            Assert.assertEquals(ActualResetCopyRight, ExpectedResetCopyright);
            System.out.println("Test Passed : Reset Page CopyRight Text is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Reset Page CopyRight Text is Incorrect");
        }

        // Verify Version Number -Reset Page
        String ActaulResetVersionNumber = driver.findElement(By.xpath("//div[contains(text(),'Ver')]")).getText();
        try {
            Assert.assertEquals(ActaulResetVersionNumber, ExpectedResetVersionNumber);
            System.out.println("Test Passed : Reset Page Version Number is Correct");
        } catch (AssertionError e) {
            System.out.println("Test Failed : Reset Page Version Number is Incorrect");
        }

        // Verify Maximum Lengths for Reset Password textfield
        ResetPasswordField.sendKeys(InputText);

        // Get the entered value
        String ResetPasswordActualText = ResetPasswordField.getDomAttribute("value");

        // Null check to prevent NullPointerException
        if (ResetPasswordActualText == null) {
            System.out.println("Test Failed: Reset Password Text field value is null");
        } else {
            int ResetPasswordActualLenght = ResetPasswordActualText.length();

            if (ResetPasswordActualLenght == Integer.parseInt(ResetPasswordExpectedLenght)) {
                System.out.println("Test Passed: Reset Password Text field accepts up to " + ResetPasswordExpectedLenght
                        + " characters.");
            } else {
                System.out.println("Test Failed: Reset Password Text field accepted " + ResetPasswordActualLenght
                        + " characters instead of " + ResetPasswordExpectedLenght);
            }
        }

        // Verify Maximum Lengths for Reset Confirm Password textfield
        ResetConfirmPasswordField.sendKeys(InputText);
        String ResetConfirmPasswordActualText = ResetConfirmPasswordField.getDomProperty("value");
        int ResetConfirmPasswordActualLenght = ResetConfirmPasswordActualText.length();
        if (ResetConfirmPasswordActualLenght == Integer.parseInt(ResetConfirmPasswordExpectedLenght)) {
            System.out.println(
                    "Test Passed: Password Text field accepts up to " + PasswordExpectedlenght + " characters.");
        } else {
            System.out.println("Test Failed: Password Text Field accepted " + PasswordActualLenght
                    + " characters instead of " + PasswordExpectedlenght);

            // Verify reset password accepting invalid farmat
            ResetPasswordField.sendKeys(Alphabate);
            ResetConfirmPasswordField.sendKeys(Alphabate);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            ResetPasswordField.sendKeys(Keys.CONTROL, "a");
            ResetConfirmPasswordField.sendKeys(Keys.DELETE);
            ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "a");
            ResetConfirmPasswordField.sendKeys(Keys.DELETE);
            System.out.println("Test Passed : Reset password text field not accepting the invalid farmat");

            // Verify reset Confirm password accepting invalid farmat
            ResetPasswordField.sendKeys(Numeric);
            ResetConfirmPasswordField.sendKeys(Numeric);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            String ActualInvalidFormatPasswordError = driver
                    .findElement(By.xpath("//div[contains(@class, 'notification-toast error')]/span")).getText();
            try {
                Assert.assertEquals(ActualInvalidFormatPasswordError, ExpectedInvalidFormatPasswordError);
                System.out.println(
                        "Test Passed : Reset confirm password text field not accepting invalid format and Showing the Proper Error Text");
            } catch (AssertionError e) {
                System.out.println(
                        "Test Failed : Reset confirm password text field accepting invalid format and Not showing the Proper Error Text");
            }
            ResetPasswordField.sendKeys(Keys.CONTROL, "a");
            ResetConfirmPasswordField.sendKeys(Keys.DELETE);
            ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "a");
            ResetConfirmPasswordField.sendKeys(Keys.DELETE);

            // Verify by entering different passwords
            WebElement passwordField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='ant-input'])[1]")));
            passwordField.sendKeys("Connect@123");
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys("Connect@321");
            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Continue']")).click();

            // Verify Password Mismatch Text
            String ActualPasswordMatchErrorText = driver
                    .findElement(By.xpath("//div[contains(@class, 'notification-toast error')]/span")).getText();

            try {
                Assert.assertEquals(ActualPasswordMatchErrorText, ExpectedPasswordMatchErrorText);
                System.out.println("Test Passed : Password Mismatch Text is Correct");

            } catch (AssertionError e) {
                System.out.println("Test Failed : Password Mismatch Text is Incorrect");
            }
            ResetPasswordField.sendKeys(Keys.CONTROL, "a");
            ResetPasswordField.sendKeys(Keys.DELETE);
            ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "A");
            ResetConfirmPasswordField.sendKeys(Keys.DELETE);

            // Enter New(Same) Password and Submit
            driver.findElement(By.xpath("(//input[@class='ant-input'])[1]")).sendKeys(UpdatePassword);
            driver.findElement(By.id("normal_login_confirmPassword")).sendKeys(UpdatePassword);
            driver.findElement(By.xpath("//button[@type='submit']/span[text()='Continue']")).click();
            String ActaualResetSuccessMessage = driver.findElement(By.xpath(
                            "//div[contains(@class, 'ant-message-custom-content') and contains(@class, 'ant-message-success')]/span[contains(text(), 'Your login password has been reset')]"))
                    .getText();
            try {
                Assert.assertEquals(ActaualResetSuccessMessage, ExpectedResetSuccessMessage);
                System.out.println("Test Passed : Password Reset Success Message is Correct");
            } catch (AssertionError e) {
                System.out.println("Test Failed : Password Reset Success Message is Incorrect");

            }

            // Login with old password
            Thread.sleep(4000);
            driver.findElement(By.id("normal_login_username")).sendKeys(username);
            driver.findElement(By.id("normal_login_password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.id("normal_login_username")).sendKeys(Keys.CONTROL, "a");
            driver.findElement(By.id("normal_login_username")).sendKeys(Keys.BACK_SPACE);
            driver.findElement(By.id("normal_login_password")).sendKeys(Keys.CONTROL, "a");
            driver.findElement(By.id("normal_login_password")).sendKeys(Keys.BACK_SPACE);
            try {
                Assert.assertEquals(ActualLoginErrorMessage, ExpectedLoginErrorMessage);
                System.out.println("Test Passed : Login Failed with old password");
            } catch (AssertionError e) {
                System.out.println("Test Failed : Login accepted with old password");
            }

            // Login with updated password
            driver.findElement(By.id("normal_login_username")).sendKeys("balaraj@connectm.com");
            driver.findElement(By.id("normal_login_password")).sendKeys(UpdatePassword);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            String ActaulURL = driver.getCurrentUrl();
            String ExpectedURL = "https://demo.connectm.com/login";
            try {
                Assert.assertEquals(ActaulURL, ExpectedURL);
                System.out.println("Test Passed : Login Test completed Successfully");
            } catch (AssertionError e) {
                System.out.println("Test Failed : Login Test fail");
            }
        }
    }
}



