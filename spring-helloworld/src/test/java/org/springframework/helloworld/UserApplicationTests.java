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
package org.springframework.helloworld;

import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.helloworld.dependency.BootstrapConfig;
import org.springframework.helloworld.dependency.OrderService;
import org.springframework.helloworld.dependency.UserService;

/**
 * description class UserApplicationTest.
 *
 * @author Chen Gang
 */
public class UserApplicationTests {

	@Test
	public  void getBean() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		User user = context.getBean(User.class);
		JavaConfig javaConfig = context.getBean(JavaConfig.class);
		System.out.println("user->" + user.toString() +";bean ->" + user);
		System.out.println("javaConfig bean -> " + javaConfig);
	}

	@Test
	public void testDependency(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BootstrapConfig.class);
		System.out.println("userService->" + context.getBean(UserService.class));
		System.out.println("orderService->" + context.getBean(OrderService.class));
	}
}
