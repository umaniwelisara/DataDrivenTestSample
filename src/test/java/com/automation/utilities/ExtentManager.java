package com.automation.utilities;

import java.io.File;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;


   /* public static ExtentReports getInstance(){

        if(extent==null){


            extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));

        }

        return extent;

    }*/
   public static ExtentReports getInstance(String fileName) {


       ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);


       htmlReporter.config().setTheme(Theme.STANDARD);
       htmlReporter.config().setDocumentTitle(fileName);
       htmlReporter.config().setEncoding("utf-8");
       htmlReporter.config().setReportName(fileName);

      extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html");
      extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extentConfig\\ReportConfig.xml"));




      /*   extent.attachReporter(htmlReporter);
       extent.setSystemInfo("Automation Tester", "Ronav R");
       extent.setSystemInfo("Organization", "Way2Automation");
       extent.setSystemInfo("Build no", "W2A-1234");*/


       return extent;
   }

/*
    public static ExtentReports getInstance() {
        // TODO Auto-generated method stub
        return null;
    }
*/


}
