package com.example.threadboost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor(ThreadPoolProperties props) {
        ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
        exec.setCorePoolSize(props.getCoreSize());
        exec.setMaxPoolSize(props.getMaxSize());
        exec.setQueueCapacity(props.getQueueCapacity());
        exec.setKeepAliveSeconds(props.getKeepAlive());
        exec.setThreadNamePrefix("async-worker-");
        exec.initialize();
        return exec;
    }
}
