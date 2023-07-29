package com.course.httpclient.cookie;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Deque;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String  url;
    //用来获取配置文件中的变量
    private ResourceBundle bundle;
    //此变量用来接收cookies的信息
    private CookieStore store;


    @BeforeTest
    public void beforeTest(){
      bundle = ResourceBundle.getBundle("application");
      url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result ;
        String uri = bundle.getString("getCookies.url");
       //通过本地地址+后缀的地址拼成正确的地址
        String testurl = url+uri;

        //通过httpClient中的方法执行请求返回结果
        HttpGet httpGet = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //获取cookie中的信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie:cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookiename = " + name + ";cookievalue = " + value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public  void testPostMethod() throws IOException {
        String uri = bundle.getString("postWithHeaders.url");
        //拼接完整的请求地址
        String testurl = this.url+uri;
        //声明一个Client对象用来方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","zhangsan");
        param.put("age","18");
        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies的信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理响应结果，判断返回结果是否符合预期
        //将返回结果字符串转化为JSON格式
        JSONObject resultjson = new JSONObject(result);
        //获取到结果值
       String success = (String) resultjson.get("zhangsan");
       String status = (String) resultjson.get("status");
       //进行断言
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }

}
