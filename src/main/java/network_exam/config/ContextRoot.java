package network_exam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class, MvcConfig.class})
@ComponentScan(basePackages = {"network_exam.controller",																		
																		"network_exam.service"})
public class ContextRoot {} 
