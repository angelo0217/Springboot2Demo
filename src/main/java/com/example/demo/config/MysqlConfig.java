package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
//@PropertySource("classpath:application.properties")
@MapperScan(value={"com.example.demo.dao"}, sqlSessionFactoryRef = "mySqlSessionFactory")
public class MysqlConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix="spring.datasource.mysql")
    @Primary
    public DataSource mysqlDataSource() throws SQLException {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "mysqlTransactionManager")
//    @Primary
//    public DataSource mysqlTransactionManager() throws Exception, SQLException {
//        return new DataSourceTransactionManager(mysqlDataSource());
//    }

    @Bean(name = "mySqlSessionFactory")
    @Primary
    public SqlSessionFactory mySqlSessionFactory() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        org.apache.ibatis.session.Configuration cfg = new org.apache.ibatis.session.Configuration();
        cfg.setCacheEnabled(true);
        cfg.setLazyLoadingEnabled(true);

        sessionFactory.setConfiguration(cfg);
        sessionFactory.setDataSource(mysqlDataSource());
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
}