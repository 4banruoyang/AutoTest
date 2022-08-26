package com.course.testng.Group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法11111111111111111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法22222222222222222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的测试方法33333333333333333");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端的测试方法44444444444444444");
    }

    @BeforeGroups("server")
    public void  beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前的方法！！！！！！！！");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后的方法！！！！！！！！");
    }

    @BeforeGroups("client")
    public void beforGroupsOnClient(){
        System.out.println("这是客户端组运行之前的方法！！！！！！！！");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组运行之后的方法！！！！！！！！");
    }

}
