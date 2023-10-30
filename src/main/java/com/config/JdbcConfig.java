package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;



public class JdbcConfig {
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("ll075329");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Asia/Shanghai");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       
        //连接池最小空闲的连接数
//        dataSource.setMinIdle(5);
//        //连接池最大活跃的连接数
//        dataSource.setMaxActive(20);
//        //初始化连接池时创建的连接数
//        dataSource.setInitialSize(10);
        return dataSource;
    }
}

