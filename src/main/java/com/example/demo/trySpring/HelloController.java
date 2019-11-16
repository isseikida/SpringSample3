package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




//ポイント1 : @Controller
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;


	//ポイント2 : @GetMapping
	@GetMapping("/hello")
	public String getHello() {

		//hello.htmlに画面遷移
		return "/hello";
	}

	//NO.399 : @PostMapping
	//NO.399 : @RequestParam
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str,Model model) {



		//画面から受け取った文字列をModelに登録
		model.addAttribute("sample" , str);

		//helloRequest.htmlに画面に遷移
		//src/main/resource配下のhtmlファイルから探してくるため、そのファイル名と一致していないと遷移しない
		return "helloResponse";

	}


	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String str,Model model) {

		//Stringからint型に変更
		int id = Integer.parseInt(str);

		//1件検索
		Employee employee = helloService.findOne(id);

		//検索結果をModelに登録
		model.addAttribute("id",employee.getEmployeeId());
		model.addAttribute("firstname",employee.getEmployeeFirstname());
		model.addAttribute("lastname",employee.getEmployeeLastname());
		model.addAttribute("age",employee.getAge());
		model.addAttribute("number",employee.getNumber());


		//helloResponseDB.htmlに画面遷移
		return "helloResponseDB";

	}




    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "佐々木さんのタスク完了!!";
    }


}

