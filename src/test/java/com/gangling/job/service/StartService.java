package com.gangling.job.service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartService {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext context = 
				 new ClassPathXmlApplicationContext("dubbo-provider.xml");
		 context.start();
		 System.out.println("dubbo-server服务正在监听，按任意键退出");
	     System.in.read();
	}

}
