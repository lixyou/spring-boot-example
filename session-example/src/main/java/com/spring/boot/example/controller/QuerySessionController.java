package com.spring.boot.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 查询
 *
 * @author huaijin
 */
@RestController
@RequestMapping("/session")
public class QuerySessionController {

    @GetMapping("/query.do")
    public String querySessionId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "error";
        }
        System.out.println("current's user is:" + session.getId() +  "in session");
        return "ok";
    }
}
