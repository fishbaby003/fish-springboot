package com.fish.protobuf;

import com.fish.protobuf.entity.MessageUserLogin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PbTest {

	public static void main(String...strings) {
		try {
            String uri = "http://127.0.0.1:5013/pbtest";
            MessageUserLogin.MessageUserLoginRequest.Builder builder = MessageUserLogin.MessageUserLoginRequest.newBuilder();
            builder.setUsername("tom");
            builder.setPassword("123456");
            HttpResponse response = doPost(uri, builder.build().toByteArray());
            MessageUserLogin.MessageUserLoginResponse messageUserLoginResponse = MessageUserLogin.MessageUserLoginResponse.parseFrom(response.getEntity().getContent());
            System.out.println("response:" + messageUserLoginResponse.toString());
            System.err.println(messageUserLoginResponse.getAccessToken());
        } catch (Exception e) {
            System.out.println("111111"+e);
        }
	}

	private static HttpResponse doPost(String uri, byte[] bytes) throws Exception {
        CloseableHttpResponse closeableHttpResponse = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost post = new HttpPost(uri);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
            post.setEntity(inputStreamEntity);
            post.addHeader("Content-Type", "application/x-protobuf");
            closeableHttpResponse = httpclient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // httpclient.close();
        }
        return closeableHttpResponse;
    }
}