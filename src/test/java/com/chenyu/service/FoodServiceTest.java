package com.chenyu.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FoodServiceTest {
	private static ConfigurableApplicationContext ctx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "classpath*:/spring/applicationContext*.xml","classpath*:/spring/jpa.xml" });
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}
	
	@Test
	public void test1() {
		System.out.println("XX");
	}
}
