package org.springframework.helloworld.beans.factory;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author gang.chen
 * @description 重点测试Aware顶级接口
 * @time 2020/10/28 10:44
 */
public class HelloWorldBeanName implements BeanNameAware {

    private String helloWorldBeanName;

    @Override
    public void setBeanName(String name) {
        System.out.println("HelloWorldBeanName name -> " + name);
        this.helloWorldBeanName = name;
    }

    public String checkBeanName(){
        return this.helloWorldBeanName;
    }
}
