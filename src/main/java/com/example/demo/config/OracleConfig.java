//package com.example.demo.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//@MapperScan(value={"com.example.demo.dao"}, sqlSessionFactoryRef = "oracleSqlSessionFactory")
//public class OracleConfig {
//
//    @Bean(name = "oracleDataSource")
//    @ConfigurationProperties(prefix="spring.datasource.oracle")
//    @Primary
//    public DataSource oracleDataSource() throws SQLException {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "oracleSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory oracleSqlSessionFactory() throws Exception {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(oracleDataSource());
//        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return sessionFactory.getObject();
//    }
//}