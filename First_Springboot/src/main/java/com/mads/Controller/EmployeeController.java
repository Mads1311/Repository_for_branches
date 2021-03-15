package com.mads.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mads.entity.Employee;
import com.mads.service.Employee_Impl;
import com.mads.service.Employee_i;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	Employee_i ei = new Employee_Impl();

	@PostMapping(value = "/save_employee")
	public String saveEmployee(@RequestBody Employee employee) {
		System.out.println("In controller");
		String msg = ei.saveEmployee(employee);
		return msg;
	}
	
	@DeleteMapping(value="/deleteemp/{eid}")
	public ResponseEntity<String> deleteemp(@PathVariable ("eid") int id)
	{
		String msg = ei.deleteemp(id);
		if(msg!=null)
		return  new ResponseEntity<>(msg,HttpStatus.MOVED_PERMANENTLY);
		else
			return new ResponseEntity<>(msg,HttpStatus.FORBIDDEN);
				
	}
	@GetMapping(value="/show-employee")
	public ResponseEntity<List<Employee>> showemp()
	{
		List<Employee> list = ei.showemp();
		if(!list.isEmpty())
		return new ResponseEntity<>(list,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@PutMapping(value="/update-employee")
	public ResponseEntity<Integer> updateemp(@RequestBody Employee employee)
	{
		int id = ei.updateemp(employee);
		if (id!= 0)
		return new ResponseEntity<>(id,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
				
	}
	
	@PutMapping("/updatebyid/{id}")
	public ResponseEntity<Integer> updatebyid(@RequestBody Employee employee ,@PathVariable ("id") int id1)
	{
		int id =ei.updatebyid(employee,id1);
		if (id!= 0)
			return new ResponseEntity<>(id,HttpStatus.CREATED);
			else
				return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}
	@GetMapping(value="/getempbysalary/{salary}")
	public ResponseEntity< List <Employee>> getempbysalary(@PathVariable ("salary") Double  salary)
	{
		 List <Employee> list = new ArrayList<>();
		list = ei.getempbysalary(salary);
		
		if(!list.isEmpty())
		return new ResponseEntity<>(list,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(value="/getempbysalary_dept/{salary}/{dept}")
	public ResponseEntity< List <Employee>> getempbysalary_dept(@PathVariable ("salary") Double  salary,@PathVariable ("dept") String dept)
	{
		 List <Employee> list = new ArrayList<>();
		list = ei.getempbysalary_dept(salary,dept);
		
		if(!list.isEmpty())
		return new ResponseEntity<>(list,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(value="/getempbydept_distinct")
	public ResponseEntity< List <Employee>> getempbydept_distinct()
	{
		 List <Employee> list = new ArrayList<>();
		list = ei.getempbydept_distinct();
		
		if(!list.isEmpty())
		return new ResponseEntity<>(list,HttpStatus.FOUND);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

}
