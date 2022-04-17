package com.nhnacademy.springboot.hochul.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.nhnacademy.springboot.hochul")
public class MainConfiguration {
}
