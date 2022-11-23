package com.ebsolutions.spring_cdc.consumer.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@AllArgsConstructor
@NoArgsConstructor // needed for Jackson serialization
@Configuration
@ConfigurationProperties(prefix = "producer-service")
public class ProducerConfig {
    private String host;
    private Integer port;
}
