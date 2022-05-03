package com.spring.cloud.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.department.entity.Department;
import com.spring.cloud.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside the save mehod of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {
		log.info("Inside the save mehod of DepartmentController");
		return departmentService.findByDepartmentId(id);
	}
}
