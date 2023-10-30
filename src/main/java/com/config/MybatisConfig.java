package com.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

public class MybatisConfig {
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
		ssfb.setTypeAliasesPackage("com.pojo");
		ssfb.setDataSource(dataSource);
		
		
		return ssfb;
		
	}
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc=new MapperScannerConfigurer();
		msc.setBasePackage("com.mapper");
		return msc;
	}

}
