package com.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@Configuration
@ComponentScan("com.mapper")
@Import({JdbcConfig.class,MybatisConfig.class})


public class SpringConfig {
	
}