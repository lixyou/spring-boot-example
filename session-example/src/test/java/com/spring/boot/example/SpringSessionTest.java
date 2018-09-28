package com.spring.boot.example;

import com.alibaba.fastjson.JSON;
import com.spring.boot.example.vo.LoginVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.Cookie;

/**
 * 测试Spring-Session：
 * 1.登录时创建session
 * 2.使用sessionId能正常访问
 * 3.session过期销毁，能够监听销毁事件
 *
 * @author huaijin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringSessionTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testLogin() throws Exception {
        LoginVo loginVo = new LoginVo();
        loginVo.setUserName("admin");
        loginVo.setUserPassword("admin@123");
        String content = JSON.toJSONString(loginVo);

        // mock登录
        ResultActions actions = this.mockMvc.perform(post("/login.do")
                .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("ok"));
        String sessionId = actions.andReturn()
                .getResponse().getCookie("SESSION").getValue();

        // 使用登录的sessionId mock查询
        this.mockMvc.perform(get("/session/query.do")
                .cookie(new Cookie("SESSION", sessionId)))
                .andExpect(status().isOk()).andExpect(content().string("ok"));

        // mock登出
        this.mockMvc.perform(post("/logout.do")
                .cookie(new Cookie("SESSION", sessionId)))
                .andExpect(status().isOk()).andExpect(content().string("ok"));
    }
}
