package com.lunz.cpfw.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import com.lunz.cpfw.web.config.DefaultProfileUtil;

@SpringBootApplication(scanBasePackages = { "com.lunz.cpfw.web" })
@ComponentScan(basePackages = { "com.lunz.cpfw.common", "com.lunz.cpfw.web", "com.lunz.cpfw.core" })
@MapperScan("com.lunz.cpfw.web.mappers")
@EnableAsync
public class ApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApiApplication.class);
		DefaultProfileUtil.addDefaultProfile(app);
		app.run(args).getEnvironment();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApiApplication.class);
	}

	// @Bean
	// @Order(Ordered.HIGHEST_PRECEDENCE)
	// CharacterEncodingFilter characterEncodingFilter() {
	// 	CharacterEncodingFilter filter = new CharacterEncodingFilter();
	// 	filter.setEncoding("UTF-8");
	// 	filter.setForceEncoding(true);
	// 	return filter;
	// }

	// @Bean
	// public HttpMessageConverters fastJsonHttpMessageConverters() {
	// 	FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
	// 	FastJsonConfig fastJsonConfig = new FastJsonConfig();
	// 	fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	// 	fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
	// 	HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
	// 	return new HttpMessageConverters(converter);
	// }
}
