/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.mybatis;

import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mybatis.dao.UserDao;
import org.springframework.mybatis.factorybean.FactoryBeanConfig;
import org.springframework.mybatis.mybatis.GangBootstrapConfig;
import org.springframework.mybatis.mybatis.GangDao;
import org.springframework.mybatis.service.UserService;

/**
 * description class MybatisApplicationTests.
 *
 * @author Chen Gang
 */
public class MybatisApplicationTests {
	// 测试项目环境是否正常
	@Test
	public void test(){
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(MybatisBootstrapConfig.class);
		System.out.println(context.getBean(MybatisBootstrapConfig.class));
	}

	// 测试spring mybatis query
	@Test
	public void testMybatisQuery(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisBootstrapConfig.class);
		System.out.println(context.getBean(UserService.class).query().toString());
	}

	// 测试 FactoryBean
	@Test
	public void testFactoryBean(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		// 指向了SpringBean
		System.out.println("case 1 ->"+context.getBean("customizeFactoryBean"));
		// 指向了CustomizeFactoryBean
		System.out.println("case 2 ->"+context.getBean("&customizeFactoryBean"));
	}

	// 测试 Mybatis，源码分析
	@Test
	public void testMybatisSourceCode() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisBootstrapConfig.class);
		UserDao userDao = context.getBean(UserDao.class);
		System.out.println("代理对象 userDao -> " + userDao);
		System.out.println("查询结果 query   -> "	+ userDao.query());
	}

	// JAVA动态代理，简单入门
	@Test
	public void testProxy() {
		Class[] clazz = new Class[]{UserDao.class};
		System.out.println("testProxy > running...");
	}

	// 仿照mybatis,java动状态代理,生成spring bean 由容器托管
	// 知识点1， FactoryBean
	// 知识点2， java 动态代理
	// 知识点3， Spring 扫描包
	// 知识点4， ImportBeanDefinitionRegistrar
	// 知识点5， 注解开发
	@Test
	public void testMySelfMybatis() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GangBootstrapConfig.class);
		GangDao gangDaoImpl = (GangDao) context.getBean("GangDaoImpl");
		gangDaoImpl.query();
		System.out.println(context.getBean("GangDaoImpl").getClass().getSimpleName());
	}
}
