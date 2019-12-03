package com.example.demo.trySpring.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.trySpring.login.domain.model.User;
import com.example.demo.trySpring.login.repository.service.UserService;



@Controller
public class HomeController {


	@Autowired
	UserService userService;

	//ユーザー一覧画面のGET用メソッド
	@GetMapping("/home")
	public String getHome(Model model) {

		//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		//homeLayout.html内に「th:include="login/home :: home_contents"」右記の値が格納される
		model.addAttribute("contents","login/home::home_contents");

		return "login/homeLayout";
	}

	//ユーザー一覧画面のGET用メソッド
	@GetMapping("/userList")
	public String getUserList(Model model) {

		//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		model.addAttribute("contents","login/userList::userList_contents");

		//ユーザー一覧の生成
		List<User>userList=userService.selectMany();

		//Modelにユーザーリストを登録
		model.addAttribute("userList",userList);

		//データ件数を取得
		int count = userService.count();
		model.addAttribute("userListCount",count);

		return "login/homeLayout";
	}



	//ログアウト用メソッド
	@PostMapping("/logout")
	public String postLogout() {


		//ログイン画面にリダイレクト
		return "redirec:/login";
	}


	//ユーザー一覧のCSV出力用メソッド
	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {

		//現段階では、何もせずにユーザー一覧に戻るだけ
		return getUserList(model);
	}

}
