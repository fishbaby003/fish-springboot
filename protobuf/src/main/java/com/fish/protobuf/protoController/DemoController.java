package com.fish.protobuf.protoController;

import com.fish.protobuf.entity.MessageUser;
import com.fish.protobuf.entity.MessageUserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author fish
 */
@Slf4j
@RestController
public class DemoController {

    @GetMapping(value = "/test", produces = "application/x-protobuf")
    @ResponseBody
    public MessageUser.MessageUserLogin getProto() {
        MessageUser.MessageUserLogin.Builder builder =  MessageUser.MessageUserLogin.newBuilder();
        builder.setAccessToken(UUID.randomUUID().toString()+"_res");
        builder.setUsername("abc");
        return builder.build();
    }
    @PostMapping(value = "/post/test", produces = "application/x-protobuf")
    @ResponseBody
    public MessageUser.MessageUserLogin getPostTest(@RequestBody MessageUser.MessageUserLogin request) {
        System.out.println("getPostTest request:" + request.toString());
        MessageUser.MessageUserLogin.Builder builder =  MessageUser.MessageUserLogin.newBuilder();
        builder.setAccessToken(UUID.randomUUID().toString()+"_res");
        builder.setUsername(request.getUsername());
        return builder.build();
    }

}