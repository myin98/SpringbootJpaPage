package com.app.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "user")
@Table(name = "user2")
public class UserEntity {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "user_pwd", length = 255, nullable = false)
	private String userPwd;
	
	@Column(name = "user_nm", unique = true, length = 100, nullable = false)
	private String userNm;
	
	@Column(name = "del_yn", nullable = false, columnDefinition = "boolean default false")
	private boolean delYn;
	
	@Column(name = "reg_date")
	@CreationTimestamp
	private LocalDateTime regDate;
	
	@ManyToMany
	@JoinTable(
			name = "urmapping",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_no")
			)
	private Set<RoleEntity> roles = new HashSet<>();
	
}
