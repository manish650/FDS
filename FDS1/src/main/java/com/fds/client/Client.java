package com.fds.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fds.dto.ShopDTO;
import com.fds.service.ShopServiceImpl;
import com.fds.service.ShopServices;

public class Client {
	public static void main(String[] args) {
		ShopDTO shop=new ShopDTO();
		
		shop.setRegNo("123");
		shop.setName("Ram Genral Store");
		shop.setAdd_id("101");
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/fds/cfg/applicationContext.xml");
		ShopServices service=ctx.getBean("service",ShopServiceImpl.class);
		//System.out.println(service.registerService(shop));
		((AbstractApplicationContext) ctx).close();
	}

}
