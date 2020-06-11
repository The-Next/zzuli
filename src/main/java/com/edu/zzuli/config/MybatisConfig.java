package com.edu.zzuli.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.edu.zzuli.dao")
public class MybatisConfig {
}