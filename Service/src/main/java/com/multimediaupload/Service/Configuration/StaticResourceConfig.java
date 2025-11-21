package com.multimediaupload.Service.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Replace with your actual full absolute path
        String videoDir = System.getProperty("user.dir") + "/uploads/videos/";

        registry.addResourceHandler("/videos/**")
                .addResourceLocations("file:" + videoDir);
    }
}
