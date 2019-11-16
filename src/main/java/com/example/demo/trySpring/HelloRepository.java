package com.example.demo.trySpring;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class HelloRepository {

	//ポイント2 : JdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String,Object>findOne(int id){

		//SELECT文

		String query = "SELECT"
				+" employee_id,"
				+" employee_firstname,"
				+" employee_lastname,"
				+" age,"
				+" number"
				+" FROM employee "
				+"WHERE employee_id=?";

		//検索結果
		Map<String, Object>employee = jdbcTemplate.queryForMap(query,id);


		return employee;
	}
}
