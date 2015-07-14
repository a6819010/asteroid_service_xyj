package com.youguu.asteroid.base;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.youguu.core.dao.DataSourceLoader;

@Configuration("asteroidContextLoader")
@ImportResource({ "classpath:spring/asteroid_applicationContext.xml" })
@ComponentScan({"com.youguu*"})
public class ContextLoader extends DataSourceLoader {

	public DataSource getDataSource(String selector, String beanName){
		return load(selector, beanName);
	}
	
	@Bean
	public SqlSessionFactory astAssistSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("ast_assist","ast_assistDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/ast-assist-mapper-config.xml"));
		return bean.getObject();
	}
	@Bean
	public PlatformTransactionManager txMatch(){
		return new DataSourceTransactionManager(getDataSource("ast_assist","ast_assistDS"));
		
	}
	
	@Bean
	public SqlSessionFactory asteroidSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("asteroid","asteroidDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/asteroid-mapper-config.xml"));
		return bean.getObject();
	}

	@Bean
	public PlatformTransactionManager txAsteroid(){
		return new DataSourceTransactionManager(getDataSource("asteroid","asteroidDS"));
		
	}
	
	@Bean
	public SqlSessionFactory ruleSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("rule","ruleDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/tradeday/mncgrule-mapper-config.xml"));
		return bean.getObject();
	}

	@Bean
	public PlatformTransactionManager txRule(){
		return new DataSourceTransactionManager(getDataSource("rule","ruleDS"));
		
	}
	
	@Bean
	public SqlSessionFactory windSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("asteroid","asteroidDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/windvane/market-windvane-mapper-config.xml"));
		return bean.getObject();
	}
	
	/**
	 * 微信红包数据源
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory wxgiftSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("wxgift","wxgiftDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/wxgift/wxgift-mapper-config.xml"));
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionFactory activitySessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("asteroid","asteroidDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/activity/activity-mapper-config.xml"));
		return bean.getObject();
	}
	

	@Bean
	public SqlSessionFactory bankSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("bank","bankDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/bank/bank-mapper-config.xml"));
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionFactory fundSessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(getDataSource("fund","fundDS"));
		DefaultResourceLoader dc=new DefaultResourceLoader();
		bean.setConfigLocation(dc.getResource("classpath:mybatis/fund/fund-mapper-config.xml"));
		return bean.getObject();
	}
	
}
