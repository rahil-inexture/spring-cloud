package com.spring.cloud.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.user.vo.ResponseTemplateVO;
import com.spring.cloud.user.controller.UserController;
import com.spring.cloud.user.entity.Department;
import com.spring.cloud.user.entity.User;
import com.spring.cloud.user.repository.UserRepository;

@Service
public class UserService {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("Inside the save mehod of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(), Department.class);
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		
		return responseTemplateVO;
	}
	
	
}
