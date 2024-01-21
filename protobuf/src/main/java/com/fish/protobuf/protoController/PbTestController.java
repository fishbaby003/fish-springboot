package com.fish.protobuf.protoController;

import java.util.UUID;

import com.fish.protobuf.entity.MessageUserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fish
 */
@Controller
public class PbTestController {
    @RequestMapping(value = "/pbtest", produces = "application/x-protobuf")
    @ResponseBody
    public MessageUserLogin.MessageUserLoginResponse getPersonProto(@RequestBody MessageUserLogin.MessageUserLoginRequest request) {
    	System.out.println("request:" + request.toString());

        MessageUserLogin.MessageUserLoginResponse.Builder builder = MessageUserLogin.MessageUserLoginResponse.newBuilder();
        builder.setAccessToken(UUID.randomUUID().toString()+"_res");
        builder.setUsername(request.getUsername()+"_res");
        return builder.build();
    }
}