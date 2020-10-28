package org.springframework.helloworld.beans.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/28 10:50
 */
public class AwareApplicationBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAware.class);
        HelloWorldBeanName worldBean = context.getBean(HelloWorldBeanName.class);
        System.out.printf("worldBeanName ->" + worldBean.checkBeanName());
    }
}
