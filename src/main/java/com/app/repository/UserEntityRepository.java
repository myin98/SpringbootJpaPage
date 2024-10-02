package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
	
	// https://docs.spring.io/spring-data/jpa/reference/3.2/jpa/query-methods.html#jpa.query-methods.query-creation
	
	// 1. 이름 검색 조건 (해당 사용자 이름 조회) where user_nm = '고길동'
	public Optional<UserEntity> findByUserNm(String userNm); 
	
	// 2. 이름과 비밀번호 검색 조건 : where user_nm = '고길동' and user_pwd = '1234'
	public Optional<UserEntity> findByUserNmAndUserPwd(String userNm, String userPwd);
	
	// 3. 이름 검색 조건 (비슷한 이름 조회) where user_nm like '%길%'
	public List<UserEntity> findByUserNmLike(String userNm);  			// 변수의 값에 와일드카드의 기호를 추가하여 사용하여야 한다. : "%", "_"
	public List<UserEntity> findByUserNmStartingWith(String userNm);	// 변수의 뒤로 오는 값에 대하여 알아서 찾아준다 : 변수 + "%"
	public List<UserEntity> findByUserNmEndingWith(String userNm);		// 변수의 앞에 오는 값에 대하여 알아서 찾아준다 : "%" + 변수
	public List<UserEntity> findByUserNmContaining(String userNm);		// 변수의 앞과 뒤에 오는 값에 대하여 찾아준다  : "%" + 변수 + "%"
	
	// 사용자 목록 페이징 처리
	public Page<UserEntity> findByUserNmContaining(String userNm, Pageable pageable);
	

}
