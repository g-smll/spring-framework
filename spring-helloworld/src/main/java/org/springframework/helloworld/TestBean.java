package org.springframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/10/27 19:09
 */
public class TestBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = (User)context.getBean("user");
        System.out.println(user.toString());
    }
}
