package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class TestCircularDepedency {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigCircularDepend.class);
		ctx.refresh();
		ctx.close();
	}
}

@Component
@Lazy
class A {

	B b;

	private ApplicationContext context;

	public void dsiplay() {
		System.out.println("In  A's B ");
	}

	@Autowired
	public A(B b) {
		this.b = b;
	}

}

@Component
@Lazy
class B {

	A a;

	public void dsiplay() {
		System.out.println("In  B's A ");
	}

	@Autowired
	public B(A a) {
		this.a = a;
	}

}

@Configuration
@ComponentScan(basePackages = "com.test.spring")
class AppConfigCircularDepend {

}
