package com.example.camel;

import org.apache.camel.language.bean.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@SpringBootApplication
public class CamelApplication {

	@Value("${sampleuser.api.path}")
	String contextPath;

	@Bean(ref = "sample")
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean();
		servlet.setName("CamelServlet");
		return servlet;
	}
	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
	}

}
