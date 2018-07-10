package com.pache.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * 项目启动类
 * 该类使用注解：SpringBootApplication，相当于包含了如下的3个注解：
 * 1：@Configuration  将类标记为应用程序上下文的bean定义的来源。
 * 2：@EnableAutoConfiguration   让spring boot 自动加载并注入bean
 * 3：@ComponentScan  组键扫描注解，让spring boot 在当前包下寻找其他的组键，并允许它去找被注解的控制器
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 该方法在程序启动时运行，将打印有应用程序创建或spring启动而自动添加的bean，并打印出来
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
