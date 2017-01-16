package com.livraria.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
				new ErrorPage(HttpStatus.FORBIDDEN, "/403")));
	}

	/*
	 * @Bean public DomainClassConverter<FormattingConversionService>
	 * domainClassConverter( FormattingConversionService conversionService) {
	 * return new
	 * DomainClassConverter<FormattingConversionService>(conversionService); }
	 */

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/livro/novo");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("templates/");
		// resolver.setSuffix(".html");
		return resolver;
	}

}
