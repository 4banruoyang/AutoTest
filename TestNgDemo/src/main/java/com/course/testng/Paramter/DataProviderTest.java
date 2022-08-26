package com.course.testng.Paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void test1(String name , int age){
        System.out.println("I am" +  name + "," +  age + "years old");
    }

    @DataProvider(name = "data")
    public Object[][] test2(){
        Object[][] o = new Object[][]{
                {"张三",10},
                {"迪丽热巴",18},
                {"赵露思",18}
        };

        return o;
    }

}
