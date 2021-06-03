package network_exam.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import network_exam.dto.Employee;
import network_exam.exception.DuplicateEmployeeException;
import network_exam.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
		
		@Autowired
		private EmployeeService service;
		
		
		@GetMapping("/employees")
		public ResponseEntity<Object> employees(){
			System.out.println("employees()");
			return ResponseEntity.ok(service.getLists());
		}
		
		@GetMapping("/employees/{empNo}")
		public ResponseEntity<Object> employee(@PathVariable  int empNo, HttpServletResponse response){
			Employee employee =  service.getEmployee(empNo);
			if(employee == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.ok(employee);
		}
		
		@PostMapping("/employees")
		public ResponseEntity<Object> newEmployee(@RequestBody Employee employee){			
			try {
				service.registerEmployee(employee);
				
				URI uri = URI.create("/api/employees" + employee.getEmpNo());
				return ResponseEntity.created(uri).body(employee.getEmpNo());
				
			}catch(DuplicateEmployeeException e) {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}		
		
		@PatchMapping("/employees")
		public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee){
			System.out.println("updateEmployee > "+ employee);
			return ResponseEntity.ok(service.modifyEmployee(employee));
		}
		
		@DeleteMapping("/employees")
		public ResponseEntity<Object> deleteEmployeer(@RequestBody Employee employee){			
			System.out.println("deleteEmployeer > "+ employee);			
			return ResponseEntity.ok(service.removeEmployee(employee));
		}
		
		
		
}
