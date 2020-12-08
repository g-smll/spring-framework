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
package org.springframework.myaop.declaring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

/**
 * description class NotVeryUsefulAspect.
 *
 * @author Chen Gang
 */
@Aspect
@Component
public class NotVeryUsefulAspect {

	@Pointcut("execution(* org.springframework.myaop.service.AopService.*(..))")
	public void pointCutTest(){
	}

	@Before("pointCutTest()")
	public void before(){
		System.out.println("before pointCutTest...");
	}

	@After("pointCutTest()")
	public void after(){
		System.out.println("after pointCutTest...");
	}
}
