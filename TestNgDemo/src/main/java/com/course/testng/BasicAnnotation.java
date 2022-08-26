package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }


    @Test
    public void testCase6(){
        System.out.println("这是测试用例2");
    }


    @BeforeMethod
    public void testCase2(){
        System.out.println("BeforeMethod方法在测试用例之前执行");
    }

    @AfterMethod
    public void testCase3(){
        System.out.println("AfterMethod方法在测试用例之后执行");
    }

    @BeforeClass
    public void testCase4(){
        System.out.println("BeforeClass在类运行之前开始执行");
    }

    @AfterClass
    public void testCase5(){
        System.out.println("AfterClass在类运行之后开始执行");
    }
}
