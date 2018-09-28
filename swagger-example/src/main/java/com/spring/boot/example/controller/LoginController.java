package com.spring.boot.example.controller;

import com.spring.boot.example.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @author huaijin
 */
@Api(value = "LoginController", description = "登录控制器")
@RestController
public class LoginController {


    @ApiOperation(value = "用户登录", notes = "登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userVo", value = "用户信息",
                    required = true, dataType = "UserVo"),
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody UserVo userVo) {
        return "ok";
    }
}
