package com.techprimers.mybatis.springbootmybatis.model;

import java.sql.Date;

public class IPO {

	private int ipoId;
	private float pricePerShare;
	private String numOfShares;
	private Date openDate;
	private String remarks;
	private String companyName;
	public int getIpoId() {
		return ipoId;
	}
	public void setIpoId(int ipoId) {
		this.ipoId = ipoId;
	}
	public float getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public String getNumOfShares() {
		return numOfShares;
	}
	public void setNumOfShares(String numOfShares) {
		this.numOfShares = numOfShares;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCompany() {
		return companyName;
	}
	public void setCompany(String company) {
		this.companyName = company;
	}
	@Override
	public String toString() {
		return "IPO [ipoId=" + ipoId + ", pricePerShare=" + pricePerShare + ", numOfShares=" + numOfShares
				+ ", openDate=" + openDate + ", remarks=" + remarks + ", company=" + companyName + "]";
	}
	
    
   
}
