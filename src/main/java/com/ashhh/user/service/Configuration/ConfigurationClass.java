package com.ashhh.user.service.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationClass {

    @Bean
    @LoadBalanced
    public RestTemplate resttemplate(){
        return new RestTemplate();
    }

}
