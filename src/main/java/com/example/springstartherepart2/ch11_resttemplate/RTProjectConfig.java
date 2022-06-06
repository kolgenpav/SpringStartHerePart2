package com.example.springstartherepart2.ch11_resttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The configuration enables RestTemplate client and point Spring to PaymentsProxy
 * that instructs how client should be created.
 */
@Configuration
public class RTProjectConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
