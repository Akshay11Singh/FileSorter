package com.ashelsha.file.Ashlesha.File.Sorter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.ashlesha.filesorter.controller" })
public class AshleshaFileSorterApplication {

	public static void main(String[] args) {

		SpringApplication.run(AshleshaFileSorterApplication.class, args);

	}

}
