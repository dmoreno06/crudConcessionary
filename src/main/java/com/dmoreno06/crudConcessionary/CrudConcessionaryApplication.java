package com.dmoreno06.crudConcessionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EntityScan("com.dmoreno06.crudConcessionary.entity")
@EnableJpaRepositories("com.dmoreno06.crudConcessionary.repository")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CrudConcessionaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudConcessionaryApplication.class, args);
	}

}
