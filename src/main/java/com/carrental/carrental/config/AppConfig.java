package com.carrental.carrental.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@Configuration
@EnableTransactionManagement
@EnableAsync
@EnableAspectJAutoProxy
public class AppConfig {

    // ==============================
    // SYSTEM CLOCK (Testable Time)
    // ==============================
    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }

    // ==============================
    // REST CLIENT (External APIs)
    // ==============================
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
