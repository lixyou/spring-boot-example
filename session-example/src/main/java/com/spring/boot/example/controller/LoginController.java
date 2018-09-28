package com.spring.boot.example.controller;

import com.spring.boot.example.vo.LoginVo;
import com.spring.boot.example.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author huaijin
 */
@RestController
public class LoginController {

    private static final String CURRENT_USER = "currentUser";

    /**
     * 登录
     *
     * @param loginVo 登录信息
     *
     * @author huaijin
     */
    @PostMapping("/login.do")
    public String login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        UserVo userVo = UserVo.builder().userName(loginVo.getUserName())
                .userPassword(loginVo.getUserPassword()).build();
        HttpSession session = request.getSession();
        session.setAttribute(CURRENT_USER, userVo);
        System.out.println("create session, sessionId is:" + session.getId());
        return "ok";
    }

    /**
     * 登出
     *
     * @author huaijin
     */
    @PostMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "ok";
    }
}
