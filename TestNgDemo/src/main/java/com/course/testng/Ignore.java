package com.course.testng;

import org.testng.annotations.Test;

public class Ignore {

    //忽略测试，没写就默认为true，写了false就不止行
    @Test
    public void ignore1(){
        System.out.println("ignore1 开始run");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 开始run");
    }
}
