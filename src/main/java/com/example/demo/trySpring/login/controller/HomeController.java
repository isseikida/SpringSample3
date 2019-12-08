package com.example.demo.trySpring.login.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.trySpring.domain.model.SignupForm;
import com.example.demo.trySpring.login.domain.model.User;
import com.example.demo.trySpring.login.repository.service.UserService;



@Controller
public class HomeController {


	@Autowired
	UserService userService;

	//結婚ステータスのラジオボタン用変数
	private Map<String,String>radioMarriage;

	//ラジオボタンの初期化メソッド(ユーザー登録画面と同じ)
	private Map<String,String>initRadioMarrige(){
		Map<String,String>radio=new LinkedHashMap<>();

		//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚","false");

		return radio;
	}


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

//ユーザー詳細画面のGET用メソッド
	@GetMapping("/userDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute SignupForm form,Model model,@PathVariable("id")String userId) {

		//ユーザーID確認(デバック)
		System.out.println("userId="+ userId);

		//コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents","login/userDetail::userDetail_contents");

		//結婚ステータス用ラジオボタンの初期化
		radioMarriage=initRadioMarrige();

		//ラジオボタン用のMapをModelに登録
		model.addAttribute("radioMarriage",radioMarriage);

		//ユーザーIDのチェック
		if(userId !=null && userId.length() > 0) {

			//ユーザー情報を取得
			User user = userService.selectOne(userId);

			//Userクラスをフォームクラスに変換
			form.setUserId(user.getUserId());
			form.setUserName(user.getUserName());
			form.setBirthday(user.getBirthday());
			form.setAge(user.getAge());
			form.setMarriage(user.isMarriage());

			//Modelに登録
			model.addAttribute("signupForm",form);
		}
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
