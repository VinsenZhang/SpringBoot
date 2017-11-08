package com.vinsen.config;

import com.vinsen.filter.CommFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhangshengwen
 * @date 2017/11/7
 */
@Configuration
public class ContextConfig {

    @Bean
    public FilterRegistrationBean commConfig(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new CommFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }


}
