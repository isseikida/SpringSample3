package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;

	public Employee findOne(int id) {

		//１件検索実行
		Map<String , Object>map = helloRepository.findOne(id);

		//Mapから値を取得
		int employeeId = (Integer)map.get("employee_id");
		String employeeFirstname = (String)map.get("employee_firstname");
		String employeeLastname = (String)map.get("employee_lastname");
		int age = (Integer)map.get("age");
		int number = (Integer)map.get("number");



		//Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeFirstname(employeeFirstname);
		employee.setEmployeeLastname(employeeLastname);
		employee.setAge(age);
		employee.setNumber(number);


		return employee;

	}
}
