package com.course.testng.Suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void  beferSuite(){
        System.out.println("beferSuite开始运行了。。。。");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite结束运行了。。。。");
    }

    @BeforeTest
    public void beferTest(){
        System.out.println("beferTest开始运行");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest结束运行");
    }

}
