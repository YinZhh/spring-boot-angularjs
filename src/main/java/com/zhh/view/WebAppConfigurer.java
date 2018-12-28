package com.zhh.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's class description
 * @date 2018/12/26 11:29
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    /***
     * @description This's Method description 指定静态文件扫描路径
     * @author zhh_yin
     * @date 2018/12/26 14:00
     * @param registry org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
     * @return void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");

    }

    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        //return new LoginInterceptor();
        return null;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(getLoginInterceptor())
        //         .addPathPatterns("/**")
        //         .excludePathPatterns("/error")
        //         .excludePathPatterns("/static/*");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不再默认开启
                .allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
                .maxAge(3600);//跨域允许时间
    }
}
