package com.fish.feign.util;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;


import java.io.IOException;





/**
 * @ClassName Hrrp
 * @Description: TODO
 * @Author yuhaibo
 * @Date 2020/2/20
 * @Version V1.0
 **/
public class ApacheCommonsHttpClient {

    public static  String cookie = "";

    public static String HttpClientLogin(String loginUrl,String userName,String password) throws IOException {
        //获取返回的参数
        String result = "";
        // 登陆 Url
        // String loginUrl = "";
        // 需登陆后访问的 Url
        //String dataUrl = "";
        HttpClient httpClient = new HttpClient();

        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod = new PostMethod(loginUrl);
        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = { new NameValuePair("username", userName), new NameValuePair("password", password) };
        postMethod.setRequestBody(data);
        try {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int statusCode=httpClient.executeMethod(postMethod);

            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpcookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpcookies.append(c.toString() + ";");
                System.out.println("cookies = "+c.toString());
            }
            //成功可以拿到cookie 所以 tmpcookies长度一定大于0
            if(tmpcookies.length()>0){
                System.out.println("模拟登录成功");
                ApacheCommonsHttpClient.cookie = tmpcookies.toString();
                result = "success";
            }else {
                System.out.println("登录失败");
                result = "error";
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public static String get(String dataUrl) throws IOException {
            HttpClient httpClient = new HttpClient();
            // 进行登陆后的操作
            GetMethod getMethod = new GetMethod(dataUrl);
            // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
            getMethod.setRequestHeader("cookie", ApacheCommonsHttpClient.cookie);
            // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
            // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
//            postMethod.setRequestHeader("Referer", "http://bbw.smartpilot.cn/");
//            postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
            httpClient.executeMethod(getMethod);
            // 打印出返回数据，检验一下是否成功
            String result = getMethod.getResponseBodyAsString();
            System.out.println(result);
            return result;
    }

    public static String post(String dataUrl,JSONObject params) throws IOException {
        HttpClient httpClient = new HttpClient();
        // 进行登陆后的操作
        PostMethod postMethod = new PostMethod(dataUrl);
        RequestEntity se = new StringRequestEntity(JSONObject.toJSON(params).toString(), "application/json", "UTF-8");
        postMethod.setRequestEntity(se);
        // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
        postMethod.setRequestHeader("cookie", ApacheCommonsHttpClient.cookie);
        // 你还可以通过 PostMethod/GetMethod 设置更多的请求后数据
        // 例如，referer 从哪里来的，UA 像搜索引擎都会表名自己是谁，无良搜索引擎除外
//            postMethod.setRequestHeader("Referer", "http://bbw.smartpilot.cn/");
//            postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
        httpClient.executeMethod(postMethod);
        // 打印出返回数据，检验一下是否成功
        String result = postMethod.getResponseBodyAsString();
        JsonObject body1 =  new Gson().fromJson(result, JsonObject.class);
        System.out.println(body1);
        return result;
    }


    public static void main(String[] args) throws IOException {
        String result = HttpClientLogin("http://www.hydrosonar.com:9891/callback?client_name=FormClient","fcgyhz","fcgyhz007");
        System.out.println(result);
    }




}


