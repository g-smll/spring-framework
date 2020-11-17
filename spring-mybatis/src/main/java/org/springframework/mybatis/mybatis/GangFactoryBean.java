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
package org.springframework.mybatis.mybatis;

import java.lang.reflect.Proxy;

import org.springframework.beans.factory.FactoryBean;


/**
 * description class MyFactoryBean.
 * @author Chen Gang
 * @param <T> the object type
 */

public class GangFactoryBean<T> implements FactoryBean<T> {
	// 传入对象 参照 -> GangDao.class
	private Class<T> aClass;

	public GangFactoryBean(Class<T> aClass) {
		this.aClass = aClass;
	}

	/**
	 * description return T.
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public T getObject() throws Exception {
		return (T) Proxy.newProxyInstance(GangFactoryBean.class.getClassLoader(),new Class[]{this.aClass},new GangInvocationHandler());
	}

	@Override
	public Class<?> getObjectType() {
		return this.aClass;
	}
}
