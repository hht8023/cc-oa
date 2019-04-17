package com.gsafety.cc.oa.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局过滤器
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }

}

