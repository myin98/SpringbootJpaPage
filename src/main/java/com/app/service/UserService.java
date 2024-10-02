package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.UserEntity;
import com.app.repository.UserEntityRepository;

@Service
public class UserService {

	@Autowired
	private UserEntityRepository uRepository;
	
	public UserEntity findByUserNm() {
		return uRepository.findByUserNm("고길동").orElseThrow();
	}
	
	public UserEntity findByUserNmAndUserPwd() {
		return uRepository.findByUserNmAndUserPwd("고길동", "1234").orElseThrow();
	}
	
	public List<UserEntity> findByUserNmLike() {
		String userNm = "길동";
		return uRepository.findByUserNmLike("%"+userNm+"%");
	}
	public List<UserEntity> findByUserNmStartingWith() {
		return uRepository.findByUserNmStartingWith("길동");
	}
	public List<UserEntity> findByUserNmEndingWith() {
		return uRepository.findByUserNmEndingWith("길동");
	}
	public List<UserEntity> findByUserNmContaining() {
		return uRepository.findByUserNmContaining("길동");
	}
	
}
