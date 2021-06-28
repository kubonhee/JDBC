package com.capriberry.jdbc1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.sql.Template;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

@Setter
public class StudentDao {
	// CRUD
	private JdbcTemplate template;

	public Student findBy(int studno) {
		return template.queryForObject("SELECT STUDNO, NAME, DEPTNO, PROFNO FROM STUDENT WHERE STUDNO = ?",
				new Object[] { studno }, new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						student.setStudno(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setDeptno(rs.getInt(3));
						student.setProfno(rs.getInt(4));
						return student;
					}
				});
	}

	public List<Map<String, Object>> list() {
		return template.queryForList("SELECT * FROM STUDENT");
	}

	
	public List<Student> list2() {
		return template.query(
				"SELECT STUDNO, NAME, DEPTNO, PROFNO FROM STUDENT",
				new RowMapper<Student>() {
					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						student.setStudno(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setDeptno(rs.getInt(3));
						student.setProfno(rs.getInt(4));
						return student;
					}
				});
	}

	public int write(Student student) {
		return template.update("INSERT INTO STUDENT(STUDNO, NAME, DEPTNO, PROFNO) VALUES(?,?,?,?)", 
				student.getStudno(),student.getName(), student.getDeptno(), student.getProfno());
	}
	
	public String getTimeNow(){
		return template.queryForObject("SELECT SYSDATE FROM DUAL", String.class);
	}
	

}
