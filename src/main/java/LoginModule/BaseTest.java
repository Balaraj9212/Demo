    package LoginModule;

    import com.aventstack.extentreports.ExtentReports;
    import com.aventstack.extentreports.reporter.ExtentSparkReporter;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;

    import java.time.Duration;


    public class BaseTest {
        String Path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        public WebDriver driver;
        static ExtentReports extent;


        @BeforeTest
        public void LaunchApplication() {
            driver = new ChromeDriver();
            driver.navigate().to("https://demo.connectm.com/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        }

       // @AfterTest
        public void tearDown() {
            driver.quit();
        }

        public static ExtentReports getExtentReports() {
            if (extent == null) {

                String Path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
                ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
                reporter.config().setReportName("Automation Test Results");
                reporter.config().setDocumentTitle("Extent Report");

                extent = new ExtentReports();
                extent.attachReporter(reporter);
                extent.setSystemInfo("Tester", "Balaraj M");
                extent.setSystemInfo("Company", "ConnectM");

                            }
            return extent;
                    }

        protected WebDriver getDriver() {
            return driver;
        }
    }
