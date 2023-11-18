package com.fish.feign.handler;

import com.fish.feign.util.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fish
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BindException.class)
  public Result handleError(BindException e) {
    BindingResult bindingResult = e.getBindingResult();
    return Result.error(bindingResult.getFieldError().getDefaultMessage());
  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result handleError(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    return Result.error(bindingResult.getFieldError().getDefaultMessage());
  }

}