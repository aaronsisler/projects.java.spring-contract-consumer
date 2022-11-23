package com.ebsolutions.spring_cdc.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "producer-service")
public class ProducerConfig {
    private String url;
    private Integer port;

    public String getUrl() {
        return url;
    }

    public Integer getPort() {
        return port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
