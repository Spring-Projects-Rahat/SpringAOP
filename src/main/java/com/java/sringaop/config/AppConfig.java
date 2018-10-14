package com.java.sringaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.java.springaop.service,com.java.sringaop.aspects,com.java.springaop.pointcut"})
public class AppConfig {

}
