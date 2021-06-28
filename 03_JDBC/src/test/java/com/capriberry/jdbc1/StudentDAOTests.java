package com.capriberry.jdbc1;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/jdbc1.xml")
@Log4j
public class StudentDAOTests {
	private JdbcTemplate template;
	private static final Logger log = LoggerFactory.getLogger(Student.class);
	@Autowired
	private StudentDao dao;
	
	@Test
	public void testExist(){
		assertNotNull(dao);
		log.info("hello");
	}
	@Test
	public void testList(){
		dao.list().forEach(System.out::println);
	}
	@Test
	public void testGetList(){ // 목록조회
	
	}
}
