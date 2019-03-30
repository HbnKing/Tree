package com.example.demo;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {
	@Value("${mybatis_config_file}")
	private String mybatisConfigFilePath;

	@Value("${mapper_path}")
	private String maperPath;

	@Value("${entity_Package}")
	private String entityPackage;

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置mybatis configuration 扫描路径

		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		// 添加mapper 扫描路径

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + maperPath;

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));

		// 设置dataSource

		sqlSessionFactoryBean.setDataSource(dataSource);

		// 设置typeAlias 包扫描路径

		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

		return sqlSessionFactoryBean;

	}
}
