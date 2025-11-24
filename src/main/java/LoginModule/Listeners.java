package LoginModule;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    BaseTest base = new BaseTest();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
           }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Passed");
            }

    @Override
    public void onTestFailure(ITestResult result) {
       test.fail(result.getThrowable());
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String NewPath = Path + result.getMethod().getMethodName();
                try {
            FileUtils.copyFile(src, new File(NewPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(NewPath);
    }


    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        extent = BaseTest.getExtentReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
            EmailSender.sendReportEmail();
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}


