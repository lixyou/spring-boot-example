package com.spring.boot.example.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户Vo
 *
 * @author huaijin
 */
@Setter
@Getter
@Builder
public class UserVo {

    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
