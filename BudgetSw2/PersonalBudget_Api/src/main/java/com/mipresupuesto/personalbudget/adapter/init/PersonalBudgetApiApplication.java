package com.mipresupuesto.personalbudget.adapter.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.microsoft.applicationinsights.attach.ApplicationInsights;

@SpringBootApplication
@ComponentScan(basePackages= {"com.mipresupuesto.personalbudget"})
@EnableJpaRepositories(basePackages= {"com.mipresupuesto.personalbudget"})
@EntityScan(basePackages= {"com.mipresupuesto.personalbudget"})

public class PersonalBudgetApiApplication {

	public static void main(String[] args) {
		ApplicationInsights.attach();
		SpringApplication.run(PersonalBudgetApiApplication.class, args);
	}

}
