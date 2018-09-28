package com.spring.boot.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * spring-session配置
 *
 * @author huaijin
 */
@Configuration
public class SessionConfigurer {

    /**
     * 任务调度器，spring-session有定时任务清理redis中session
     *
     * @return 任务调度器
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        return taskScheduler;
    }

    /**
     * 当session的属性中包含Object时，在存储到redis前需要序列化
     *
     * @return json序列化器
     */
    @Bean
    public GenericJackson2JsonRedisSerializer springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }
}
