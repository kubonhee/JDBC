package com.capriberry.jdbc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		// bean 을 통한 접근 >> dao
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc1.xml");
		StudentDao dao = ctx.getBean("dao", StudentDao.class);
		System.out.println(dao.findBy(10101));
		
		dao.list().forEach(System.out::println);
		System.out.println("===========절취선==========");
//		dao.write(new Student(30303, "이본희", 101, 9901));
		dao.list().forEach(System.out::println);
		System.out.println("===========절취선==========");
		System.out.println(dao.getTimeNow());
	}
}
