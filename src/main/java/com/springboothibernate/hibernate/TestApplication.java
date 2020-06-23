package com.springboothibernate.hibernate;

import com.springboothibernate.hibernate.initializer.TestDataInit;
import com.springboothibernate.hibernate.service.abstraction.OrderItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ObjectInputStream;
import java.util.ArrayList;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println(TestDataInit.getOrderItemService());
	}

	@Bean(initMethod = "init")
	public TestDataInit initTestData() {
		return new TestDataInit();
	}
}
