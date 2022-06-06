package com.example.springstartherepart2;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.springstartherepart2.ch11.proxy")
public class ProjectConfig {
}
