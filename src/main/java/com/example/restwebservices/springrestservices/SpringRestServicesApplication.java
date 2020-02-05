package com.example.restwebservices.springrestservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@ComponentScan(basePackages={"com.example"})
@SpringBootApplication
public class SpringRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver locale= new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	
	/**
	 * It has provided the name of the property file where to reference from
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource msgSrc= new ResourceBundleMessageSource();
		msgSrc.setBasename("message");
		return msgSrc;
	}
}
