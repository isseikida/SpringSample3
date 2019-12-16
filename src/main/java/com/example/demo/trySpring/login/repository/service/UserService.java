package com.example.demo.trySpring.login.repository.service;


import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.trySpring.login.domain.model.User;
import com.example.demo.trySpring.login.repository.UserDao;



@Service
public class UserService {

	@Autowired
	@Qualifier("UserDaoJdbcImpl3")
	UserDao dao;


	//insert用メソッド
	public boolean insert(User user) {

		//insert実行
		int rowNumber=dao.insertOne(user);

		//判定用変数
		boolean result=false;

		if(rowNumber > 0) {
			//insert成功
			result=true;
		}

		return result;
	}


	//カウント用メソッド
	public int count() {
		return dao.count();
	}


	//全件取得用メソッド
	public List<User>selectMany(){

		//全件取得
		return dao.selectMany();
	}


	//1件取得用メソッド
	public User selectOne(String userId) {
		System.out.println("SELECT(1件)処理 : 13");

		//selectOne実行
		return dao.selectOne(userId);

	}


	//1件更新メソッド
	public boolean updateOne(User user) {

		//1件更新
		int rowNumber = dao.updateOne(user);


		//判定用変数
		boolean result = false;

		if(rowNumber > 0) {

			//update成功
			return true;

		}
		return result;
	}


	//1件削除メソッド
    public boolean deleteOne(String userId) {

    	//1件削除メソッド
    	int rowNumber = dao.deleteOne(userId);

    	//判定用変数
    	boolean result = false;


    	if (rowNumber > 0) {

    		//delete成功
    		return true;
    	}
    	return result;
    }


    //ユーザー一覧をCSVに出力する
    //UserDaoJdbcImplの"userCsvOut"を呼び出し
    public void userCsvOut() throws DataAccessException {

    	//CSV出力
    	dao.userCsvOut();
    }

    //サーバーに保存されているファイルを取得して、byte配列に変換する
    public byte[] getFile(String fileName)throws IOException {

    	//ファイルシステム(デフォルト)の取得
    	FileSystem fs = FileSystems.getDefault();

    	//ファイルを取得
    	Path p = fs.getPath(fileName);

    	//ファイルをbyte配列に変換
    	byte[] bytes = Files.readAllBytes(p);

    	return bytes;
    }
}