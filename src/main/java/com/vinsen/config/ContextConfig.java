package com.vinsen.config;

import com.vinsen.filter.CommFilter;
import com.vinsen.http.message.Message;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author zhangshengwen
 * @date 2017/11/7
 */
@Configuration
public class ContextConfig {


    @ExceptionHandler(RuntimeException.class)
     public Message exceptionHandler() {

         return new Message();
    }

    public FilterRegistrationBean commConfig(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new CommFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }


}
