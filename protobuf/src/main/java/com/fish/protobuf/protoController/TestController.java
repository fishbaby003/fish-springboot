package com.fish.protobuf.protoController;

import com.fish.protobuf.entity.MessageUserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author fish
 */
@Controller
public class TestController {
    @PostMapping(value = "/demo/test", produces = "application/x-protobuf")
    @ResponseBody
    public String getPersonProto(@RequestBody MessageUserLogin.MessageUserLoginRequest request) {
        MessageUserLogin.MessageUserLoginResponse.Builder builder = MessageUserLogin.MessageUserLoginResponse.newBuilder();
        builder.setAccessToken(UUID.randomUUID().toString() + "_res");
        builder.setUsername(request.getUsername());

        return builder.build().getAccessToken();
    }
}