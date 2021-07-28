package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 외부에있는 폴더를 내프로젝트에서 찾을수 있도록 세팅한다
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///F:/springboot/workspace/upload/")// 이렇게
                                                                                                                 // 해주면
                                                                                                                 // /upload경로를
                                                                                                                 // 적으면
                                                                                                                 // 그
                                                                                                                 // 경로를
                                                                                                                 // F:/springboot/workspace/upload/경로로
                                                                                                                 // 바꿔준다.
                .setCachePeriod(60 * 10 * 6)// 서버부하를 줄이기위해 해당요청을 캐시에 저장해놓는 시간을 저장할 수 있다.
                .resourceChain(true).addResolver(new PathResourceResolver());

    }
}
