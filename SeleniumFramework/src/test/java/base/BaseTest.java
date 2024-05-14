package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public ExtentTest logger;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extend;

    @BeforeTest
    public void beforeTestMethod() {

            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "SDETADDAExtendReport.html");
            extend = new ExtentReports();
            extend.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.DARK);
            extend.setSystemInfo("HostName", "RHEL8");
            extend.setSystemInfo("UserName", "root");
            sparkReporter.config().setDocumentTitle("AutomationReport");
            sparkReporter.config().setReportName("Automation Test Result");

    }
        @BeforeMethod
        @Parameters("browser")
        public void beforeMethod(String browser, Method testMehod)
        {
            logger = extend.createTest(testMehod.getName());
            setupDriver(browser);
            driver.get(Constants.url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-Test case Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test case PASS", ExtentColor.GREEN));
        }
        driver.quit();
    }



    @AfterTest
    public void afterTest(){
        extend.flush();
    }
    public void setupDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();}
                else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();}
                    else if (browser.equalsIgnoreCase("edge")){
                        WebDriverManager.edgedriver().setup();
                        }

                    }
                }





