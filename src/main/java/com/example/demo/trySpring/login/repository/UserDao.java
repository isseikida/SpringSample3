package com.example.demo.trySpring.login.repository;



import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.trySpring.login.domain.model.User;




public interface UserDao {


	//NO.2874 : DataAccessException
	//Userテーブルの件数を取得
	public int count() throws DataAccessException;


	//Userテーブルのデータを1件insert
	public int insertOne(User user) throws DataAccessException;


	//Userテーブルのデータを1件取得
	public User selectOne(String userId)throws DataAccessException;


	//Userテーブルの全データを取得
	public List<User>selectMany() throws DataAccessException;


	//Userテーブルを1件更新
	public int updateOne(User user)throws DataAccessException;


	//Userテーブルを1件削除
	public int deleteOne(String userId)throws DataAccessException;


	//SQL取得結果をサーバーにCSVで保存する
	public void userCsvOut() throws DataAccessException;

}