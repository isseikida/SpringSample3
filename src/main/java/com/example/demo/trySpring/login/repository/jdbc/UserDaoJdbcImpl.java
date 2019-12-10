package com.example.demo.trySpring.login.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.trySpring.login.domain.model.User;
import com.example.demo.trySpring.login.repository.UserDao;




@Repository
public class UserDaoJdbcImpl implements UserDao{


	@Autowired
	JdbcTemplate jdbc;

	//Userテーブルの件数を取得
	@Override
	public int count() throws DataAccessException{

		//全件取得してカウント
		int count=jdbc.queryForObject("SELECT COUNT(*) FROM m_user",Integer.class);
		return count;
	}



	//Userテーブルのデータを1件登録
	@Override
	public int insertOne(User user)throws DataAccessException{

		//NO.3043 : insert
		//1件登録
		int rowNumber=jdbc.update("INSERT INTO m_user(user_id,"

				+" password,"
				+" user_name,"
				+" birthday,"
				+" age,"
				+" marriage,"
				+" role)"
				+" VALUES(?,?,?,?,?,?,?)"
				, user.getUserId()
				, user.getPassword()
				, user.getUserName()
				, user.getBirthday()
				, user.getAge()
				, user.isMarriage()
				, user.getRole());


		return rowNumber;
	}


	//Userテーブルのデータを1件取得
	@Override
	public User selectOne(String userId)throws DataAccessException{

		//No3400 : 1件取得
		Map<String,Object>map=jdbc.queryForMap("SELECT * FROM m_user"

				+" WHERE user_id=?"
				,userId);

		System.out.println("SELECT(1件)処理 : 1");

		//結果返却用の変数
		User user = new User();

		System.out.println("SELECT(1件)処理 : 2");

		//取得したデータを結果返却用の変数にセットしていく
		user.setUserId((String)map.get("user_id"));
		user.setPassword((String)map.get("password"));
		user.setUserName((String)map.get("user_name"));
		user.setBirthday((Date)map.get("birthday"));
		user.setAge((Integer)map.get("age"));
		user.setMarriage((Boolean)map.get("marriage"));
		user.setRole((String)map.get("role"));
		System.out.println("SELECT(1件)処理 : 3");


		return user;
	}


	//Userテーブルの全データを取得
	@Override
	public List<User>selectMany()throws DataAccessException{
		System.out.println("SELECT(1件)処理 : 14");

		//NO.3194 : 複数件のselect
		//m_userテーブルのデータを全件取得
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM m_user");
		System.out.println("SELECT(1件)処理 : 15");

		//結果返却用の変数
		List<User>userList = new ArrayList<>();
		System.out.println("SELECT(1件)処理 : 16");

		//取得したデータを結果返却用のListに格納していく
		for(Map<String,Object>map:getList) {
			System.out.println("SELECT(1件)処理 : 17");

			//Userインスタンスの生成
			User user = new User();
			System.out.println("SELECT(1件)処理 : 18");

			//Userインスタンスに取得したデータをセット
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((Integer)map.get("age"));
			user.setMarriage((Boolean)map.get("marriage"));
			user.setRole((String)map.get("role"));
			System.out.println("SELECT(1件)処理 : 19");

			//結果返却用のListに追加
			userList.add(user);
			System.out.println("SELECT(1件)処理 : 20");
		}
		System.out.println("SELECT(1件)処理 : 21");

		return userList;
	}


	//Userテーブルを1件更新
	@Override
	public int updateOne(User user)throws DataAccessException{
		return 0;
	}


	//Userテーブルを1件削除
	@Override
	public int deleteOne(String userId)throws DataAccessException{
		return 0;
	}


	//Usesrテーブルの全データをCSVに出力
	@Override
	public void userCsvOut() throws DataAccessException{

	}
}
