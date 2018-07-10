package com.springboot.example.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Jpa配置类
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
//启用JPA事务管理
@EnableTransactionManagement(proxyTargetClass = true)
//启用资源库，并指定自定义的资源库位置
@EnableJpaRepositories(basePackages = "com.springboot.**.repository")
//指定自定义实体的位置
@EntityScan(basePackages = "com.springboot.**.entity")
public class JpaConfiguration {

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
