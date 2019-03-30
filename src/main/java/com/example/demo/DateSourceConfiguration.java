package com.example.demo;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@MapperScan("com.example.demo")
public class DateSourceConfiguration {
	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jdbcUsername ;
	@Value("${jdbc.password}")
	private String jdbcPassword;
	
	@Bean(name="dataSource")
	public ComboPooledDataSource createDateSource() throws PropertyVetoException {
		ComboPooledDataSource dateSource = new ComboPooledDataSource();
		dateSource.setDriverClass(jdbcDriver);
		dateSource.setJdbcUrl(jdbcUrl);
		dateSource.setUser(jdbcUsername);
		dateSource.setPassword(jdbcPassword);
		dateSource.setAutoCommitOnClose(false);
		return dateSource;
	
	}
}
