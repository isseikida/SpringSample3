package com.example.demo.trySpring.login;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.trySpring.domain.model.SignupForm;




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
	public String getSignUp(@ModelAttribute SignupForm form ,Model model) {

		//ラジオボタンの初期化メソッド呼び出し
		radioMarriage = initRadioMarrige();

		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage",radioMarriage);

		//signup.htmlに画面遷移
		return "login/signup";
	}




	//ユーザー登録画面のPost用コントローラー
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form ,BindingResult bindingResult ,Model model) {

		//データバインド失敗の場合
		//入力チェックに引っかかった場合、ユーザー登録画面に戻る
		if(bindingResult.hasErrors()) {

			//GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
			return getSignUp(form,model);
		}


		//formの中身をコンソールに出して確認します
		System.out.println(form);

		//login.htmlにリダイレクト
		return "redirect:/login";
	}




}

