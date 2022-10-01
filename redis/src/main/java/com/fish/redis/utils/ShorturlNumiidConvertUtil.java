package com.fish.redis.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解决淘宝客短链302跳转 / 商品数字ID转换工具类
 * (Tbk shortlink / num_iid convertor)
 * @author fish
 */
public class ShorturlNumiidConvertUtil {
    public static void main(String[] args) {
        try {
            StringBuffer buffer = new StringBuffer();

            String url = "http://s.click.taobao.com/Qpv0xTx";

            System.out.println("访问地址:" + url);

//发送get请求

            URL serverUrl = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();

            conn.setRequestMethod("GET");

//必须设置false，否则会自动redirect到重定向后的地址

            conn.setInstanceFollowRedirects(false);

            conn.addRequestProperty("Accept-Charset", "UTF-8;");

            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");

//            conn.addRequestProperty("Referer", "http://matols.com/");

            conn.connect();

//判定是否会进行302重定向

            if (conn.getResponseCode() == 302) {
//如果会重定向，保存302重定向地址，以及Cookies,然后重新发送请求(模拟请求)

                String location = conn.getHeaderField("Location");

                String cookies = conn.getHeaderField("Set-Cookie");

                serverUrl = new URL(location);

                conn = (HttpURLConnection) serverUrl.openConnection();

                conn.setRequestMethod("GET");

                conn.setRequestProperty("Cookie", cookies);

                conn.addRequestProperty("Accept-Charset", "UTF-8;");

                conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");

//                conn.addRequestProperty("Referer", "http://matols.com/");

                conn.connect();

                System.out.println("跳转地址:" + location);

            }

//将返回的输入流转换成字符串

            InputStream inputStream = conn.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;

            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);

            }

            bufferedReader.close();

            inputStreamReader.close();

// 释放资源

            inputStream.close();

            inputStream = null;

            System.out.println(buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    /*public static void main(String[] args) {
        String shortLink = "http://s.click.taobao.com/Qpv0xTx";

        System.out.println("访问地址:" + shortLink);
        URL serverUrl = null;
        try {
            *//**
     * 第一次跳转(短链 => 获取点击链接)
     *//*
            serverUrl = new URL(shortLink);
            HttpURLConnection conn1Jump = (HttpURLConnection) serverUrl
                    .openConnection();
            conn1Jump.setRequestMethod("GET");

            // 必须设置false，否则会自动redirect到Location的地址
            conn1Jump.setInstanceFollowRedirects(false);
            conn1Jump.connect();
            //response-header field,Location用于302重定向地址
            String location = conn1Jump.getHeaderField("Location");

            System.out.println("302第一次跳转地址:" + location);

            *//**
     * 第二次跳转(点击链接 => 转换成js跳转链接)
     *//*
            serverUrl = new URL(location);
            HttpURLConnection conn2Jump = (HttpURLConnection) serverUrl
                    .openConnection();
            conn2Jump.setRequestMethod("GET");

            // 必须设置false，否则会自动redirect到Location的地址
            conn2Jump.setInstanceFollowRedirects(false);
            conn2Jump.connect();
            String locaTwo = conn2Jump.getHeaderField("Location");

            System.out.println("302第2次跳转地址:" + locaTwo);

            *//**
     * 第三次跳转(js跳转链接 => 商品详情页)
     *//*
            String urlAfterDecode = URLDecoder.decode(locaTwo, "UTF-8").split("tu=")[1];
            serverUrl = new URL(urlAfterDecode);
            HttpURLConnection conn3Jump = (HttpURLConnection) serverUrl
                    .openConnection();
            conn3Jump.setRequestMethod("GET");
            conn3Jump.addRequestProperty("Referer", locaTwo);

            // 必须设置false，否则会自动redirect到Location的地址
            conn3Jump.setInstanceFollowRedirects(false);
            conn3Jump.connect();
            String locaThree = conn3Jump.getHeaderField("Location");

            System.out.println("302第3次跳转地址:" + locaThree);

            conn3Jump.disconnect();
            conn2Jump.disconnect();
            conn1Jump.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}