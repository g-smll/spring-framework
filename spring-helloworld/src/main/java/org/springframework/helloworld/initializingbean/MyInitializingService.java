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
package org.springframework.helloworld.initializingbean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * description class MyInitializingBean.
 *
 * @author Chen Gang
 */
@Component
public class MyInitializingService implements InitializingBean {

	MyInitializeUser initializeUser;

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("###### MyInitializingService-> afterPropertiesSet ");
	}

	@PostConstruct
	public void MyPostConstruct(){
		System.out.println("###### MyInitializingService-> MyPostConstruct ");
	}
}
