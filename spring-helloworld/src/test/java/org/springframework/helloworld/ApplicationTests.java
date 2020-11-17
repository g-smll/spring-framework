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
import org.springframework.helloworld.instantiation.InstantiationBootstrapConfig;
import org.springframework.helloworld.instantiation.ProductService;
import org.springframework.helloworld.reflect.Student;

/**
 * description class UserApplicationTest.
 *
 * @author Chen Gang
 */
public class ApplicationTests {

	@Test
	public  void getBean() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		User user = context.getBean(User.class);
		System.out.println("user->" + user.toString() +";bean ->" + user);

	}

	@Test
	public void testDependency(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BootstrapConfig.class);
		System.out.println("userService->" + context.getBean(UserService.class));
		System.out.println("orderService->" + context.getBean(OrderService.class));
	}

	@Test
	public void testInstantiation(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InstantiationBootstrapConfig.class);
		System.out.println("productService ->" + context.getBean(ProductService.class));
	}

	@Test
	public void testReflect(){
		Class<Student> studentClass = Student.class;
		try {
			Student student = studentClass.newInstance();
			System.out.println("student->"+student);
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
}
