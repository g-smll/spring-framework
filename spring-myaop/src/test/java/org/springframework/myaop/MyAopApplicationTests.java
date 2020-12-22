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
package org.springframework.myaop;

import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.myaop.config.AopAppConfig;
import org.springframework.myaop.service.AopService;

/**
 * description class MyAopApplicationTests.
 *
 * @author Chen Gang
 */
public class MyAopApplicationTests {

	//测试项目是否正常
	@Test
	public void test(){
		System.out.println("hello world");
	}

	//测试AOP基础配置
	@Test
	public void test1(){
		//
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopAppConfig.class);

		//获取spring bean实例，通过getBean获取到
		AopService aopService = context.getBean(AopService.class);
		//动态代理 -> JDK & CGLIB
		aopService.SayAop();

	}

	@Test
	public void test2(){
	}
}
