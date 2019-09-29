package com.lunz.cpfw.common.utils;

import java.util.Locale;

import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils implements ApplicationContextAware {
	public static ApplicationContext applicationContext;

	// @Value("${white:}")
	// private String[] white;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
		// White.whiteList = white;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	public static Class<? extends Object> getType(String name) {
		return applicationContext.getType(name);
	}

	// 国际化使用
	public static String getMessage(String key) {
		return applicationContext.getMessage(key, null, Locale.getDefault());
	}

	/// 获取当前环境
	public static String getActiveProfile() {
		String[] profiles = applicationContext.getEnvironment().getActiveProfiles();

		if (profiles.length == 0) {
			return applicationContext.getEnvironment().getDefaultProfiles()[0];
		}
		return profiles[0];
	}
}