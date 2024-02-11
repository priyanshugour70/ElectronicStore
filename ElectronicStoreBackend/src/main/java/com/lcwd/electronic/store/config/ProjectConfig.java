package com.lcwd.electronic.store.config;

import com.cloudinary.Cloudinary;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }


    @Bean
    public Cloudinary getCloudinary() {
        Map config = new HashMap();
        config.put("cloud_name", "dzt0sficj");
        config.put("api_key", "296397932259591");
        config.put("api_secret", "qfPCg5U-zdFH8gF0TKUFb_TAYIQ");
        config.put("secure", true);
        return new Cloudinary(config);

    }

}
