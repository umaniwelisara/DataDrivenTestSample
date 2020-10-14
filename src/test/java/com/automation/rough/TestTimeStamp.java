package com.automation.rough;

import java.util.Date;

public class TestTimeStamp {
    public static void main(String[] args) {

//------------------this is rough file.you can either remove this file from here-----------------
        Date d= new Date();
        String screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
        System.out.println(screenshotName);
        System.out.println(d);

    }
}
