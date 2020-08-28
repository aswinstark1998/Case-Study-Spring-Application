package com.wellsfargo.stock.stockexchange.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockExchangeDAO {
	
	@Id
	private int sid;
	private String brief;
	private String contactaddress;
	private String remarks;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactaddress() {
		return contactaddress;
	}
	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
