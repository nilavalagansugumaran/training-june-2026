package com.example.demoAutoConfigure.configuration;

import com.example.demoAutoConfigure.component.CoolBean;
import com.example.demoAutoConfigure.component.DefaultBean;
import com.example.demoAutoConfigure.component.HotBean;
import com.example.demoAutoConfigure.component.MyAutoConfigBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MyAutoConfigConfig {

    @Bean
    @ConditionalOnProperty(name = "enabled.bean", havingValue = "cool")
    public MyAutoConfigBean coolBean() {
        return new CoolBean();
    }

    @Bean
    @ConditionalOnProperty(name = "enabled.bean", havingValue = "hot")
    public MyAutoConfigBean hotBean()  {
        return new HotBean();
    }

    @Bean
    @ConditionalOnProperty(name = "enabled.bean", matchIfMissing = true)
    public MyAutoConfigBean  defaultBean() {
        return new DefaultBean();
    }
}
