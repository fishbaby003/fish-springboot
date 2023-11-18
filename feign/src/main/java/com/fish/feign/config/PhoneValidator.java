package com.fish.feign.config;

import lombok.extern.slf4j.Slf4j;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Slf4j
public class PhoneValidator implements ConstraintValidator<Phone, String> {
  private static final String REGEX = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$";

  @Override
  public boolean isValid(String s, ConstraintValidatorContext context) {
    boolean result = false;
    try {
      result = Pattern.matches(REGEX, s);
    } catch (Exception e) {
      log.error("验证手机号格式时发生异常，异常信息：", e);
    }
    return result;
  }
}