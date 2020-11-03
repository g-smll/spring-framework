package org.springframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2020/11/3 17:55
 */
public class TestSpringApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.toString());
    }
}
