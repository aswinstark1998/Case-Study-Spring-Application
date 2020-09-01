package com.companyMicroservices.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;
	private String company_name;
	private String turnover;
	private String ceo;
	private String board_of_directors;
	private String write_up;
	private int sector_id;
	public int getCompany_id() {
		return company_id;
	}

	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoard_of_directors() {
		return board_of_directors;
	}
	public void setBoard_of_directors(String board_of_directors) {
		this.board_of_directors = board_of_directors;
	}
	
	public int getSector_id() {
		return sector_id;
	}
	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}

	public String getWrite_up() {
		return write_up;
	}

	public void setWrite_up(String write_up) {
		this.write_up = write_up;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	  

}