package org.springframework.helloworld.beans.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/28 10:46
 */
@Configuration
public class ConfigAware {

    //@Bean(name = "helloWorldBeanName")
    @Bean
    public HelloWorldBeanName getHelloWorldBeanName(){
        return new HelloWorldBeanName();
    }
}
