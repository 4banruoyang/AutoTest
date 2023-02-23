package com.course.testng.Report;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ReportTest {

    @Test
    public void test1(){
      Assert.assertEquals(4,4);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);

    }

    @Test
    public void test3(){
        Assert.assertEquals("小明","小明");

    }

    @Test
    public void logDemo(){
        Reporter.log("我自己写的日志记录");
        //throw new RuntimeException("自己写的运行时异常");
    }
}
