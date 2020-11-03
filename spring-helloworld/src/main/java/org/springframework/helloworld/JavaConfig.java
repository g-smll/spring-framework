package org.springframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author gang.chen
 * @description
 * @time 2020/11/3 17:55
 */
@Configuration
@ComponentScan
public class JavaConfig {

    @Bean
    public User user(){
        return new User(100,"陈纲");
    }
}
