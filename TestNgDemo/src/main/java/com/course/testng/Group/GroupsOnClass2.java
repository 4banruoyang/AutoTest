package com.course.testng.Group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("GroupsOnClass2中的stu111运行");
    }

    public void stu2(){
        System.out.println("GroupsOnClass2中的stu222运行");
    }
}
