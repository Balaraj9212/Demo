package LoginModule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static org.testng.Assert.assertEquals;

public class LoginPage extends AbstractComponent {
    WebDriver driver;
    OutlookUtility utility;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        System.out.println("Driver: " + driver);
        utility = new OutlookUtility(driver);
        PageFactory.initElements(driver, this);
    }

    //Variables
    int expectedMaxLength = 50;
    String username = "balaraj@connectm.com";
    String oldPassword = "NewPass@321";
    String newPassword = "Connect@321";
    String HomePageURL = "https://demo.connectm.com/charging_station";

    //WebElements
    @FindBy(id = "normal_login_username")
    WebElement UserNameTextField;

    @FindBy(id = "normal_login_password")
    WebElement PasswordTextField;

    @FindBy(xpath = "//div[@class='command-center-text']")
    WebElement ApplicationName;

    @FindBy(xpath = "//img[@src='https://motovolt-mv.s3.amazonaws.com/Master_Data/cmd_centre_logos/demo_brand_logo.png']")
    WebElement Logo;

    By LogoLocator = By.xpath("//img[@src='https://motovolt-mv.s3.amazonaws.com/Master_Data/cmd_centre_logos/demo_brand_logo.png']");

    @FindBy(xpath = "//div[@class='login-footer']/div[contains(text(), 'Copyright')]")
    WebElement CopyRightText;

    @FindBy(xpath = "//div[@class='login-footer']/div[contains(text(),'Ver')]")
    WebElement VersionNumber;

    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    WebElement VerifyPasswordLinkText;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginButton;

    @FindBy(xpath = "//button[@type='button']")
    WebElement HideToggleButton;

    @FindBy(xpath = "//div[@class='notification-toast error']")
    WebElement LoginErrorMessage;

    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    WebElement ForgotPasswordButton;

    @FindBy(xpath = "//div[contains(@class, 'notification-toast succes')]/span")
    WebElement ForgotPasswordToast;

    By ForgotPasswordToastLocator = By.xpath("//div[contains(@class, 'notification-toast succes')]/span");

    @FindBy(xpath = "//div[@class='forgot-password-label']")
    WebElement ResetPasswordInstructionText;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    WebElement ResetPasswordField;

    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement ResetConfirmPasswordField;

    @FindBy(xpath = "//div[contains(text(),'Copy')]")
    WebElement ResetCopyRightText;

    @FindBy(xpath = "//div[contains(text(),'Ver')]")
    WebElement ResetVersionNumber;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    WebElement ResetHideToggleButton;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement ResetConfirmHideToggleButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement ResetPageSubmitButton;

    @FindBy(xpath = "//div[contains(@class, 'notification-toast error')]/span")
    WebElement ResetPageInvalidFormatErrorText;

    @FindBy(xpath = "//div[contains(@class, 'notification-toast error')]/span")
    WebElement ResetPagePasswordDoNotMatchErrorText;

    @FindBy(xpath = "//div[contains(@class, 'ant-message-custom-content') and contains(@class, 'ant-message-success')]/span[contains(text(), 'Your login password has been reset')]")
    WebElement ResetPageSuccessToast;

    By  ResetPageSuccessToastLocator = By.xpath("//div[contains(@class, 'ant-message-custom-content') and contains(@class, 'ant-message-success')]/span[contains(text(), 'Your login password has been reset')]");

    @FindBy(xpath = "//span[@class='ant-avatar-string']")
    WebElement ProfileIcon;

    @FindBy(xpath = "//button[@class='ant-btn']")
    WebElement SIgnOutButton;

    @FindBy(xpath = "//div[contains(text(),\"'password' is required\")]")
    WebElement PasswordRequiredText;


    //Actions
    public String getApplicationName() {
        return ApplicationName.getText();
    }

    public String getCopyrightText() {
        return CopyRightText.getText();
    }

    public String getVersionNumber() {
        return VersionNumber.getText();
    }

    public String getVerifyPasswordLinkText() {
        return VerifyPasswordLinkText.getText();
    }

    public String getLoginErrorMessage() {
        return LoginErrorMessage.getText();
    }


    public String getForgotPasswordToast() {
        return ForgotPasswordToast.getText();
    }

    public String getResetPasswordInstructionText() {
        return ResetPasswordInstructionText.getText();
    }

    public String getResetCopyRightText() {
        return ResetCopyRightText.getText();
    }

    public String getResetVersionNumber() {
        return ResetVersionNumber.getText();
    }

    public String getResetPageInvalidFormatErrorText() {
        return ResetPageInvalidFormatErrorText.getText();
    }

    public String getPasswordResetSuccessToast() {
        return ResetPageSuccessToast.getText();
    }

    public By getLogoLocator() {
        return LogoLocator;
    }
     public By ForgotToastLocator(){
      return ForgotPasswordToastLocator;
     }

        public boolean isLogoDisplayed() {
        WebElementToAppear(getLogoLocator());
        return Logo.isDisplayed();
    }

    public String getResetPagePasswordDoNotMatchErrorText() {
        return ResetPagePasswordDoNotMatchErrorText.getText();
    }

    public String getPasswordRequiredText(){
        return PasswordRequiredText.getText();
    }

    public void ClearUserNameTextField() {
        UserNameTextField.sendKeys(Keys.CONTROL, "a");
        UserNameTextField.sendKeys(Keys.DELETE);
    }

    public void ClearPasswordTextField() {
        PasswordTextField.sendKeys(Keys.CONTROL, "a");
        PasswordTextField.sendKeys(Keys.DELETE);
    }

    public void ClearUsernameAndPasswordTextField() {
        UserNameTextField.sendKeys(Keys.CONTROL, "a");
        UserNameTextField.sendKeys(Keys.DELETE);
        PasswordTextField.sendKeys(Keys.CONTROL, "a");
        PasswordTextField.sendKeys(Keys.DELETE);

    }

    public void ClearResetPasswordTextField() {
        ResetPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetPasswordField.sendKeys(Keys.DELETE);
    }

    public void ClearResetConfirmPasswordTextField() {
        ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetConfirmPasswordField.sendKeys(Keys.DELETE);
    }

    public void ClearResetPasswordAndConfirmPasswordTextField() {
        ResetPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetPasswordField.sendKeys(Keys.DELETE);
        ResetConfirmPasswordField.sendKeys(Keys.CONTROL, "a");
        ResetConfirmPasswordField.sendKeys(Keys.DELETE);
    }

    public void EmptyUserNameAndPassword() {
        UserNameTextField.sendKeys("");
        PasswordTextField.sendKeys("");
        LoginButton.click();
    }

    public void UserNameFieldSensitive() throws InterruptedException {
        Thread.sleep(5000);
        UserNameTextField.sendKeys(username.toUpperCase());
        PasswordTextField.sendKeys(oldPassword);
        LoginButton.click();
    }

    public void PasswordFieldSensitive() throws InterruptedException {
        UserNameTextField.sendKeys(username);
        PasswordTextField.sendKeys(oldPassword.toUpperCase());
        LoginButton.click();
        Thread.sleep(5000);
    }

    public String PasswordHideToggle() {
        waitForLoginPage();
        String FieldType = PasswordTextField.getDomAttribute("type");
        return FieldType;
    }


    public int UserActualTextLength() {
        ClearUserNameTextField();
        ClearPasswordTextField();
        UserNameTextField.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789");
        String ActualText = UserNameTextField.getDomAttribute("value");
        int actualLength = ActualText.length();
        return actualLength;
    }

    public int PasswordActualTextLength() throws InterruptedException {
        ClearUserNameTextField();
        ClearPasswordTextField();
        //Thread.sleep(5000);
        PasswordTextField.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789");
        String ActualPasswordText = PasswordTextField.getDomAttribute("value");
        int ActualPasswordLength = ActualPasswordText.length();
        return ActualPasswordLength;
    }

    public void EnterInvalidUsernameAndValidPassword() throws InterruptedException {
        Thread.sleep(5000);
        ClearUsernameAndPasswordTextField();
        UserNameTextField.sendKeys("balu@connectm.com");
        PasswordTextField.sendKeys("Connect@123");
        LoginButton.click();
    }

    public void EnterValidUsernameAndInvalidPassword() {
        ClearUsernameAndPasswordTextField();
        UserNameTextField.sendKeys("balu@connectm.com");
        PasswordTextField.sendKeys("Connect@123");
        LoginButton.click();
    }

    public void PasswordResetToast() throws InterruptedException {
        ClearUsernameAndPasswordTextField();
        UserNameTextField.sendKeys("balaraj@connectm.com");
        ForgotPasswordButton.click();
        WebElementToAppear(ForgotPasswordToastLocator);
    }

    public void OutlookUtility() throws InterruptedException {
        utility.Outlook();
    }
    public void ClickOnLoginWithoutValues() {
        ResetPasswordField.sendKeys("");
        ResetConfirmPasswordField.sendKeys("");
        LoginButton.click();
    }

    public String ResetPasswordHideToggle() {
        String FieldType2 = ResetPasswordField.getDomAttribute("type");
        return FieldType2;
    }

    public String ResetConfirmPasswordHideToggle() {
        String FieldType3 = ResetConfirmPasswordField.getDomAttribute("type");
        return FieldType3;
    }

    public int ResetPasswordFieldLength() {
        ClearResetPasswordTextField();
        ResetPasswordField.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789");
        String ActualResetFieldText = ResetPasswordField.getDomAttribute("value");
        int ActualResetFieldTextLength = ActualResetFieldText.length();
        return ActualResetFieldTextLength;
    }

    public int ResetConfirmPasswordFieldLength() {
        ClearResetConfirmPasswordTextField();
        ResetConfirmPasswordField.sendKeys("0123456789012345678901234567890123456789012345678901234567890123456789");
        String ActualResetConfirmFieldText = ResetPasswordField.getDomAttribute("value");
        int ActualResetConfirmFieldTextLength = ActualResetConfirmFieldText.length();
        return ActualResetConfirmFieldTextLength;
    }

    public void SendOnlyTest() {
        ClearResetPasswordAndConfirmPasswordTextField();
        ResetPasswordField.sendKeys("aaaaaaa");
        ResetConfirmPasswordField.sendKeys("aaaaaaa");
        ResetPageSubmitButton.click();
    }

    public void SendOnlyNumbers() {
        ClearResetPasswordAndConfirmPasswordTextField();
        ResetPasswordField.sendKeys("1234567898989");
        ResetConfirmPasswordField.sendKeys("1234567898989");
        ResetPageSubmitButton.click();
    }

    public void AcceptingDifferentPasswords() {
        ClearResetPasswordAndConfirmPasswordTextField();
        ResetPasswordField.sendKeys("Connect@123");
        ResetConfirmPasswordField.sendKeys("Connect@321");
        ResetPageSubmitButton.click();
    }


    public void SetSamePassword() throws InterruptedException {
        ClearResetPasswordAndConfirmPasswordTextField();
        ResetPasswordField.sendKeys(newPassword);
        ResetConfirmPasswordField.sendKeys(newPassword);
        ResetPageSubmitButton.click();
            }

    public void LoginWithOldPassword() {
        UserNameTextField.sendKeys(username);
        PasswordTextField.sendKeys(oldPassword);
        LoginButton.click();
    }

    public void LoginWithNewPassword() throws InterruptedException {
        ClearUsernameAndPasswordTextField();
        UserNameTextField.sendKeys(username);
        PasswordTextField.sendKeys(newPassword);
        LoginButton.click();
        waitForHomePage();
        String CurrentURL = driver.getCurrentUrl();
        assertEquals(CurrentURL, HomePageURL);
        LogOut();
        waitForLoginPage();
        UserNameTextField.sendKeys(username);
        ForgotPasswordButton.click();
        Thread.sleep(20000);
        utility.Outlook1();
        Thread.sleep(5000);
        ResetPasswordField.sendKeys(oldPassword);
        ResetConfirmPasswordField.sendKeys(oldPassword);
        ResetPageSubmitButton.click();
    }

    public boolean Login() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.equals(HomePageURL);
    }

    public void LogOut() {
        waitForHomePage();
        ProfileIcon.click();
        waitForElementToBeClickable(SIgnOutButton);
        SIgnOutButton.click();
    }


}
