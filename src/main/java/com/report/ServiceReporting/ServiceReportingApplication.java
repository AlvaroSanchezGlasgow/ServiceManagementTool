package com.report.ServiceReporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class ServiceReportingApplication extends SpringBootServletInitializer {

	private int maxUploadSizeInMb = 20 * 1024 * 1024; // 50 MB
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceReportingApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(ServiceReportingApplication.class);
	}

	
	private static Class<ServiceReportingApplication> applicationClass = ServiceReportingApplication.class;
}
