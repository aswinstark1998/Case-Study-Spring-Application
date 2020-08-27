package com.stock.stockmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_company")
public class Company {
	@Id
	private int companyId;
	private String companyName;
	private int turnover;
	private String ceo;
	private String bod;
	private String sector;
	private String writeup;
	private String comp_stock_code;
}
