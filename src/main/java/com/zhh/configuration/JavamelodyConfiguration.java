package com.zhh.configuration;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's class description http://localhost:8081/monitoring?
 * @date 2018/12/28 17:42
 */

// @Configuration
// @SuppressWarnings("unchecked")
// public class JavamelodyConfiguration {
//     @Bean
//     public FilterRegistrationBean monitorFilter() {
//         FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MonitoringFilter());
//         filterRegistrationBean.addUrlPatterns("/*");
//         return filterRegistrationBean;
//     }
//
//     @Bean
//     public ServletListenerRegistrationBean sessionListener() {
//         ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
//         servletListenerRegistrationBean.setListener(new SessionListener());
//         return servletListenerRegistrationBean;
//     }
// }
