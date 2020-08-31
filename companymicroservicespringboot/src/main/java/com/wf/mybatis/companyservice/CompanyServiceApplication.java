package com.wf.mybatis.companyservice;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wf.mybatis.companyservice.model.Company;
import com.wf.mybatis.companyservice.model.Users;

@MappedTypes(Users.class)
@MapperScan("com.wf.mybatis.companyservice.mapper")
@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}
}
