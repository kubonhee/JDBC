package com.capriberry.jdbc1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer studno;
	private String name;
	private Integer deptno;
	private Integer profno;
}
