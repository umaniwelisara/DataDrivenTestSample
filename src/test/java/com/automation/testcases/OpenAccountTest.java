package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Hashtable;

import static com.automation.base.TestBase.excel;

public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
    public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {

        if (!TestUtil.isTestRunnable("openAccountTest", excel)) {
            throw new SkipException("skip test: " + "openAccountTest".toUpperCase() + " skip the test case as runmode = N ");
        }

        click("openaccount_CSS");
        select("customer_CSS", data.get("customer"));
        select("currency_CSS", data.get("currency"));
        click("process_CSS");
        Thread.sleep(2000);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }

}