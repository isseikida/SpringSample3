package com.example.demo.trySpring.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.trySpring.login.repository.service.UserService;



@Controller
public class HomeController {


	@Autowired
	UserService userservice;

	//ユーザー一覧画面のGET用メソッド
	@GetMapping("/home")
	public String getHome(Model model) {

		//コンテンツ部分にユーザー一覧を表示するための文字列を登録
		//homeLayout.html内に「th:include="login/home :: home_contents"」右記の値が格納される
		model.addAttribute("contents","login/home::home_contents");

		return "login/homeLayout";
	}



	//ログアウト用メソッド
	@PostMapping("/logout")
	public String postLogout() {


		//ログイン画面にリダイレクト
		return "redirec:/login";
	}

}
