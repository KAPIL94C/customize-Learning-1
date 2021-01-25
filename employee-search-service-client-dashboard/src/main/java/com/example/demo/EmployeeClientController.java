package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.EmployeeInfo;

@RestController
public class EmployeeClientController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/findAll")
	public List<EmployeeInfo> getemployeeAll() 
   { 
		String url="http://EMPLOLYEE-SEARCH:8081/employee/findAll/";
		return (List<EmployeeInfo>) restTemplate.getForObject(url, EmployeeInfo.class);

		} 
	
	
	@GetMapping("/{id}")
	public EmployeeInfo getemployeeRecord(@PathVariable int id)
   { 
		String url="http://EMPLOYEE-SEARCH:8081/employee/find/"+id;

		return restTemplate.getForObject(url, EmployeeInfo.class);
		} 
	
	@PostMapping("/addEmployee") 
	public String addemployeeRecord(@RequestBody EmployeeInfo emp) {
		
	
		String url="http://EMPLOYEE-SEARCH:8081/addEmployee/";
		return restTemplate.postForObject(url, emp, String.class); 
		
	}
	
//	@PostMapping("/updateEmployee/{id}") 
//	public String updateemployee(@RequestBody EmployeeInfo emp, @PathVariable int id) {
//		
//	
//		String url="http://EMPLOYEE-SEARCH:8081/employee/update/"+id;
//		return restTemplate.put(url, emp , String.class);
//		
//	}
	
	@DeleteMapping("/deleteEmployee/{id}") 
	public void deleteemployeeRecord(@PathVariable int id) {
		
		System.out.println("in delete method");
		String url="http://EMPLOYEE-SEARCH:8081/employee/delete/"+id;
		System.out.println("in delete method"+url);
		restTemplate.delete(url);
		
	}
	
	
	}
