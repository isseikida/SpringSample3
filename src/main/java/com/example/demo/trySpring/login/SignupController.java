package com.example.demo.trySpring.login;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class SignupController {

	//NO.1294 : ラジオボタンの実装
	private Map<String,String>radioMarriage;

	//ラジオボタンの初期化メソッド
	private Map<String,String>initRadioMarrige(){

		Map<String,String>radio = new LinkedHashMap<>();

		//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚" , "false");

		return radio;
	}



	//ユーザー登録画面のGET用コントローラー
	@GetMapping("/signup")
	public String getSignUp(Model model) {

		//ラジオボタンの初期化メソッド呼び出し
		radioMarriage = initRadioMarrige();

		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage",radioMarriage);

		//signup.htmlに画面遷移
		return "login/signup";
	}



	//ユーザー登録画面のPost用コントローラー
	@PostMapping("/signup")
	public String postSignUp(Model model) {

		//login.htmlにリダイレクト
		return "redirect:/login";
	}











}

