package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UserEntity;
import com.app.service.UserService;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home () {
		return "test";
	}
	
	@Autowired
	private UserService uService;
	
	@GetMapping("findByUserNm") 
	public List<UserEntity> findByUserNm() {
//		return uService.findByUserNm();
//		return uService.findByUserNmAndUserPwd();
//		return uService.findByUserNmLike();
//		return uService.findByUserNmStartingWith();
//		return uService.findByUserNmEndingWith();
		return uService.findByUserNmContaining();
	}
	
	@GetMapping("/reservation")
	public String reservation() {
		return "reservation";
	}
	
	@GetMapping("/topreservation")
	public String topreservation() {
		return "topreservation";
	}
	
	@GetMapping("/monthreservation")
	public String monthreservation() {
		return "monthreservation";
	}
	
	@GetMapping("/help")
	public String help() {
		return "help";
	}
	@GetMapping("/help2")
	public String help2() {
		return "help2";
	}
	@GetMapping("/help3")
	public String help3() {
		return "help3";
	}
	@GetMapping("/dinedetail")
	public String dinedetail() {
		return "dinedetail";
	}
	
	@GetMapping("/managerReserveList")
	public String managerReserveList() {
		return "managerReserveList";
	}
	
	
	
}
