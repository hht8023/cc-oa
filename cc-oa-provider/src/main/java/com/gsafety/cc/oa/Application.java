package com.gsafety.cc.oa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"com.gsafety.cc"}) // 扫描该包路径下的所有spring组件
@EnableJpaRepositories("com.gsafety.cc.oa.service.repository") // JPA扫描该包路径下的Repositorie
@EntityScan("com.gsafety.cc.oa.po") // 扫描实体类
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        setRegisterErrorPageFilter(false);
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
