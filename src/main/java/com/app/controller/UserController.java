package com.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.RoleEntity;
import com.app.model.UserEntity;
import com.app.repository.RoleEntityRepository;
import com.app.repository.UserEntityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@GetMapping("/users")
	public String users(Model model, 
			@RequestParam(name = "userNm", required = false, defaultValue = "") String userNm,
			@PageableDefault(size = 3) Pageable pageable) {
		Page<UserEntity> users = uER.findByUserNmContaining(userNm, pageable);
		
		int cnt = 5;
		int end = Math.min(users.getTotalPages(), users.getPageable().getPageNumber() + cnt);
		int start = Math.max(1, end - (cnt - 1));
		
		model.addAttribute("users", users);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		
		
		return "user";
	}
	
	@Autowired
	private UserEntityRepository uER;
	
	@Autowired
	private RoleEntityRepository rER;
	
	@GetMapping("/grant")
	public String grant() {
//		RoleEntity role1 = rER.findById(1).orElseThrow();
//		RoleEntity role2 = rER.findById(2).orElseThrow();
//
//		
//		UserEntity user = uER.findById(1).orElseThrow();
//
//		
//		Set<RoleEntity> roles = new HashSet<>();
//		roles.add(role1);
//		roles.add(role2);
//		user.setRoles(roles);
		
		UserEntity user = uER.findById(1).orElseThrow();
		
		Set<RoleEntity> roles = new HashSet<>();
		RoleEntity role = rER.findById(1).orElseThrow();
		roles.add(role);
		user.setRoles(roles);
		
		uER.save(user);
		
		return "redirect:/users";
	}
	
	@ResponseBody
	@GetMapping("/detail/{userId}")
	public UserEntity detail(@PathVariable("userId") Integer userId) {
		UserEntity user = uER.findById(userId).orElseThrow();
		return user;
		
	}
	
	
	
	
}
