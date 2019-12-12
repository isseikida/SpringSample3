package com.example.demo.trySpring.login.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.trySpring.login.domain.model.User;



@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl {

	@Autowired
	private JdbcTemplate jdbc;

	//ユーザー1件取得
	@Override
	public User selectOne(String userId) {

		//1件取得用SQL
		String sql = "SELECT * FROM m_user WHERE user_id = ?";

		//Rowmapperの生成
		UserRowMapper rowMapper = new UserRowMapper();

		//SQL実行
		return jdbc.queryForObject(sql, rowMapper, userId);
	}
}


