package com.test.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class TestSpring {
	@Autowired
	@Qualifier("country1")
	Country countryLocal;

	@Test
	public void testMethod() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);

		ctx.refresh();
		Country country = (Country) ctx.getBean("country2");
		// assertEquals("Same Object", country, countryLocal);
		System.out.println(ctx.getType("country1"));
		System.out.println(ctx.getBean("car"));
		ctx.close();

	}

	public static void main(String[] args) {
		MyTest myTest = new TestSpring()::testMethod;
		myTest.myTest();
		myTest= Car::test;//static type
		myTest.myTest();

	}
}
@FunctionalInterface
interface MyTest {

	public void myTest();
}

@Lazy
@Component("country1")
class Country {

	Country() {
		System.out.println("Country is class!!!");
	}

	private String countryName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

@Lazy
@Configuration
@ComponentScan(basePackages = "com.test.spring")
class AppConfig {

	@Bean("country2")
	public Country getCountry() {
		System.out.println("in country2");
		return new Country();
	}

	@Bean("car")
	@ConditionalOnBean(name = "car")
	public Car getCar() {
		System.out.println("in bean car ");
		return new Car();
	}
}

@Component
class Car {
	Car() {
		System.out.println("In component car!!!!!!");
	}
	public static void test() {
		System.out.println("in car's test!!!");
	}
}
