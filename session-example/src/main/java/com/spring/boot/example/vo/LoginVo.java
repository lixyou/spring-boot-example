package com.spring.boot.example.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 登录VO
 * @author huaijin
 */
@Setter
@Getter
public class LoginVo {

    private String userName;

    private String userPassword;
}
