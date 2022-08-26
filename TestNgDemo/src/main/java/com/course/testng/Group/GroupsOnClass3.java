package com.course.testng.Group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void tea1(){
        System.out.println("GroupsOnClass3中的tea111运行");
    }
    public void tea2(){
        System.out.println("GroupsOnClass3中的tea222运行");
    }
}
