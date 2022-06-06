package com.example.springstartherepart2.ch11_openfeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration enables OpenFeign client and point Spring to PaymentsProxy
 * that instructs how client should be created.
 */
@Configuration
@EnableFeignClients(basePackages = "com.example.springstartherepart2.ch11_openfeign.proxy")
public class OFProjectConfig {
}
