package com.stock.stockmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="UserTable")
@Setter
@Getter
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	private String email;
	private boolean admin;
	private boolean active;
	private String mobile;
}
