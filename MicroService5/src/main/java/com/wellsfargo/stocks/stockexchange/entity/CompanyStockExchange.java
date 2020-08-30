package com.wellsfargo.stocks.stockexchange.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companystockexchange")
public class CompanyStockExchange {
	@Id
	private int id;
	private int exchangecode;
	public CompanyStockExchange() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExchangecode() {
		return exchangecode;
	}
	public void setExchangecode(int exchangecode) {
		this.exchangecode = exchangecode;
	}
	
	
}
