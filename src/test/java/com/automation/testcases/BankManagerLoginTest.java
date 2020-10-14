package com.automation.testcases;

import com.automation.base.TestBase;
import org.openqa.selenium.By;
import org.testng.*;
import org.testng.annotations.*;

import java.io.IOException;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws IOException, InterruptedException {

        //System.setProperty("org.uncommons.reportng.escape-output","false");

        verifyEquals("abc","xyz");
        Thread.sleep(3000);

        log.debug("inside login test");
        click("bmlBtn_CSS");
        //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn_CSS"))).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"login not successful");
        log.debug("execute login test");
       // Assert.fail("login not successfull");


    }
}
