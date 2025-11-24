package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage Login;
    AbstractComponent Abstract;

    @BeforeMethod
    public void setup() {
        Login = new LoginPage(driver);
        Abstract = new AbstractComponent(driver);
    }

    @AfterMethod
    public void Logout() {
        if (Login.Login()) {
            Login.LogOut();
        }
    }

    @Test(priority = 1)
    public void VerifyApplicationName() {
        assertEquals(Login.getApplicationName(), "COMMAND CENTER", "Application name mismatch");
    }

    @Test(priority = 2)
    public void VerifyLogo() {
        Assert.assertTrue(Login.isLogoDisplayed(), "Logo is not displayed!");
    }

    @Test(priority = 3)
    public void VerifyCopyrightText() throws InterruptedException {
        assertEquals(Login.getCopyrightText(), "Copyright ©Motovolt 2025. All rights reserved.", "Mismatch in copyright text.");
    }

    @Test(priority = 4)
    public void VerifyVersionNumber() throws InterruptedException {
        assertEquals(Login.getVersionNumber(), "Ver : 1.11.78", "Version Number Mismatch");
    }

    @Test(priority = 5)
    public void VerifyPasswordLinkText() {
        assertEquals(Login.getVerifyPasswordLinkText(), "Forgot password?", "Forgot Password Test is not matching");
    }

    @Test(priority = 6)
    public void VerifyEmptyUsernameAndPasswordFieldsBehavior() {
        Login.EmptyUserNameAndPassword();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Login Error Message is not matching");
    }

    @Test(priority = 7)
    public void VerifyLoginErrorText() throws InterruptedException {
        Login.EnterInvalidUsernameAndValidPassword();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Login Error Text is not matching");
        Login.EnterValidUsernameAndInvalidPassword();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Login Error Text is not matching");
    }

    @Test(priority = 8)
    public void VerifyPasswordHideToggle() {
        assertEquals(Login.PasswordHideToggle(), "password", "Password field is not hidden!");
        Login.HideToggleButton.click();
        assertEquals(Login.PasswordHideToggle(), "text", "Password field is hidden!");
    }

    @Test(priority = 9)
    public void VerifyUsernameTextFieldMaxLength() {
        assertEquals(Login.UserActualTextLength(), Login.expectedMaxLength, "Username Text field accepted " + Login.UserActualTextLength() + " characters instead of " + Login.expectedMaxLength);
    }

    @Test(priority = 10)
    public void VerifyPasswordTextFieldMaxLength() throws InterruptedException {
        assertEquals(Login.PasswordActualTextLength(), Login.expectedMaxLength, "Password Text field accepted " + Login.PasswordActualTextLength() + " characters instead of " + Login.expectedMaxLength);
    }

    @Test(priority = 11)
    public void VerifyPasswordFieldCaseSensitivity() throws InterruptedException {
        Login.PasswordFieldSensitive();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Login should fail when password case is incorrect");
    }

    @Test(priority = 12)
    public void VerifyUsernameFieldCaseSensitivity() throws InterruptedException {
        Login.UserNameFieldSensitive();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Login should fail when username case is incorrect");
    }

    @Test(priority = 13)
    public void VerifyPasswordResetToast() throws InterruptedException {
        Login.PasswordResetToast();
        assertEquals(Login.getForgotPasswordToast(), " We have sent you an email with the link to reset the password!", "Password Toast message not matching");
        Login.OutlookUtility();
    }

    @Test(priority = 14)
    public void VerifyResetPasswordInstructionText() {
        assertEquals(Login.getResetPasswordInstructionText(), "Enter a new password. The password should be at least 8 characters, a mix of capital, lowercase letters, number, and a special symbol.", "Password instruction text is not matching");
    }

    @Test(priority = 15)
    public void VerifyResetPageCopyrightText() {
        assertEquals(Login.getResetCopyRightText(), "Copyright © 2025. All rights reserved.", "Reset page copyright text is matching");
    }

    @Test(priority = 16)
    public void VerifyResetPageVersionNumber() {
        assertEquals(Login.getResetVersionNumber(), "Ver : 1.11.78", "Reser version number is not matching");
    }

    @Test(priority = 17)
    public void VerifyResetPasswordEmptyFieldsBehavior() {
        Login.ClickOnLoginWithoutValues();
        assertEquals(Login.getPasswordRequiredText(), "'password' is required", "Password test is not matching");
    }

    @Test(priority = 18)
    public void VerifyResetPasswordHideToggle() {
        assertEquals(Login.ResetPasswordHideToggle(), "password", "Password field is not hidden!");
        Login.ResetHideToggleButton.click();
        assertEquals(Login.ResetPasswordHideToggle(), "text", "Password field is hidden!");
    }

    @Test(priority = 19)
    public void VerifyConfirmResetPasswordHideToggle() {
        assertEquals(Login.ResetConfirmPasswordHideToggle(), "password", "Password field is not hidden!");
        Login.ResetConfirmHideToggleButton.click();
        assertEquals(Login.ResetConfirmPasswordHideToggle(), "text", "Password field is hidden!");
    }

    @Test(priority = 20)
    public void VerifyResetPasswordTextFieldMaxLength() {
        assertEquals(Login.ResetPasswordFieldLength(), Login.expectedMaxLength, "Reset Password Text field accepted " + Login.ResetPasswordFieldLength() + " characters instead of " + Login.expectedMaxLength);
    }

    @Test(priority = 21)
    public void VerifyResetPasswordConfirmTextFieldMaxLength() {
        assertEquals(Login.ResetConfirmPasswordFieldLength(), Login.expectedMaxLength, "Reset Confirm Password Text field accepted " + Login.ResetConfirmPasswordFieldLength() + " characters instead of " + Login.expectedMaxLength);
    }

    @Test(priority = 22)
    public void VerifyResetPasswordFieldAcceptingInvalidFormat() {
        Login.SendOnlyTest();
        assertEquals(Login.getResetPageInvalidFormatErrorText(), " Invalid password format.", "Error password text is not matching");
        Login.SendOnlyNumbers();
        assertEquals(Login.getResetPageInvalidFormatErrorText(), " Invalid password format.", "Error password text is not matching");
    }

    @Test(priority = 23)
    public void VerifyResetPasswordFieldsAcceptingDifferentPasswords() {
        Login.AcceptingDifferentPasswords();
        assertEquals(Login.getResetPagePasswordDoNotMatchErrorText(), " Passwords do not match.", "Password do not match text is not matching");
    }

    @Test(priority = 24)
    public void VerifySetSamePasswordAccepting() throws InterruptedException {
        Login.SetSamePassword();
        assertEquals(Login.getPasswordResetSuccessToast(), "Your login password has been reset. You will be redirected to login screen!...", "Password success toast is not matching");
    }

    @Test(priority = 25)
    public void LoginWithOldPassword() throws InterruptedException {
        Login.LoginWithOldPassword();
        assertEquals(Login.getLoginErrorMessage(), " Unable to login. Please verify your user name or password entered.", "Should not login with old password");
    }

    @Test(priority = 26)
    public void LoginWithNewPassword() throws InterruptedException {
        Login.LoginWithNewPassword();
        assertEquals(Login.getPasswordResetSuccessToast(), "Your login password has been reset. You will be redirected to login screen!...", "Password success toast is not matching");
    }


}





