package com.liam.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.liam.userservice.VO.Department;
import com.liam.userservice.VO.ResponseTemplateVO;
import com.liam.userservice.models.User;
import com.liam.userservice.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;



	public User createUser(User user) {
		log.info("Service: Creating User");
		return userRepo.save(user);
	}
	
	



	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Service: getUserWithDepartment");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepo.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		
		return vo;
	}



	
}
