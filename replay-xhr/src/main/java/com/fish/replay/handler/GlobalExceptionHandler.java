package com.fish.replay.handler;

import com.fish.replay.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Result> handle500Error(Exception e) {
        // 自定义处理逻辑
//        return e.getMessage();
        String message = e.getMessage();
        Result result=new Result();
        result.setCode(500);
        result.setMsg(message);
        result.setData(null);
        result.setSuccess(false);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.error("Exception："+e);
        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
