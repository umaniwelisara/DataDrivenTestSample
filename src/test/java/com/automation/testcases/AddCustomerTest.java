package com.automation.testcases;

import com.automation.base.TestBase;
import com.automation.utilities.ExcelReader;
import com.automation.utilities.TestUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Hashtable;

public class AddCustomerTest extends TestBase {

    public static ExcelReader excelReader = null;
    String projectPath = System.getProperty("user.dir");

    @Test(dataProviderClass = TestUtil.class,dataProvider = "dp")
    public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {
/*        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn_CSS"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstname_CSS"))).sendKeys(data.get("firstname"));
        driver.findElement(By.cssSelector(OR.getProperty("lastname_CSS"))).sendKeys(data.get("lastname"));
        driver.findElement(By.cssSelector(OR.getProperty("postcode_CSS"))).sendKeys(data.get("postcode"));
        driver.findElement(By.cssSelector(OR.getProperty("addbtn_CSS"))).click();*/
        click("addCustBtn_CSS");
        type("firstname_CSS",data.get("firstname"));
        type("lastname_CSS",data.get("lastname"));
        type("postcode_CSS",data.get("postcode"));
        click("addbtn_CSS");

        Thread.sleep(2000);

        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
       // driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
        alert.accept();

        Thread.sleep(2000);
    }

  /*  @DataProvider
    public Object[][] getData() {

        if (excelReader == null) {
            excelReader = new ExcelReader(projectPath + "/src/test/resources/excel/testdata.xlsx");
        }

        String sheetName = "AddCustomerTest";
        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][1];
        Hashtable<String,String> table = null;
        for (int rownum = 2; rownum <= rows; rownum++) {
            table = new Hashtable<String,String>();
            for (int colnum = 0; colnum < cols; colnum++) {
                table.put(excel.getCellData(sheetName, colnum, 1),excel.getCellData(sheetName, colnum, rownum));

                data[rownum - 2][0] = table;
                //data[rownum - 2][colnum] = excel.getCellData(sheetName, colnum, rownum);
            }

        }
        return data;

    }*/
}
