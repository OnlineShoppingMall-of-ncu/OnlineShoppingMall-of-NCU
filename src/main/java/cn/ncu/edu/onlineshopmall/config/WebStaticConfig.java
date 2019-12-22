package cn.ncu.edu.onlineshopmall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源映射
 */
@Configuration
public class WebStaticConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String pathPatterns = "/pictures/**";
        String pathAbsolute= "file:D:/upload/pictures/";

        registry.addResourceHandler(pathPatterns).addResourceLocations(pathAbsolute);
    }
}
