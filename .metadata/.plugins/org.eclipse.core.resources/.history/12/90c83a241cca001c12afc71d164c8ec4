package com.spring.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		
		return "User service longer than expected. Please Try Again Later";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		
		return "Department service longer than expected. Please Try Again Later";
	}
}
