package com.automation.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.automation.utilities.ExtentManager;
import com.automation.utilities.TestUtil;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.automation.base.TestBase;
/*import com.automation.utilities.ExtentManager;
import com.automation.utilities.MonitoringMail;
import com.automation.utilities.TestConfig;
import com.automation.utilities.TestUtil;*/


public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

    static Date d = new Date();
    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
    static String messageBody;
    private static ExtentReports extent = ExtentManager.getInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);
    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {


    /*    ExtentTest test = extent.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
        testReport.set(test);
*/

        test = extent.startTest(result.getName().toUpperCase());

        //runmode = Y
        System.out.println(TestUtil.isTestRunnable(result.getName(),excel));

       /* if (!TestUtil.isTestRunnable(result.getName(), excel)) {
            throw new SkipException("skip test: " + result.getName().toUpperCase() + " skip the test case as runmode = N ");
        }*/
    }

    public void onTestSuccess(ITestResult result) {

/*

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
*/
        test.log(LogStatus.PASS, result.getName().toUpperCase() + "PASS");
        extent.endTest(test);
    }

    public void onTestFailure(ITestResult result) {


       /* String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
*/

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {

            TestUtil.captureScreenshot();
           /* testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
                            .build());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, result.getName().toUpperCase() + "FAIL" + result.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
        extent.endTest(test);

        String failureLog = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        //  testReport.get().log(Status.FAIL,m);

    }

    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        //  testReport.get().skip(m);
        test.log(LogStatus.SKIP,result.getName().toUpperCase()+"skipped the run mode = N");
        extent.endTest(test);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onStart(ITestContext context) {


    }

    public void onFinish(ISuite arg0) {

       /* MonitoringMail mail = new MonitoringMail();

        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

*/
    }

    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub

    }

    public void onFinish(ITestContext context) {


        if (extent != null) {

            extent.flush();
        }

    }

}
