package com.spring.boot.example.listener;

import com.spring.boot.example.vo.UserVo;
import org.assertj.core.api.AssertFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.session.Session;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.stereotype.Component;

/**
 * session事件监听器
 *
 * @author huaijin
 */
@Component
public class SessionEventListener implements ApplicationListener<SessionDeletedEvent> {

    private static final String CURRENT_USER = "currentUser";

    @Override
    public void onApplicationEvent(SessionDeletedEvent event) {
        Session session = event.getSession();
        UserVo userVo = session.getAttribute(CURRENT_USER);
        System.out.println("invalid session's user:" + userVo.toString());
    }
}
