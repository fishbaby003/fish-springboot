package com.fish.feign.entity;

import com.fish.feign.config.Phone;
import lombok.Data;
import javax.validation.constraints.*;

/**
 * @author fish
 */
@Data
public class User {

  @NotBlank(message = "用户姓名不能为空")
  private String name;

  @NotBlank(message = "密码不能为空")
  @Size(min = 6, message = "密码长度不能少于6位")
  private String password;

  @Min(value = 0, message = "年龄不能小于0岁")
  @Max(value = 150, message = "年龄不应超过150岁")
  private Integer age;

  @Phone
//  @Pattern(regexp ="^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$", message = "手机号格式不正确")
  private String phone;

  @Email
  @NotBlank(message = "邮箱不能为空")
  private String email;

  @Pattern(regexp ="(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "身份证格式不正确")
  @NotBlank(message = "身份证不能为空")
  private String idCard;

//  @Pattern(regexp ="^[\u4E00-\u9FA5A-Za-z-]{4}-[\u4E00-\u9FA5A-Za-z-]{4}-[\u4E00-\u9FA5A-Za-z-]{4}-[\u4E00-\u9FA5A-Za-z-]{4}$", message = "地址格式不正确") //测试as-测试aw-测试as-测试ad
  /**
   *  测待-测中文-测试中文-试答复
   */
  @Pattern(regexp ="^[\u4e00-\u9fa5-]{1,}-[\u4e00-\u9fa5-]{1,}-[\u4e00-\u9fa5-]{1,}-[\u4e00-\u9fa5-]{1,}$", message = "地址格式不正确")
  @NotBlank(message = "地址不能为空")
  private String addr;

}