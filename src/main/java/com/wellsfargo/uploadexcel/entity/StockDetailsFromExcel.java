package com.wellsfargo.uploadexcel.entity;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_price")
public class StockDetailsFromExcel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id")
	private int stock_id;
	
	@Column(name = "company_id")
	private String companyCode;	
	
	@Column(name = "exchange_id")
	private String stockExchangeCode;
	
	@Column(name = "price")
	private String pricePerShare;
	
	@Column(name = "date")
	private String date;	
	
	@Column(name = "time")
	private String time;

	public StockDetailsFromExcel() {}
	
	public StockDetailsFromExcel(String companyCode, String stockExchangeCode, String pricePerShare,
			String date, String time) {
		this.companyCode = companyCode;
		this.stockExchangeCode = stockExchangeCode;
		this.pricePerShare = pricePerShare;
		this.date = date;
		this.time = time;
	}
	
	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchangeCode() {
		return stockExchangeCode;
	}

	public void setStockExchangeCode(String stockExchangeCode) {
		this.stockExchangeCode = stockExchangeCode;
	}

	public String getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(String pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StockDetailsFromExcel [stock_id=" + stock_id + ", companyCode=" + companyCode + ", stockExchangeCode="
				+ stockExchangeCode + ", pricePerShare=" + pricePerShare + ", date=" + date + ", time=" + time + "]";
	}	
}



