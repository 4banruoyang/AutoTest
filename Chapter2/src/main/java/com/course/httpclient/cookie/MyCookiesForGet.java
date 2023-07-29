package com.course.httpclient.cookie;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //声明一个变量用来存储coolies信息
    private CookieStore store;

    @BeforeTest
    public void  beforeTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");

    }


    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中获取正确的url
        String uri = bundle.getString("getCookies.url");
        String testurl = this.url+uri;
        //测试逻辑代码编写
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookies的信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + ";cookie value = " + value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("getWithCookies.url");
        String testurl = this.url+uri;

        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies的信息
        client.setCookieStore(this.store);
        HttpResponse response =  client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //输出响应状态码
        System.out.println("statusCode = " + statusCode);

        //判断状态码为200时，输出的结果
        if (statusCode==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }
}
