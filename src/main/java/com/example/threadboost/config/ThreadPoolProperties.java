package com.example.threadboost.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "threadpool")
public class ThreadPoolProperties {

    private int coreSize;
    private int maxSize;
    private int queueCapacity;
    private int keepAlive;

    public int getCoreSize() { return coreSize; }
    public void setCoreSize(int coreSize) { this.coreSize = coreSize; }

    public int getMaxSize() { return maxSize; }
    public void setMaxSize(int maxSize) { this.maxSize = maxSize; }

    public int getQueueCapacity() { return queueCapacity; }
    public void setQueueCapacity(int queueCapacity) { this.queueCapacity = queueCapacity; }

    public int getKeepAlive() { return keepAlive; }
    public void setKeepAlive(int keepAlive) { this.keepAlive = keepAlive; }
}
