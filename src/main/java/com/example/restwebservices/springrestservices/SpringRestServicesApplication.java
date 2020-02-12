package com.example.restwebservices.springrestservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * @author ezaksch
 *
 */
@EnableJpaRepositories(basePackages={"com.example"})
@EntityScan(basePackages={"com.example"})
@ComponentScan(basePackages={"com.example"})
@SpringBootApplication
public class SpringRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServicesApplication.class, args);
	}

	/**To get the LocalSessionResolver
	 * @return
	 */
/*	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver locale= new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	*/
	
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver locale= new AcceptHeaderLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	/**
	 * It has provided the name of the property file where to reference from
	 * @return
	 */
	//This we can directly provide in application.properties
/*	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource msgSrc= new ResourceBundleMessageSource();
		msgSrc.setBasename("message");
		return msgSrc;
	}*/
}
