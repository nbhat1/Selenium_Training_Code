package utilities;

import com.automationpractice.test.common.CommanFunction;
import com.automationpractice.test.pages.CreateAccountPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Created by neeraj.bhatnagar on 12/19/2016.
 */
public class Listeners extends CommanFunction implements ITestListener{

    static Logger log = Logger.getLogger(CreateAccountPage.class.getName());

    public Listeners() {
    }

    public Listeners(WebDriver driver) {
        super( driver );
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    /**
     * This funtion will invoke when any test fails & will capture screesnhot of failed test case in user directory
     * under Screenshots folder.
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {

        String methodName = result.getName().toString().trim();
        try {
            CommanFunction.captureScreenshot(methodName);
            log.info("Method"+" "+methodName+" "+"Failed.Please see screenshot in Screenshots folder");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
